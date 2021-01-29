package com.traulko.task1.entity.handler.impl;

import com.traulko.task1.entity.Aviary;
import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.handler.DogHandler;

public class Feeder extends DogHandler {

    @Override
    public void handle(Dog dog) {
        System.out.println("Morning meal, dogId - " + dog.getDogId());
        dog.feed();
        Aviary aviary = farmManager.getAviaryByDogId(dog.getDogId());
        System.out.println(dog.getDogId() + " leave from aviary");
        aviary.setOccupied(false);
        nextHandle(dog);
        System.out.println("Evening meal, dogId - " + dog.getDogId());
        dog.feed();
    }
}
