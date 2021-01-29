package com.traulko.task1;

import com.traulko.task1.entity.Dog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setDogId(1);
        dog1.setHealthy(true);
        dog1.setFed(false);
        dog1.setTrained(true);
        dog1.setBirthDate(LocalDate.now().minusYears(2));

        Dog dog2 = new Dog();
        dog2.setDogId(2);
        dog2.setHealthy(false);
        dog2.setTrained(false);
        dog2.setFed(false);
        dog2.setBirthDate(LocalDate.now().minusYears(10));

        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog1);
        dogList.add(dog2);

        FarmWorker farmWorker = FarmWorker.getInstance();
        farmWorker.fillAviariesMap(dogList);
        farmWorker.setDogList(dogList);
        farmWorker.startDay();
    }
}
