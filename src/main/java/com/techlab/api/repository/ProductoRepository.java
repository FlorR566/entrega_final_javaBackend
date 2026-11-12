package com.techlab.api.repository;

import com.techlab.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByNombreIgnoreCase(String nombre);

    boolean existsByCategoriaId(Long categoriaId);

    /**
     * Busca los productos cuyo stock es menor al valor indicado.
     * @param stock valor límite (exclusivo); se devuelven los productos con stock menor a este número
     * @return lista de productos con stock menor al indicado; vacía si no hay coincidencias
     */
    List<Producto> findByStockLessThan(int stock);
}
