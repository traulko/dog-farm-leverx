package com.traulko.task1.entity;

import com.traulko.task1.entity.staff.impl.CleanerStaffImpl;
import com.traulko.task1.entity.staff.Staff;
import lombok.Data;

@Data
public class Aviary {
    private Staff staff;
    private Dog dog;
    private boolean occupied;
    private boolean isClean;

    public Aviary(Dog dog) {
        this.dog = dog;
        staff = new CleanerStaffImpl();
    }

    public void setOccupied(boolean occupied) {
        if (!occupied) {
            staff.serve(this);
            System.out.println("Aviary of dogId " + dog.getDogId() + " clean");
        }
        this.occupied = occupied;
    }
}
