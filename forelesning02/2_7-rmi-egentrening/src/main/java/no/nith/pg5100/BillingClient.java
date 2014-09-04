package no.nith.pg5100;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BillingClient {

    private static BillingService billingService;

    // Ved remote kall, start klassen med: -Djava.security.policy=src/main/resources/security.policy
    public static void main(String[] args) throws RemoteException,
            NotBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = LocateRegistry.getRegistry("localhost");
        billingService = (BillingService) registry.lookup("BillingServer");

        Invoice invoice1 = new Invoice(1, "Kunde1", "veien 1", new BigDecimal("100.50"));
        Invoice invoice2 = new Invoice(2, "Kunde2", "veien 2", new BigDecimal(
                "99.60"));

        billingService.registerInvoice(invoice1);
        billingService.registerInvoice(invoice2);
        System.out.println("Total: " + billingService.getTotalAmount());
        billingService.deleteInvoice(invoice1.getId());
        System.out.println("Total: " + billingService.getTotalAmount());
    }
}
