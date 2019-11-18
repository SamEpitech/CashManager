package eu.epitech.cashmanager.service;

import eu.epitech.cashmanager.domain.Bill;
import eu.epitech.cashmanager.domain.User;
import eu.epitech.cashmanager.exception.NotFoundException;
import eu.epitech.cashmanager.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills(int userId) {
        return new ArrayList<>(this.billRepository.findByUserId(userId));
    }

    public Bill getBill(int id) {
        return this.billRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("bill with id %d", id)));
    }

    public void addBill(int userId, Bill bill) {
        bill.setUser(new User(userId, "", "", ""));
        this.billRepository.save(bill);
    }

    public void updateBill(int userId, Bill bill) {
        bill.setUser(new User(userId, "", "", ""));
        this.billRepository.save(bill);
    }

    public void deleteBill(int id) {
        this.billRepository.deleteById(id);
    }
}
