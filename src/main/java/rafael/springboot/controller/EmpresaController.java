package rafael.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rafael.springboot.exception.ResourceNotFoundException;
import rafael.springboot.model.Empresa;
import rafael.springboot.repository.EmpresaRepository;

@RestController
@RequestMapping("/api/v2/")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	//get empresa
	@GetMapping("/empresa")
	public List<Empresa> getAllempresa(){
		return this.empresaRepository.findAll();
	}
	
	//get empresa pelo ID
	@GetMapping("/empresa/{id}")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable(value = "id") Long empresaId) throws ResourceNotFoundException {
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(
				() -> new ResourceNotFoundException("Empresa não foi encontrada por esse ID ::" + empresaId));
		return ResponseEntity.ok().body(empresa);
	}
	
	//Save Empresa
	@PostMapping("/empresa")
	public Empresa createEmpresa(@RequestBody Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	//update Empresa
	@PutMapping("/empresa/{id}")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long empresaId , @Validated @RequestBody Empresa empresaDetails) 
			throws ResourceNotFoundException {
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(
				() -> new ResourceNotFoundException("Empresa não foi encontrada por esse ID ::" + empresaId));
		
		empresa.setEmpresaNome(empresaDetails.getEmpresaNome());
		empresa.setEmpresaCnpj(empresaDetails.getEmpresaCnpj());
		empresa.setEmpresaEmail(empresaDetails.getEmpresaEmail());
		empresa.setEmpresaSaldo(empresaDetails.getEmpresaSaldo());
		final Empresa updatedEmpresa = empresaRepository.save(empresa);
		return ResponseEntity.ok().body(updatedEmpresa);
	}
	
	//delete Empresa
	@DeleteMapping("/empresa/{id}")
	public Map<String , Boolean> deleteEmpresa(@PathVariable(value = "id") Long empresaId) throws ResourceNotFoundException {
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(
			() -> new ResourceNotFoundException("Empresa não foi encontrada por esse ID ::" + empresaId) );
		
		empresaRepository.delete(empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
