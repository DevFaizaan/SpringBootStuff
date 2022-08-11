package com.qa.julyQA.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.julyQA.domain.Juice;
import com.qa.julyQA.exception.JuiceException;
import com.qa.julyQA.repos.JuiceRepo;

@Service
@Primary
public class JuiceServiceDB implements JuiceService {
	private JuiceRepo repo;

	public JuiceServiceDB(JuiceRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Juice makeJuice(Juice juice) {
		return this.repo.save(juice);
	}

	@Override
	public List<Juice> getAllJuices() {
		return this.repo.findAll();
	}

	@Override
	public Juice getById(int id) {
		Juice found = this.repo.findById(id).orElseThrow(JuiceException::new);
		return found;
		
		//return this.repo.findById(id).get();
	}

	@Override
	public Juice updateJuice(int id, String name, Integer amount, Double cost) {
		//Juice toUpdate = this.getById(id);
		Juice toUpdate = this.repo.findById(id).orElseThrow(JuiceException::new);
		

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (amount != null)
			toUpdate.setAmount(amount);
		if (cost != null)
			toUpdate.setCost(cost);

		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		Juice found = this.repo.findById(id).orElseThrow(JuiceException::new);
		this.repo.delete(found);

	}
}
