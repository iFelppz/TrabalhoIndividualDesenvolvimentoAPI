package br.org.serratec.trabalhoindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.serratec.trabalhoindividual.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
