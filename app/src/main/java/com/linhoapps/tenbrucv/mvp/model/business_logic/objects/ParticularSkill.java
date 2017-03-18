package com.linhoapps.tenbrucv.mvp.model.business_logic.objects;

/**
 * Created by KTB on 03/03/2017.
 */

public class ParticularSkill {

    private String name;
    private float number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public ParticularSkill(String name, float number) {
        this.name = name;
        this.number = number;
    }
}
