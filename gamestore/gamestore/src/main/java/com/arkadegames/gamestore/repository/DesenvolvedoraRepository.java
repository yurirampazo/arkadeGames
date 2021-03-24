package com.arkadegames.gamestore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arkadegames.gamestore.model.Desenvolvedora;
import com.arkadegames.gamestore.model.Produto;

public interface DesenvolvedoraRepository extends JpaRepository<Desenvolvedora, Long> {
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}
