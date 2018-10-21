package com.edatablock.util;

import java.awt.*;
import java.util.Objects;

public class ExtractOCRData {

    public String key;
    public String Value;
    public Rectangle Location;
    public String fileName;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Rectangle getLocation() {
        return Location;
    }

    public void setLocation(Rectangle location) {
        Location = location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtractOCRData that = (ExtractOCRData) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(Value, that.Value) &&
                Objects.equals(Location, that.Location) &&
                Objects.equals(fileName, that.fileName);
    }

    @Override
    public String toString() {
        return "ExtractOCRData{" +
                "key='" + key + '\'' +
                ", Value='" + Value + '\'' +
                ", Location=" + Location +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, Value, Location);
    }
}
