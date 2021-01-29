package com.traulko.task1.entity.state.impl;

import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.state.DogState;

public class PuppyState extends DogState {
    public PuppyState(Dog dog) {
        super(dog);
        dog.setTrained(false);
    }

    @Override
    public void feed() {
        System.out.println("Small portion, dogId - " + dog.getDogId());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println("Trained");
        dog.setTrained(true);
    }
}
