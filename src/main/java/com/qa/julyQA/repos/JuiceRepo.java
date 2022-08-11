package com.qa.julyQA.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.julyQA.domain.Juice;

@Repository
public interface JuiceRepo extends JpaRepository<Juice, Integer> {
	//Optional<Juice> existingOptional = this.repo.findById(id);
    // Juice existing = existingOptional.get();

}