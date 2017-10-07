package com.nazar.dto;

public enum UserRole {
    CLIENT, ADMIN;

    public static UserRole parseRole(String role){
        if(ADMIN.name().equals(role)){
            return ADMIN;
        }
        else if(CLIENT.name().equals(role)){
            return CLIENT;
        }
        throw new RuntimeException("No such role!");
    }
}
