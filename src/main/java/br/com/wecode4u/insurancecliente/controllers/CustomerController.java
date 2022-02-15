package br.com.wecode4u.insurancecliente.controllers;

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

import br.com.wecode4u.insurancecliente.models.CustomerModel;
import br.com.wecode4u.insurancecliente.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/{id}")
	public Optional<CustomerModel> findById(@PathVariable Long id) {
		return customerRepository.findById(id);
	}
	
	@GetMapping()
	public List<CustomerModel> findAll() {
		return customerRepository.findAll();
	}
	
	@PostMapping()
	public CustomerModel save(@RequestBody CustomerModel customerModel) throws Exception {
		if(customerRepository.findByCpf(customerModel.getCpf()) != null) {
			throw new Exception("CPF existente");
		}
		
		return customerRepository.save(customerModel);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
}
