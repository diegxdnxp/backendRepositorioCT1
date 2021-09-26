package com.empresa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;
import com.empresa.util.Constantes;

@RestController
@RequestMapping("/rest/medicamento")
@CrossOrigin(origins = "http://localhost:4200")

public class MedicamentoController {
	
	@Autowired
	MedicamentoService servis;
	
	
	public ResponseEntity<Map<String, Object>> insertarMedicamento(@RequestBody Medicamento obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
		Medicamento objSalida = servis.Insertar(obj);
		
		if(objSalida == null) {
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		} else {
			
			salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
		}
		}catch(Exception ex) {
			
			ex.printStackTrace();
			salida.put("mensaje",Constantes.MENSAJE_REG_ERROR);
		}
		
		return ResponseEntity.ok(salida);
	}
	

}
