package com.sdelamer.midas.MidasChallenge.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdelamer.midas.MidasChallenge.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	    Optional<Product> findByName(String name);

	    Optional<Product> findById(Long id);

}
