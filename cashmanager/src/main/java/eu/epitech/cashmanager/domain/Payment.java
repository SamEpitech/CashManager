package eu.epitech.cashmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private PaymentType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private PaymentStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Bill bill;

    public Payment() {}

    public Payment(int id, PaymentType type, PaymentStatus status, int billId) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.bill = new Bill(billId, 0, false, 0);
    }

    public int getId() {
        return id;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
