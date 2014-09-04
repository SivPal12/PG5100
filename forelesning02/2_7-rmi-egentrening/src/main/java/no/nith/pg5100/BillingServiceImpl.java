package no.nith.pg5100;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import no.nith.pg5100.exceptions.BillingDuplicateInvoiceException;

public class BillingServiceImpl implements BillingService {
    private static final long serialVersionUID = 1L;

    private final List<Invoice> registeredInvoices = new ArrayList<>();

    @Override
    public void registerInvoice(Invoice invoice) throws RemoteException {
        if (registeredInvoices.contains(invoice)) {
            throw new BillingDuplicateInvoiceException();
        }
        registeredInvoices.add(invoice);
        System.out.println("Invoice registered: " + invoice);
    }

    @Override
    public List<Invoice> getRegisteredInvoices() throws RemoteException {
        return registeredInvoices;
    }

    @Override
    public BigDecimal getTotalAmount() throws RemoteException {
        BigDecimal amount = new BigDecimal(0);
        for (Invoice invoice : registeredInvoices) {
            amount = amount.add(invoice.getAmount());
        }

        return amount;
    }

    // Ved remote kall, start klassen med: -Djava.security.policy=src/main/resources/security.policy
    public static void main(String[] args) throws RemoteException {
        // Server impl
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        BillingService billingService = (BillingService) UnicastRemoteObject
                .exportObject(new BillingServiceImpl(), 0);
        Registry registry = LocateRegistry.getRegistry();

        registry.rebind("BillingServer", billingService);
        System.out.println("Server started");
    }

    @Override
    public void deleteInvoice(int invoiceId) throws RemoteException {
        for (int i = 0; i < registeredInvoices.size(); i++) {
            if (registeredInvoices.get(i).getId() == invoiceId) {
                registeredInvoices.remove(i);
                return;
            }
        }
    }
}
