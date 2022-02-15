package br.com.wecode4u.insurancecliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wecode4u.insurancecliente.models.InsuranceModel;

public interface InsuranceRepository extends JpaRepository<InsuranceModel, Long> {

}
