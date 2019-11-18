package eu.epitech.cashmanager.repository;

import eu.epitech.cashmanager.domain.ProductPicture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPictureRepository extends CrudRepository<ProductPicture, Integer> {
}
