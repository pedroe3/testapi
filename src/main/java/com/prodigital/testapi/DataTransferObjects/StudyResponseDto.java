package com.prodigital.testapi.DataTransferObjects;

import com.prodigital.testapi.Entities.OperationStudy;

import java.util.List;

public class StudyResponseDto {

    public List<OperationStudy> data;




    public List<OperationStudy> getData() {
        return data;
    }

    public void setData(List<OperationStudy> operationStudies) {
        this.data = operationStudies;
    }
}
