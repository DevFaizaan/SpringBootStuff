package com.qa.julyQA.service;

import java.util.List;

import com.qa.julyQA.domain.Juice;

public interface JuiceService {
	
	Juice makeJuice(Juice juice);

	List<Juice> getAllJuices();

	Juice getById(int id);

	Juice updateJuice(int id, String name, Integer amount, Double cost);

	void delete(int id);
}
