package com.example.demo.morningpanic.entities;


import com.example.demo.common.models.Bounce;

import javax.persistence.*;

@Entity
@Table(name="failed_bounce")
public class FailedBounceEntity extends Bounce {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "failed_bounce_generator")
    @SequenceGenerator(name="failed_bounce_generator", sequenceName = "fb_seq", allocationSize = 1)
    public int bounceId;

    public int dataId;

    public FailedBounceEntity(){
        bounceId = 0;
        dataId = 0;
    }
}
