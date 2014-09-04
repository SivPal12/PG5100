package no.nith.pg5100;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import no.nith.pg5100.exceptions.BillingDuplicateInvoiceException;

import org.junit.Before;
import org.junit.Test;

public class BillingServiceImplTest {
    private static final Invoice DEFAULT_INVOICE = new Invoice(1, "", "",
            new BigDecimal("50"));
    private BillingServiceImpl billingServiceImpl;

    @Before
    public void setUp() {
        billingServiceImpl = new BillingServiceImpl();
    }

    @Test
    public void registerInvoice() throws Exception {
        billingServiceImpl.registerInvoice(new Invoice(1, "test customer", "test address", new BigDecimal(0)));
        assertEquals(1, billingServiceImpl.getRegisteredInvoices().size());
    }

    @Test
    public void getTotalAmount() throws Exception {
        billingServiceImpl.registerInvoice(DEFAULT_INVOICE);
        billingServiceImpl.registerInvoice(new Invoice(2, "", "",
                new BigDecimal("50")));
        assertEquals(100, billingServiceImpl.getTotalAmount().intValue());
    }

    @Test(expected = BillingDuplicateInvoiceException.class)
    public void registerInvoiceNoDuplicate() throws Exception {
        billingServiceImpl.registerInvoice(DEFAULT_INVOICE);
        billingServiceImpl.registerInvoice(DEFAULT_INVOICE);
    }

    @Test
    public void deleteInvoice_DeletesInvoice_GetInvoiceReturnsNull()
            throws Exception {
        billingServiceImpl.registerInvoice(DEFAULT_INVOICE);
        List<Invoice> registeredInvoices = billingServiceImpl
                .getRegisteredInvoices();
        Invoice invoice = registeredInvoices.get(0);
        assertEquals(DEFAULT_INVOICE, invoice);
        billingServiceImpl.deleteInvoice(DEFAULT_INVOICE.getId());
        assertEquals(0, billingServiceImpl.getRegisteredInvoices().size());
    }
}
