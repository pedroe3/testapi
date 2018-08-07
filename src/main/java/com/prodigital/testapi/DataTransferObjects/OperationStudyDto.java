package com.prodigital.testapi.DataTransferObjects;

import com.prodigital.testapi.Entities.OperationStudy;


import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class OperationStudyDto {
    private String branch;
    private String building;
    private String cell;
    private String ratingPercent;
    private String materialNumber;
    private String operationNumber;
    private String dateObserved;
    private String operatorName;
    private String userName;
    private String observerName;

    @JsonProperty("Branch")
    public String getBranch() { return branch; }
    @JsonProperty("Branch")
    public void setBranch(String value) { this.branch = value; }

    @JsonProperty("Building")
    public String getBuilding() { return building; }
    @JsonProperty("Building")
    public void setBuilding(String value) { this.building = value; }

    @JsonProperty("Cell")
    public String getCell() { return cell; }
    @JsonProperty("Cell")
    public void setCell(String value) { this.cell = value; }

    @JsonProperty("RatingPercent")
    public String getRatingPercent() { return ratingPercent; }
    @JsonProperty("RatingPercent")
    public void setRatingPercent(String value) { this.ratingPercent = value; }

    @JsonProperty("MaterialNumber")
    public String getMaterialNumber() { return materialNumber; }
    @JsonProperty("MaterialNumber")
    public void setMaterialNumber(String value) { this.materialNumber = value; }

    @JsonProperty("OperationNumber")
    public String getOperationNumber() { return operationNumber; }
    @JsonProperty("OperationNumber")
    public void setOperationNumber(String value) { this.operationNumber = value; }

    @JsonProperty("DateObserved")
    public String getDateObserved() { return dateObserved; }
    @JsonProperty("DateObserved")
    public void setDateObserved(String value) { this.dateObserved = value; }

    @JsonProperty("OperatorName")
    public String getOperatorName() { return operatorName; }
    @JsonProperty("OperatorName")
    public void setOperatorName(String value) { this.operatorName = value; }

    @JsonProperty("UserName")
    public String getUserName() { return userName; }
    @JsonProperty("UserName")
    public void setUserName(String value) { this.userName = value; }

    @JsonProperty("Observer")
    public String getObserverName() { return observerName; }
    @JsonProperty("Observer")
    public void setObserverName(String value) { this.observerName = value; }



}
