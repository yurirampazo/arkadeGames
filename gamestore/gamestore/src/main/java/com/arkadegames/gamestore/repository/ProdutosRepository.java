package com.arkadegames.gamestore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arkadegames.gamestore.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByTituloContainingIgnoreCase(String titulo);
}
