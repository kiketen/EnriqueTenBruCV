package com.linhoapps.tenbrucv.mvp.view_presenter.horizontalBarLibrary;

/**
 * Created by KTB on 01/03/2017.
 */
public class HorizontalBar {

    private String name;
    private float number;

    public HorizontalBar(String name, float number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
