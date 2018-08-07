package com.prodigital.testapi.Entities;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class OperationStudy {

    @Id
    @GeneratedValue
    private Integer id;

    private String branch;

    private String building;

    private String cell;

    private String materialNumber;

    private String operationNumber;

    private Date dateObserved;

    private String operatorName;

    private String userName;

    private String observerName;

    private String ratingPercent;

    @CreationTimestamp
    private Date entryDate;

    @OneToMany(mappedBy = "operationStudy", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<StepsOperation> stepsOperation = new ArrayList<>();

    public OperationStudy() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String site) {
        this.branch = site;
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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public List<StepsOperation> getStepsOperation() {
        return stepsOperation;
    }

    public void setStepsOperation(List<StepsOperation> stepsOperation) {
        this.stepsOperation = stepsOperation;
    }
}
