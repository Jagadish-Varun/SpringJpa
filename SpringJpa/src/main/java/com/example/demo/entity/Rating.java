package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Rating {
    G, 
    PG, 
    PG_13,  // Change from PG-13 to PG_13 (Java does not allow `-` in enum names)
    R, 
    NC_17;  // Change from NC-17 to NC_17

    @JsonCreator
    public static Rating fromString(String value) {
        return Rating.valueOf(value.replace("-", "_"));
    }

    @Override
    public String toString() {
        return name().replace("_", "-");
    }
}
