package eu.epitech.cashmanager.controller;

import eu.epitech.cashmanager.domain.Bill;
import eu.epitech.cashmanager.domain.User;
import eu.epitech.cashmanager.exception.HttpException;
import eu.epitech.cashmanager.service.BillService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.GET)
    public List<Bill> getAllBills(@PathVariable int userId) {
        return this.billService.getAllBills(userId);
    }

    @RequestMapping(value = "/api/users/{userId}/bills/{id}", method = RequestMethod.GET)
    public Bill getBill(@PathVariable int id) {
        try {
            return this.billService.getBill(id);
        } catch (HttpException e) {
            throw new ResponseStatusException(
                    e.getStatusCode(), e.getMessage(), e
            );
        }
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.POST)
    public void addBill(@PathVariable int userId, @RequestBody Bill bill) {
        this.billService.addBill(userId, bill);
    }

    @RequestMapping(value = "/api/users/{userId}/bills", method = RequestMethod.PUT)
    public void updateBill(@PathVariable int userId, @RequestBody Bill bill) {
        this.billService.updateBill(userId, bill);
    }

    @RequestMapping(value = "/api/users/{userId}/bills/{id}", method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable int id) {
        this.billService.deleteBill(id);
    }
}
