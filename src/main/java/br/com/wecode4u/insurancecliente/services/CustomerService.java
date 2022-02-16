package br.com.wecode4u.insurancecliente.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wecode4u.insurancecliente.dtos.CustomerDTO;
import br.com.wecode4u.insurancecliente.models.CustomerModel;
import br.com.wecode4u.insurancecliente.repositories.CustomerRepository;
import br.com.wecode4u.insurancecliente.services.validators.CustomerValidators;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerValidators customerValidators;
	
	public boolean existsCPF(String cpf) {
		return customerValidators.existsCPF(cpf); 
	}
	
	public Optional<CustomerModel> findById(Long id) {
		return customerRepository.findById(id);
	}
	
	public List<CustomerModel> findAll() {
		return customerRepository.findAll();
	}

	@Transactional
	public CustomerModel save(CustomerModel customerModel) {
		return customerRepository.save(customerModel);
	}
	
	@Transactional
	public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
}
