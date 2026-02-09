package com.ems.employee_management_system.entity;

public enum Department {
    DEV(1),
    QA(2),
    HR(3);

    private final int id;

    Department(int id) {
        this.id = id;
    }

    public static Department fromId(int id) {
        for(Department d : values()) {
            if(id == d.id) {
                return d;
            }
        }
        throw new IllegalArgumentException(("Invalid department id: " + id));
    }
}
