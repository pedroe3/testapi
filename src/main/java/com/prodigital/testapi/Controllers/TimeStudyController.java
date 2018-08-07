package com.prodigital.testapi.Controllers;


import com.prodigital.testapi.DataTransferObjects.JsonPost;
import com.prodigital.testapi.DataTransferObjects.Step;
import com.prodigital.testapi.DataTransferObjects.StudyResponseDto;
import com.prodigital.testapi.Entities.OperationStudy;
import com.prodigital.testapi.Entities.OperationStudyRepository;

import com.prodigital.testapi.Entities.StepsOperation;

import com.prodigital.testapi.Entities.StepsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityManager;


import javax.transaction.Transactional;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TimeStudyController {

    @Autowired
    private OperationStudyRepository service;

    @Autowired
    private StepsRepository stepsRepository;

    @Autowired
    private EntityManager em;

    @GetMapping("/timestudy")
    public StudyResponseDto getReport()
    {
        StudyResponseDto responseDto = new StudyResponseDto();
        List<OperationStudy> operationStudies = service.findAll();
        responseDto.setData(operationStudies);
        return responseDto;
    }

    @PostMapping("/timestudy")
    @Transactional
    public ResponseEntity<Object> createEntry(@RequestBody JsonPost jsonPost) throws Exception
    {
        OperationStudy operationStudy = this.mapOperationStudy(jsonPost);
        List<StepsOperation> stepsOperation = this.mapStepOperationStudy(jsonPost);
        for(StepsOperation step: stepsOperation)
        {
            step.setOperationStudy(operationStudy);
        }
        operationStudy.setStepsOperation(stepsOperation);
        service.save(operationStudy);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(operationStudy.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    private OperationStudy mapOperationStudy(JsonPost jsonPost)  throws Exception
    {
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        OperationStudy operationStudy = new OperationStudy();

        operationStudy.setMaterialNumber(jsonPost.getOperationStudy().getMaterialNumber());
        operationStudy.setOperationNumber(jsonPost.getOperationStudy().getOperationNumber());
        operationStudy.setObserverName(jsonPost.getOperationStudy().getObserverName());
        operationStudy.setUserName(jsonPost.getOperationStudy().getUserName());
        operationStudy.setDateObserved(sd.parse(jsonPost.getOperationStudy().getDateObserved()));
        operationStudy.setRatingPercent(jsonPost.getOperationStudy().getRatingPercent());
        operationStudy.setOperatorName(jsonPost.getOperationStudy().getOperatorName());
        operationStudy.setBranch(jsonPost.getOperationStudy().getBranch());
        operationStudy.setBuilding(jsonPost.getOperationStudy().getBuilding());
        operationStudy.setCell(jsonPost.getOperationStudy().getCell());

        return operationStudy;
    }

    private List<StepsOperation> mapStepOperationStudy(JsonPost jsonPost)
    {
        List<StepsOperation> stepsOperationList = new ArrayList<>();
        for(Step step : jsonPost.getSteps())
        {
            StepsOperation stepsOperation = new StepsOperation();
            stepsOperation.setDescription(step.getDescription());
            stepsOperation.setStep(Integer.parseInt(step.getStep()));
            stepsOperation.setManTime(Double.parseDouble(step.getManTime()));
            stepsOperation.setMachineTime(Double.parseDouble(step.getMachineTime()));
            stepsOperation.setMovementTime(Double.parseDouble(step.getMovementTime()));
            stepsOperation.setSetupTime(Double.parseDouble(step.getSetupTime()));
            stepsOperationList.add(stepsOperation);
        }
        return stepsOperationList;
    }
}
