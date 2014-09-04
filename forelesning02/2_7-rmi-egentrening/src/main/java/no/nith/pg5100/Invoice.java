package no.nith.pg5100;

import java.io.Serializable;
import java.math.BigDecimal;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String customer;
    private final String address;
    private final BigDecimal amount;

    public Invoice(int id, String customer, String address, BigDecimal amount) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format(
                "Invoice {id=%s, customer=%s, address=%s, amount=%s}", id,
                customer, address, amount);
    }
}
