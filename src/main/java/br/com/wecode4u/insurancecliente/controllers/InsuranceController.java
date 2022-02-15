package br.com.wecode4u.insurancecliente.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wecode4u.insurancecliente.models.InsuranceModel;
import br.com.wecode4u.insurancecliente.repositories.InsuranceRepository;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@GetMapping("/{id}")
	public Optional<InsuranceModel> findById(@PathVariable Long id) {
		return insuranceRepository.findById(id);
	}
	
	@GetMapping()
	public List<InsuranceModel> findAll() {
		return insuranceRepository.findAll();
	}
	
	@PostMapping()
	public InsuranceModel save(@RequestBody InsuranceModel insuranceModel) {
		return insuranceRepository.save(insuranceModel);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		insuranceRepository.deleteById(id);	
	}
}
