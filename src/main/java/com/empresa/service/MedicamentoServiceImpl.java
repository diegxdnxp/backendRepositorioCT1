package com.empresa.service;

import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;



@Service
public class MedicamentoServiceImpl implements MedicamentoService{

	MedicamentoRepository repo;
	
	@Override
	public Medicamento Insertar(Medicamento obj) {
		
		return repo.save(obj);
	}

}
