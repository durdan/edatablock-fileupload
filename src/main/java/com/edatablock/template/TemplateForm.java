package com.edatablock.template;

public class TemplateForm {

    private String fileName;

    private Double fieldZoneMinX;

    private Double fieldZoneMinY;


    private Double fieldZoneMaxX;


    private Double fieldZoneMaxY;


    private Integer fieldValidationRequire;


    private String fieldValidationRule;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Double getFieldZoneMinX() {
        return fieldZoneMinX;
    }

    public void setFieldZoneMinX(Double fieldZoneMinX) {
        this.fieldZoneMinX = fieldZoneMinX;
    }

    public Double getFieldZoneMinY() {
        return fieldZoneMinY;
    }

    public void setFieldZoneMinY(Double fieldZoneMinY) {
        this.fieldZoneMinY = fieldZoneMinY;
    }

    public Double getFieldZoneMaxX() {
        return fieldZoneMaxX;
    }

    public void setFieldZoneMaxX(Double fieldZoneMaxX) {
        this.fieldZoneMaxX = fieldZoneMaxX;
    }

    public Double getFieldZoneMaxY() {
        return fieldZoneMaxY;
    }

    public void setFieldZoneMaxY(Double fieldZoneMaxY) {
        this.fieldZoneMaxY = fieldZoneMaxY;
    }

    public Integer getFieldValidationRequire() {
        return fieldValidationRequire;
    }

    public void setFieldValidationRequire(Integer fieldValidationRequire) {
        this.fieldValidationRequire = fieldValidationRequire;
    }

    public String getFieldValidationRule() {
        return fieldValidationRule;
    }

    public void setFieldValidationRule(String fieldValidationRule) {
        this.fieldValidationRule = fieldValidationRule;
    }
}
