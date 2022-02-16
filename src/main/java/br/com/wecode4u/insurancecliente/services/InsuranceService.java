package br.com.wecode4u.insurancecliente.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.wecode4u.insurancecliente.models.InsuranceModel;
import br.com.wecode4u.insurancecliente.repositories.InsuranceRepository;

@Service
public class InsuranceService {
	
	@Autowired
	InsuranceRepository insuranceRepository;

	public Optional<InsuranceModel> findById(@PathVariable Long id) {
		return insuranceRepository.findById(id);
	}
	
	public List<InsuranceModel> findAll() {
		return insuranceRepository.findAll();
	}
	
	@Transactional
	public InsuranceModel save(@RequestBody InsuranceModel insuranceModel) {
		return insuranceRepository.save(insuranceModel);
	}
	
	@Transactional
	public void delete(@PathVariable Long id) {
		insuranceRepository.deleteById(id);	
	}
}
