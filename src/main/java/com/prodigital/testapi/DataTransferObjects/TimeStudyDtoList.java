package com.prodigital.testapi.DataTransferObjects;

import java.util.List;

public class TimeStudyDtoList {

    private List<TimeStudyDto> data;

    public TimeStudyDtoList(List<TimeStudyDto> timeStudyDtoList)
    {
        setData(timeStudyDtoList);
    }

    public List<TimeStudyDto> getData() {
        return data;
    }

    public void setData(List<TimeStudyDto> data) {
        this.data = data;
    }
}
