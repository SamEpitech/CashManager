package eu.epitech.cashmanager.controller;

import eu.epitech.cashmanager.domain.Payment;
import eu.epitech.cashmanager.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/api/users/{userId}/bills/{billId}/pay", method = RequestMethod.POST)
    public void addPayment(@PathVariable int billId, @RequestBody Payment payment) {
        this.paymentService.addPayment(billId, payment);
    }
}
