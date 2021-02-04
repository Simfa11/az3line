package com.example.az.enums;

public enum Outlet {

    AB("AB"), AC("AB");

    private String outlet;

    Outlet(String outlet) {
        this.outlet = outlet;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }
}
