package com.arkadegames.gamestore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arkadegames.gamestore.model.Desenvolvedora;
import com.arkadegames.gamestore.model.Produto;
import com.arkadegames.gamestore.repository.DesenvolvedoraRepository;

@RestController
@RequestMapping("/gamestore/desenvolvedoras")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DesenvolvedoraController {

	@Autowired
	private DesenvolvedoraRepository desenvolvedoraRepository;
	
	@GetMapping
	public ResponseEntity<List<Desenvolvedora>> findAllDevs() {
		return ResponseEntity.ok(desenvolvedoraRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Desenvolvedora> findDevById(@PathVariable long id) {
		return desenvolvedoraRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/desenvolvedora/{desenvolvedora}")
	public ResponseEntity<List<Produto>> findDevByName (@PathVariable String nome) {
		return ResponseEntity.ok(desenvolvedoraRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Desenvolvedora> postDev(@RequestBody Desenvolvedora desenvolvedora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(desenvolvedoraRepository.save(desenvolvedora));
	}
	
	@PutMapping
	public ResponseEntity<Desenvolvedora> putDev(@PathVariable Desenvolvedora desenvolvedora) {
		return ResponseEntity.status(HttpStatus.OK).body(desenvolvedoraRepository.save(desenvolvedora));
	}
	
	@DeleteMapping("/{id}")
	public void deleteDev(@PathVariable long id) {
		desenvolvedoraRepository.deleteById(id);
	}
}