package com.pacific.example;

public class ExploreBean {

    private int iconResId;
    private String name;
    private String description;
    private String type;

    public ExploreBean(String type,int iconResId, String name, String description) {
        this.type=type;
        this.iconResId = iconResId;
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getType() {
        return type;
    }
}
