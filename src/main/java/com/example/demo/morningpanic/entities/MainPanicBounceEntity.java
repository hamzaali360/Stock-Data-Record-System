package com.example.demo.morningpanic.entities;

import com.example.demo.common.models.Bounce;

import javax.persistence.*;


@Entity
@Table(name="main_panic_bounce")
public class MainPanicBounceEntity extends Bounce {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "main_panic_bounce_generator")
    @SequenceGenerator(name="main_panic_bounce_generator", sequenceName = "mpd_seq", allocationSize = 1)
    public int panicBounceId;

    public int dataId;

    public MainPanicBounceEntity(){
        super();

        panicBounceId = 0;
        dataId = 0;
    }

}
