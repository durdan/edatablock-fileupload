package com.edatablock.template;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TemplateFields.
 */

public class TemplateFields implements Serializable {

    private static final long serialVersionUID = 1L;


    private String fileName;

    private Double fieldZoneMinX;

    private Double fieldZoneMinY;


    private Double fieldZoneMaxX;


    private Double fieldZoneMaxY;


    private Integer fieldValidationRequire;


    private String fieldValidationRule;

    public TemplateFields(String fileName, Double fieldZoneMinX, Double fieldZoneMinY, Double fieldZoneMaxX, Double fieldZoneMaxY) {
        this.fileName = fileName;
        this.fieldZoneMinX = fieldZoneMinX;
        this.fieldZoneMinY = fieldZoneMinY;
        this.fieldZoneMaxX = fieldZoneMaxX;
        this.fieldZoneMaxY = fieldZoneMaxY;
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
        if (!(o instanceof TemplateFields)) return false;
        TemplateFields that = (TemplateFields) o;
        return Objects.equals(getFileName(), that.getFileName()) &&
                Objects.equals(getFieldZoneMinX(), that.getFieldZoneMinX()) &&
                Objects.equals(getFieldZoneMinY(), that.getFieldZoneMinY()) &&
                Objects.equals(getFieldZoneMaxX(), that.getFieldZoneMaxX()) &&
                Objects.equals(getFieldZoneMaxY(), that.getFieldZoneMaxY()) &&
                Objects.equals(getFieldValidationRequire(), that.getFieldValidationRequire()) &&
                Objects.equals(getFieldValidationRule(), that.getFieldValidationRule());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFileName(), getFieldZoneMinX(), getFieldZoneMinY(), getFieldZoneMaxX(), getFieldZoneMaxY(), getFieldValidationRequire(), getFieldValidationRule());
    }

    @Override
    public String toString() {
        return "TemplateFields{" +
                "fileName='" + fileName + '\'' +
                ", fieldZoneMinX=" + fieldZoneMinX +
                ", fieldZoneMinY=" + fieldZoneMinY +
                ", fieldZoneMaxX=" + fieldZoneMaxX +
                ", fieldZoneMaxY=" + fieldZoneMaxY +
                ", fieldValidationRequire=" + fieldValidationRequire +
                ", fieldValidationRule='" + fieldValidationRule + '\'' +
                '}';
    }
}
