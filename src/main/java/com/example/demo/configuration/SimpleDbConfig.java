package com.example.demo.configuration;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "s_EntityManagerFactory",
        transactionManagerRef = "s_TransactionManager",
        basePackages = {"com.example.demo.demo.repositories"})
public class SimpleDbConfig {


    @Bean(name = "s_DataSource")
    @ConfigurationProperties("simple.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "s_EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("s_DataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.demo.demo.entities").persistenceUnit("morningpanic")
                .build();
    }

    @Bean(name = "s_TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("s_EntityManagerFactory") EntityManagerFactory s_EntityManagerFactory) {
        return new JpaTransactionManager(s_EntityManagerFactory);
    }

}
