package br.com.wecode4u.apolice.models;

import java.sql.Timestamp;
import java.util.UUID;

public class ApoliceModel {
	
	UUID numeroApolice;
	Timestamp inicioVigencia;
	Timestamp fimVigencia;
	String placaVeiculo;
	float valorApolice;
}
