package com.traulko.task1.entity.state;

import com.traulko.task1.entity.Dog;

public abstract class DogState {
    protected Dog dog;

    public DogState(Dog dog) {
        this.dog = dog;
    }

    public abstract void feed();

    public abstract void doActivity();
}
