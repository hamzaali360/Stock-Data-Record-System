package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mp_EntityManagerFactory",
        transactionManagerRef = "mp_TransactionManager",
        basePackages = {"com.example.demo.morningpanic.repositories"})
public class MorningPanicDbConfig {

    @Primary
    @Bean(name = "mp_DataSource")
    @ConfigurationProperties("morningpanic.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mp_EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mp_DataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.demo.morningpanic.entities").persistenceUnit("morningpanic")
                .build();
    }

    @Primary
    @Bean(name = "mp_TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mp_EntityManagerFactory") EntityManagerFactory mp_EntityManagerFactory) {
        return new JpaTransactionManager(mp_EntityManagerFactory);
    }

}