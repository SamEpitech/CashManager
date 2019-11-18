package eu.epitech.cashmanager.repository;

import eu.epitech.cashmanager.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findByName(String name);
    Product findByUuid(UUID uuid);
}
