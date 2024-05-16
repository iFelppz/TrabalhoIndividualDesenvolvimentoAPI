package br.org.serratec.trabalhoindividual.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.trabalhoindividual.exception.EnumValidationException;
import br.org.serratec.trabalhoindividual.exception.ValidationTitulo;
import br.org.serratec.trabalhoindividual.model.Livro;
import br.org.serratec.trabalhoindividual.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	// instanciando
	@Autowired
	private LivroRepository livroRepository;

	// metodo listar todos os livros
	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	// metodo buscar livro por id
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (livroOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(livroOpt.get());
	}

	// metodo inserir livro
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) throws EnumValidationException {
		ValidationTitulo.validarTitulo(livro.getTitulo());
		return livroRepository.save(livro);
	}

	// metodo alterar por id
	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livro.setId(id);
		livro = livroRepository.save(livro);
		return ResponseEntity.ok(livro);
	}

	// metodo deletar livro
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!livroRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
