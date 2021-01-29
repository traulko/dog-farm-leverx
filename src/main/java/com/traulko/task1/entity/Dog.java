package com.traulko.task1.entity;

import com.traulko.task1.entity.state.DogState;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Dog {
    private int dogId;
    private boolean isHealthy;
    private boolean isFed;
    private boolean isTrained;
    private LocalDate birthDate;
    private DogState dogState;

    public void feed() {
        dogState.feed();
    }

    public void doActivity() {
        dogState.doActivity();
    }
}
