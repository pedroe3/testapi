package com.prodigital.testapi.DataTransferObjects;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class JsonPost {
    private OperationStudyDto operationStudy;
    private Step[] steps;

    @JsonProperty("OperationStudy")
    public OperationStudyDto getOperationStudy() { return operationStudy; }
    @JsonProperty("OperationStudy")
    public void setOperationStudy(OperationStudyDto value) { this.operationStudy = value; }

    @JsonProperty("steps")
    public Step[] getSteps() { return steps; }
    @JsonProperty("steps")
    public void setSteps(Step[] value) { this.steps = value; }
}
