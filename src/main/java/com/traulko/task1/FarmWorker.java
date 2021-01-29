package com.traulko.task1;

import com.traulko.task1.entity.Aviary;
import com.traulko.task1.entity.Dog;
import com.traulko.task1.entity.handler.DogHandler;
import com.traulko.task1.entity.handler.impl.ActivitiesManager;
import com.traulko.task1.entity.handler.impl.Feeder;
import com.traulko.task1.entity.handler.impl.Vet;
import com.traulko.task1.entity.state.impl.AdultState;
import com.traulko.task1.entity.state.impl.ElderlyState;
import com.traulko.task1.entity.state.impl.PuppyState;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class FarmWorker {
    private static final int PUPPY_STATE_AGES = 0;
    private static final int ELDERLY_STATE_AGES = 6;

    private static FarmWorker instance;
    private List<Dog> dogList;
    private Map<Integer, Aviary> aviaryMap;
    private DogHandler handler;

    private FarmWorker() {
    }

    public static FarmWorker getInstance() {
        if (instance == null) {
            instance = new FarmWorker();
        }
        return instance;
    }

    public void fillAviariesMap(List<Dog> dogList) {
        this.dogList = dogList;
        aviaryMap = new HashMap<>();
        for (Dog dog : dogList) {
            aviaryMap.put(dog.getDogId(), new Aviary(dog));
        }
    }

    public Aviary getAviaryByDogId(int dogId) {
        return aviaryMap.get(dogId);
    }

    public void startDay() {
        setHandlers();
        for (Dog dog : dogList) {
            defineDogType(dog);
            handler.handle(dog);
        }
    }

    private void defineDogType(Dog dog) {
        int ages = Period.between(dog.getBirthDate(), LocalDate.now()).getYears();
        if (ages == PUPPY_STATE_AGES) {
            dog.setDogState(new PuppyState(dog));
        } else if (ages > ELDERLY_STATE_AGES) {
            dog.setDogState(new ElderlyState(dog));
        } else {
            dog.setDogState(new AdultState(dog));
        }
    }

    private void setHandlers() {
        Feeder handler = new Feeder();
        handler.setNextHandler(new Vet())
                .setNextHandler(new ActivitiesManager());
        this.handler = handler;
    }
}
