package com.traulko.task1.entity.handler.impl;

import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.handler.DogHandler;

public class Vet extends DogHandler {

    @Override
    public void handle(Dog dog) {
        if (!dog.isHealthy()) {
            dog.setHealthy(true);
            System.out.println("Dog was in hospital");
        }
        System.out.println(dog.getDogId() + " is healthy");
        nextHandle(dog);
    }
}
