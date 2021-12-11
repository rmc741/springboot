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
import rafael.springboot.model.Funcionario;
import rafael.springboot.repository.FuncionarioRepository;


@RestController
@RequestMapping("api/v2/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	//get empresa
	@GetMapping("/funcionario")
	public List<Funcionario> getAllempresa(){
		return this.funcionarioRepository.findAll();
	}
	
	//get funcionario pelo ID
	@GetMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
				() -> new ResourceNotFoundException("Funcionario não foi encontrada por esse ID ::" + funcionarioId));
		return ResponseEntity.ok().body(funcionario);
	}
	
	//Save Funcionario
	@PostMapping("/funcionario")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	}
	
	//update Funcionario
	@PutMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value = "id") Long funcinarioId , @Validated @RequestBody Funcionario funcionarioDetails) 
			throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcinarioId).orElseThrow(
				() -> new ResourceNotFoundException("Funcionario não foi encontrada por esse ID ::" + funcinarioId));
		
		funcionario.setFuncionarioNome(funcionarioDetails.getFuncionarioNome());
		funcionario.setFuncionarioCpf(funcionarioDetails.getFuncionarioCpf());
		funcionario.setFuncionarioEmail(funcionarioDetails.getFuncionarioEmail());
		funcionario.setFuncionarioSaldo(funcionarioDetails.getFuncionarioSaldo());
		final Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.ok().body(updatedFuncionario);
	}
	
	//delete Funcionario
	@DeleteMapping("/funcionario/{id}")
	public Map<String , Boolean> deleteFuncionario(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException {
		Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(
			() -> new ResourceNotFoundException("Funcionario não foi encontrada por esse ID ::" + funcionarioId) );
		
		funcionarioRepository.delete(funcionario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
