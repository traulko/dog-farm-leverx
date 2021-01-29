package com.traulko.task1.entity.impl;

import com.traulko.task1.entity.Aviary;
import com.traulko.task1.entity.Staff;

public class CleanerStaffImpl implements Staff {
    @Override
    public void serve(Aviary aviary) {
        aviary.setClean(true);
    }
}
