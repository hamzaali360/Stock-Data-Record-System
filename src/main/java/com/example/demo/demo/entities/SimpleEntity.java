package com.example.demo.demo.entities;



import javax.persistence.*;

@Entity
@Table(name="simple")
public class SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simple_generator")
    @SequenceGenerator(name="simple_generator", sequenceName = "s_seq", allocationSize = 1)
    public int dataId;

    public SimpleEntity(){

    }

}
