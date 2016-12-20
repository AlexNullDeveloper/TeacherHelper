package com.dip.core.pojos;

/**
 * Created by Юрий on 30.10.2016.
 */
public class Faculty {
    private String vuz;
    private String name;

    public Faculty(String vuz, String name) {
        this.vuz = vuz;
        this.name = name;
    }

    public String getVuz() {
        return vuz;
    }

    public String getName() {
        return name;
    }
}
