package com.prodigital.testapi.DataTransferObjects;

import java.util.List;

public class StepsDtoList {
    private List<StepsDto> data;

    public StepsDtoList(List<StepsDto> stepsDtoList)
    {
        setData(stepsDtoList);
    }

    public List<StepsDto> getData() {
        return data;
    }

    public void setData(List<StepsDto> data) {
        this.data = data;
    }
}
