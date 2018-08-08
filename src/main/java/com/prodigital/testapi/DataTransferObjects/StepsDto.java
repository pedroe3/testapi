package com.prodigital.testapi.DataTransferObjects;


import java.util.Date;

public class StepsDto {

    private String branch;

    private String building;

    private String cell;

    private String materialNumber;

    private String operationNumber;

    private String operationDescription;

    private Date dateObserved;

    private String operatorName;

    private String userName;

    private Date recordDate;

    private String observerName;

    private String ratingPercent;

    private int step;

    private String description;

    private double manTime;

    private double machineTime;

    private double movementTime;

    private double setupTime;



    public StepsDto() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }


    public double getManTime() {
        return manTime;
    }

    public void setManTime(double manTime) {
        this.manTime = manTime;
    }

    public double getMachineTime() {
        return machineTime;
    }

    public void setMachineTime(double machineTime) {
        this.machineTime = machineTime;
    }

    public double getMovementTime() {
        return movementTime;
    }

    public void setMovementTime(double movementTime) {
        this.movementTime = movementTime;
    }

    public double getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(double setupTime) {
        this.setupTime = setupTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }


    public Date getDateObserved() {
        return dateObserved;
    }

    public void setDateObserved(Date dateObserved) {
        this.dateObserved = dateObserved;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getRatingPercent() {
        return ratingPercent;
    }

    public void setRatingPercent(String ratingPercent) {
        this.ratingPercent = ratingPercent;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }
}
