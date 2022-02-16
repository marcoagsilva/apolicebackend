package br.com.wecode4u.insurancecliente.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import br.com.wecode4u.insurancecliente.dtos.InsuranceDTO;
import br.com.wecode4u.insurancecliente.models.CustomerModel;
import br.com.wecode4u.insurancecliente.models.InsuranceModel;
import br.com.wecode4u.insurancecliente.services.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<InsuranceModel> insuranceModel = insuranceService.findById(id);
		if(!insuranceModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apólice não encontrada.");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(insuranceModel); 
	}
	
	@GetMapping()
	public ResponseEntity<List<InsuranceModel>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(insuranceService.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<InsuranceModel> save(@RequestBody InsuranceModel insuranceModel) {
		return ResponseEntity.status(HttpStatus.OK).body(insuranceService.save(insuranceModel));
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid InsuranceDTO insuranceDTO) {
		Optional<InsuranceModel> insuranceModelOptional = insuranceService.findById(id);
		if(!insuranceModelOptional.isPresent()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		}
		
		InsuranceModel insurancModel = new InsuranceModel();
		BeanUtils.copyProperties(insuranceDTO, insurancModel);
		insurancModel.setInsuranceUID(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(insuranceService.save(insurancModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Optional<InsuranceModel> insuranceModel = insuranceService.findById(id);
		if(!insuranceModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Apólice não encontrada.");
		}
		
		insuranceService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Operação efetuada.");
	}
}
