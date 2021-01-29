package com.traulko.task1.entity.state.impl;

import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.state.DogState;
import com.traulko.task1.FarmWorker;

public class ElderlyState extends DogState {
    private final FarmWorker farmWorker = FarmWorker.getInstance();

    public ElderlyState(Dog dog) {
        super(dog);
        dog.setTrained(true);
    }

    @Override
    public void feed() {
        System.out.println("Medium portion, dogId -  " + dog.getDogId());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println("Rest");
        farmWorker.getAviaryByDogId(dog.getDogId()).setOccupied(true);
    }
}
