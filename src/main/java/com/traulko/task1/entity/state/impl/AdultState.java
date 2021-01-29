package com.traulko.task1.entity.state.impl;

import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.state.DogState;

public class AdultState extends DogState {
    public AdultState(Dog dog) {
        super(dog);
        dog.setTrained(true);
    }

    @Override
    public void feed() {
        System.out.println("Big portion, dogId - " + dog.getDogId());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println("Work, dogId - " + dog.getDogId());
    }
}
