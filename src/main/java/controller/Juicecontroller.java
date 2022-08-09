package controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.JuiceService;
import domain.Juice;

@RestController
public class Juicecontroller {
	
	private JuiceService service;

	@Autowired
	public Juicecontroller(JuiceService service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, world!";
	}

	@PostMapping("/createJuice")
	public Juice makeBikky(@RequestBody Juice juice) {
		System.out.println("Body: " + juice);
		return this.service.makeJuice(juice);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getAll")
	public List<Juice> getAllJuices() {
		return this.service.getAllJuices();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Juice> getById(@PathVariable int id) {
		System.out.println("ID: " + id);
		return new ResponseEntity<Juice>(this.service.getById(id), HttpStatus.I_AM_A_TEAPOT);
	}

	@PatchMapping("/update/{id}")
	public Juice updateBiscuit(@PathVariable int id, @PathParam("name") String name,
			@PathParam("amount") Integer amount, @PathParam("cost") Double cost) {
		System.out.println("ID: " + id);
		System.out.println("NAME: " + name);
		System.out.println("AMOUNT: " + amount);
		System.out.println("COST: " + cost);

		return this.service.updateJuice(id, name, amount, cost);
	}

	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
		this.service.delete(id);
	}

}
