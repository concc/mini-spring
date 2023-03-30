package com.minis.beans.inject;

public class PropertyValue {
    private final String type;
    private final String name;

    private final Object value;
    private final boolean isRef;

    public PropertyValue(String type, String name, Object value, boolean isRef) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.isRef = isRef;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean getIsRef() {
        return isRef;
    }

    public Object getValue() {
        return value;
    }
}
