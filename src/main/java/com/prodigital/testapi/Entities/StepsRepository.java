package com.prodigital.testapi.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StepsRepository extends JpaRepository<StepsOperation, Integer> {
}
