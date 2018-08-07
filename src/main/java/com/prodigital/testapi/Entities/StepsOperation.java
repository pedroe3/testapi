package com.prodigital.testapi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class StepsOperation {

    @Id
    @GeneratedValue
    private Integer id;

    private double manTime;

    private double machineTime;

    private double movementTime;

    private double setupTime;

    @Size(max=750)
    private String description;

    private int step;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private OperationStudy operationStudy;

    public StepsOperation() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public OperationStudy getOperationStudy() {
        return operationStudy;
    }

    public void setOperationStudy(OperationStudy operationStudy) {
        this.operationStudy = operationStudy;
    }

    public double getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(double setupTime) {
        this.setupTime = setupTime;
    }
}
