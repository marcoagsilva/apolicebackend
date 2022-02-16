package br.com.wecode4u.insurancecliente.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wecode4u.insurancecliente.dtos.CustomerDTO;
import br.com.wecode4u.insurancecliente.models.CustomerModel;
import br.com.wecode4u.insurancecliente.repositories.CustomerRepository;
import br.com.wecode4u.insurancecliente.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{id}")
	public Optional<CustomerModel> findById(@PathVariable Long id) {
		return customerService.findById(id);
	}
	
	@GetMapping()
	public List<CustomerModel> findAll() {
		return customerService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid CustomerDTO customerDTO) {
		if(customerService.existsCPF(customerDTO.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já existente");
		}
		
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDTO, customerModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		customerService.delete(id);
	}
}
