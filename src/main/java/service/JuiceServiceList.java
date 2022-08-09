package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Juice;

@Service
public class JuiceServiceList implements JuiceService {

	private List<Juice> juices;

	public JuiceServiceList() {
		super();
		this.juices = new ArrayList<>();
		this.juices.add(new Juice("Redbull", 500, 0.05));
	}

	@Override
	public Juice makeJuice(Juice juice) {
		this.juices.add(juice);
		return juices.get(this.juices.size() - 1);
	}

	@Override
	public List<Juice> getAllJuices() {
		return this.juices;
	}

	@Override
	public Juice getById(int id) {
		return this.juices.get(id);
	}

	@Override
	public Juice updateJuice(int id, String name, Integer amount, Double cost) {
		Juice toUpdate = this.juices.get(id);

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (amount != null)
			toUpdate.setAmount(amount);
		if (cost != null)
			toUpdate.setCost(cost);

		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.juices.remove(id);
	}
}
