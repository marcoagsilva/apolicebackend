package br.com.wecode4u.insurancecliente.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wecode4u.insurancecliente.models.CustomerModel;
import br.com.wecode4u.insurancecliente.repositories.CustomerRepository;

@Service
public class CustomerValidators {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public boolean existsCPF(String cpf) {
		CustomerModel customer = customerRepository.findByCpf(cpf);
		if(customer != null) {
			return true;
		} else {
			return false;
		} 	
	}

}
