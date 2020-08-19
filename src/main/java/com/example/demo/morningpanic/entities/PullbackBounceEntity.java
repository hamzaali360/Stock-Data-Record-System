package com.example.demo.morningpanic.entities;


import com.example.demo.common.models.Bounce;

import javax.persistence.*;

@Entity
@Table(name="pullback_bounce")
public class PullbackBounceEntity extends Bounce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pullback_bounce_generator")
    @SequenceGenerator(name="pullback_bounce_generator", sequenceName = "pb_seq", allocationSize = 1)
    public int bounceId;

    public int dataId;

    public PullbackBounceEntity(){
        bounceId = 0;
        dataId = 0;
    }

}
