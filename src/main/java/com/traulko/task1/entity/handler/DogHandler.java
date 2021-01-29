package com.traulko.task1.entity.handler;

import com.traulko.task1.FarmWorker;
import com.traulko.task1.entity.Dog;

public abstract class DogHandler {
    protected final FarmWorker farmManager = FarmWorker.getInstance();
    private DogHandler nextHandler;

    public DogHandler setNextHandler(DogHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(Dog dog);

    public void nextHandle(Dog dog) {
        if (nextHandler != null) {
            nextHandler.handle(dog);
        }
    }
}
