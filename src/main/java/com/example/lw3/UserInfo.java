package com.example.lw3;

public class UserInfo {

    final private int id;
    final private String name;
    final private String phone;
    final private boolean enabled;

    public UserInfo(int id, String name, String phone, boolean enabled) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
