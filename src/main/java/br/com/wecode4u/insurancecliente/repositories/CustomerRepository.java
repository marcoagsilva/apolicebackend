package br.com.wecode4u.insurancecliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wecode4u.insurancecliente.models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

}
