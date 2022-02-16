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
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<CustomerModel> customerModel = customerService.findById(id);
		if (!customerModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(customerModel);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerModel>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid CustomerDTO customerDTO) {
		if(customerService.existsCPF(customerDTO.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já existente.");
		}
		
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDTO, customerModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid CustomerDTO customerDTO) {
		Optional<CustomerModel> customerModelOptional = customerService.findById(id);
		if(!customerModelOptional.isPresent()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		
		CustomerModel customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDTO, customerModel);
		customerModel.setCustomer_id(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customerModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Optional <CustomerModel> customerModel = customerService.findById(id);
		if(!customerModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		
		customerService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Operação efetuada.");
	}
}
