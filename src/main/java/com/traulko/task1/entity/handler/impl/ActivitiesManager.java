package com.traulko.task1.entity.handler.impl;

import com.traulko.task1.entity.Aviary;
import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.handler.DogHandler;

public class ActivitiesManager extends DogHandler {
    @Override
    public void handle(Dog dog) {
        dog.doActivity();
        System.out.println("Activity finished! Dog goes home");
        Aviary aviary = farmManager.getAviaryByDogId(dog.getDogId());
        if (!aviary.isOccupied()) {
            aviary.setOccupied(true);
            System.out.println("Dog in aviary after work");
        }
        nextHandle(dog);
    }
}
