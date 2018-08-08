package com.prodigital.testapi.DataAccessObjects;

import com.prodigital.testapi.DataTransferObjects.StepsDto;
import com.prodigital.testapi.DataTransferObjects.TimeStudyDto;
import com.prodigital.testapi.Entities.OperationStudy;
import com.prodigital.testapi.Entities.StepsOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TimeStudyDao  {

    @Autowired
    private EntityManager em;

    public List<StepsDto> findAllStudies()
    {
        List<Object[]> response =  em.createQuery("select c, o  " +
                "from StepsOperation c " +
                "join c.operationStudy o " +
                "where o.id = " +
                "(select max(o2.id) from OperationStudy o2 where o2.materialNumber = o.materialNumber and o2.operationNumber = o.operationNumber )")
                .getResultList();
        return this.mapResponse(response);
    }

    public List<TimeStudyDto> findStudiesByMaterial(String materialNumber)
    {
        Query query =  em.createQuery("select  sum(c.manTime), sum(c.machineTime), sum(c.setupTime) , sum(c.movementTime) , " +
                "o.materialNumber, o.operationNumber " +
                "from StepsOperation c " +
                "join c.operationStudy o " +
                "where o.id = " +
                "(select max(o2.id) from OperationStudy o2 " +
                "where o2.materialNumber = o.materialNumber and o2.operationNumber = o.operationNumber ) " +
                "and o.materialNumber =:mat " +
                "group by o.materialNumber, o.operationNumber");

        query.setParameter("mat", materialNumber);
        List<Object[]> response = query.getResultList();
        return this.mapMaterialResponse(response);
    }
    public List<TimeStudyDto> findStudiesByMaterialAndOperationNumber(String materialNumber, String operationNumber)
    {
        Query query =  em.createQuery("select  sum(c.manTime), sum(c.machineTime), sum(c.setupTime) , sum(c.movementTime) , " +
                "o.materialNumber, o.operationNumber " +
                "from StepsOperation c " +
                "join c.operationStudy o " +
                "where o.id = " +
                "(select max(o2.id) from OperationStudy o2 " +
                "where o2.materialNumber = o.materialNumber and o2.operationNumber = o.operationNumber ) " +
                "and o.materialNumber =:mat " +
                "and o.operationNumber =:op " +
                "group by o.materialNumber, o.operationNumber");

        query.setParameter("mat", materialNumber);
        query.setParameter("op", operationNumber);

        List<Object[]> response = query.getResultList();
        return this.mapMaterialResponse(response);
    }

    private List<TimeStudyDto> mapMaterialResponse(List<Object[]> response)
    {
        List<TimeStudyDto> timeStudyDtoList = new ArrayList<>();

        for(Object[] step : response)
        {
            TimeStudyDto timeStudyDto = new TimeStudyDto();
            timeStudyDto.setMaterialNumber(step[4].toString());
            timeStudyDto.setOperationNumber(step[5].toString());
            timeStudyDto.setManTime(Double.parseDouble(step[0].toString()));
            timeStudyDto.setMachineTime(Double.parseDouble(step[1].toString()));
            timeStudyDto.setSetupTime(Double.parseDouble(step[2].toString()));
            timeStudyDto.setMovementTime(Double.parseDouble(step[3].toString()));
            timeStudyDtoList.add(timeStudyDto);
        }

        return timeStudyDtoList;
    }

    private List<StepsDto> mapResponse(List<Object[]> response)
    {
        List<StepsDto> stepsDtoList = new ArrayList<>();

        OperationStudy[] OperationsStudyArray = new OperationStudy[response.size()];
        StepsOperation[] StepOperationArray = new StepsOperation[response.size()];

        for(Object[] step : response)
        {
            StepsDto stepsDto = new StepsDto();
            OperationsStudyArray[response.indexOf(step)] = (OperationStudy)step[1];
            StepOperationArray[response.indexOf(step)] = (StepsOperation)step[0];

            stepsDto.setBranch(OperationsStudyArray[response.indexOf(step)].getBranch());
            stepsDto.setBuilding(OperationsStudyArray[response.indexOf(step)].getBuilding());
            stepsDto.setCell(OperationsStudyArray[response.indexOf(step)].getCell());
            stepsDto.setMaterialNumber(OperationsStudyArray[response.indexOf(step)].getMaterialNumber());
            stepsDto.setOperationNumber(OperationsStudyArray[response.indexOf(step)].getOperationNumber());
            stepsDto.setOperatorName(OperationsStudyArray[response.indexOf(step)].getOperatorName());
            stepsDto.setObserverName(OperationsStudyArray[response.indexOf(step)].getObserverName());
            stepsDto.setDateObserved(OperationsStudyArray[response.indexOf(step)].getDateObserved());
            stepsDto.setUserName(OperationsStudyArray[response.indexOf(step)].getUserName());
            stepsDto.setRecordDate(OperationsStudyArray[response.indexOf(step)].getEntryDate());
            stepsDto.setRatingPercent(OperationsStudyArray[response.indexOf(step)].getRatingPercent());


            stepsDto.setStep(StepOperationArray[response.indexOf(step)].getStep());
            stepsDto.setDescription(StepOperationArray[response.indexOf(step)].getDescription());
            stepsDto.setManTime(StepOperationArray[response.indexOf(step)].getManTime());
            stepsDto.setMachineTime(StepOperationArray[response.indexOf(step)].getMachineTime());
            stepsDto.setSetupTime(StepOperationArray[response.indexOf(step)].getSetupTime());
            stepsDto.setMovementTime(StepOperationArray[response.indexOf(step)].getMovementTime());

            stepsDtoList.add(stepsDto);

        }

        return stepsDtoList;
    }
}
