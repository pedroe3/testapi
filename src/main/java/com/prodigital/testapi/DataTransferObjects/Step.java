package com.prodigital.testapi.DataTransferObjects;


import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Step {

    private String step;
    private String description;
    private String manTime;
    private String machineTime;
    private String movementTime;
    private String setupTime;

    @JsonProperty("Step")
    public String getStep() { return step; }
    @JsonProperty("Step")
    public void setStep(String value) { this.step = value; }

    @JsonProperty("Description")
    public String getDescription() { return description; }
    @JsonProperty("Description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("ManTime")
    public String getManTime() { return manTime; }
    @JsonProperty("ManTime")
    public void setManTime(String value) { this.manTime = value; }

    @JsonProperty("MachineTime")
    public String getMachineTime() { return machineTime; }
    @JsonProperty("MachineTime")
    public void setMachineTime(String value) { this.machineTime = value; }

    @JsonProperty("MovementTime")
    public String getMovementTime() { return movementTime; }
    @JsonProperty("MovementTime")
    public void setMovementTime(String value) { this.movementTime = value; }

    @JsonProperty("SetupTime")
    public String getSetupTime() { return setupTime; }
    @JsonProperty("SetupTime")
    public void setSetupTime(String value) { this.setupTime = value; }
}

