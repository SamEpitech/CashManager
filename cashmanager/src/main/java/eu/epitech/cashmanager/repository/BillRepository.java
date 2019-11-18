package eu.epitech.cashmanager.repository;

import eu.epitech.cashmanager.domain.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

    /*
     * CrudRepository lets you add methods that will be automatically implemented if they are
     * named a certain way.
     * https://www.mkyong.com/spring-data/spring-data-add-custom-method-to-repository/
     */
    List<Bill> findByUserId(int userId);
}
