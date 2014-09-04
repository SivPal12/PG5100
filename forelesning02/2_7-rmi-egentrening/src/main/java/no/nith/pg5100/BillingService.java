package no.nith.pg5100;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BillingService extends Remote {
    void registerInvoice(Invoice invoice) throws RemoteException;

    List<Invoice> getRegisteredInvoices() throws RemoteException;

    BigDecimal getTotalAmount() throws RemoteException;

    void deleteInvoice(int invoiceId) throws RemoteException;
}
