package com.edatablock.template;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TemplateFields.
 */

public class TemplateFields implements Serializable {

    private static final long serialVersionUID = 1L;


    private String fileName;
    private String Key;

    private Double fieldZoneMinX;

    private Double fieldZoneMinY;


    private Double fieldZoneMaxX;


    private Double fieldZoneMaxY;


    private Integer fieldValidationRequire;


    private String fieldValidationRule;

    private Double width;
    private Double height;

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public TemplateFields(String Key,String fileName, Double fieldZoneMinX, Double fieldZoneMinY, Double fieldZoneMaxX, Double fieldZoneMaxY, Double width, Double height) {
        this.fileName = fileName;
        this.Key=Key;
        this.fieldZoneMinX = fieldZoneMinX;
        this.fieldZoneMinY = fieldZoneMinY;
        this.fieldZoneMaxX = fieldZoneMaxX;
        this.fieldZoneMaxY = fieldZoneMaxY;
        this.width=width;
        this.height=height;


    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getFileName() {
        return fileName;
    }

    public TemplateFields fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getFieldZoneMinX() {
        return fieldZoneMinX;
    }

    public TemplateFields fieldZoneMinX(Double fieldZoneMinX) {
        this.fieldZoneMinX = fieldZoneMinX;
        return this;
    }

    public void setFieldZoneMinX(Double fieldZoneMinX) {
        this.fieldZoneMinX = fieldZoneMinX;
    }

    public Double getFieldZoneMinY() {
        return fieldZoneMinY;
    }

    public TemplateFields fieldZoneMinY(Double fieldZoneMinY) {
        this.fieldZoneMinY = fieldZoneMinY;
        return this;
    }

    public void setFieldZoneMinY(Double fieldZoneMinY) {
        this.fieldZoneMinY = fieldZoneMinY;
    }

    public Double getFieldZoneMaxX() {
        return fieldZoneMaxX;
    }

    public TemplateFields fieldZoneMaxX(Double fieldZoneMaxX) {
        this.fieldZoneMaxX = fieldZoneMaxX;
        return this;
    }

    public void setFieldZoneMaxX(Double fieldZoneMaxX) {
        this.fieldZoneMaxX = fieldZoneMaxX;
    }

    public Double getFieldZoneMaxY() {
        return fieldZoneMaxY;
    }

    public TemplateFields fieldZoneMaxY(Double fieldZoneMaxY) {
        this.fieldZoneMaxY = fieldZoneMaxY;
        return this;
    }

    public void setFieldZoneMaxY(Double fieldZoneMaxY) {
        this.fieldZoneMaxY = fieldZoneMaxY;
    }

    public Integer getFieldValidationRequire() {
        return fieldValidationRequire;
    }

    public TemplateFields fieldValidationRequire(Integer fieldValidationRequire) {
        this.fieldValidationRequire = fieldValidationRequire;
        return this;
    }

    public void setFieldValidationRequire(Integer fieldValidationRequire) {
        this.fieldValidationRequire = fieldValidationRequire;
    }

    public String getFieldValidationRule() {
        return fieldValidationRule;
    }

    public TemplateFields fieldValidationRule(String fieldValidationRule) {
        this.fieldValidationRule = fieldValidationRule;
        return this;
    }

    public void setFieldValidationRule(String fieldValidationRule) {
        this.fieldValidationRule = fieldValidationRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateFields that = (TemplateFields) o;
        return Objects.equals(fileName, that.fileName) &&
                Objects.equals(Key, that.Key) &&
                Objects.equals(fieldZoneMinX, that.fieldZoneMinX) &&
                Objects.equals(fieldZoneMinY, that.fieldZoneMinY) &&
                Objects.equals(fieldZoneMaxX, that.fieldZoneMaxX) &&
                Objects.equals(fieldZoneMaxY, that.fieldZoneMaxY) &&
                Objects.equals(fieldValidationRequire, that.fieldValidationRequire) &&
                Objects.equals(fieldValidationRule, that.fieldValidationRule) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height);
    }

    @Override
    public String toString() {
        return "TemplateFields{" +
                "fileName='" + fileName + '\'' +
                ", Key='" + Key + '\'' +
                ", fieldZoneMinX=" + fieldZoneMinX +
                ", fieldZoneMinY=" + fieldZoneMinY +
                ", fieldZoneMaxX=" + fieldZoneMaxX +
                ", fieldZoneMaxY=" + fieldZoneMaxY +
                ", fieldValidationRequire=" + fieldValidationRequire +
                ", fieldValidationRule='" + fieldValidationRule + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
