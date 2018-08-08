package com.prodigital.testapi.DataTransferObjects;

public class TimeStudyDto {

    private String materialNumber;

    private String operationNumber;

    private String operationDescription;

    private double manTime;

    private double machineTime;

    private double movementTime;

    private double setupTime;

    public TimeStudyDto() {
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

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }
}
