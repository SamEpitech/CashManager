package eu.epitech.cashmanager.service;

import eu.epitech.cashmanager.domain.Bill;
import eu.epitech.cashmanager.domain.Payment;
import eu.epitech.cashmanager.domain.PaymentStatus;
import eu.epitech.cashmanager.repository.BillRepository;
import eu.epitech.cashmanager.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillRepository billRepository;
//    private final ArrayList<String> validCards;

    public PaymentService(PaymentRepository paymentRepository, BillRepository billRepository) {
        this.paymentRepository = paymentRepository;
        this.billRepository = billRepository;
    }

    public void addPayment(int billId, Payment payment) {
        payment.setBill(new Bill(billId, 0, false, 0));
        payment.setStatus(PaymentStatus.ACCEPTED);
        this.paymentRepository.save(payment);
        this.billRepository
                .findById(billId)
                .ifPresent(bill -> {
                    bill.setStatus(true);
                    this.billRepository.save(bill);
                });
    }
}
