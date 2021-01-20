package unit.tests;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.mockito.AdditionalMatchers;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.lifecycle.BeforeTry;

@Ignore
public class PayrollPBTest {
    private PaymentDataAccess dbMock;
    private Payroll payroll;

    @BeforeTry
    public void trySetup() {
        dbMock = mock(DB.class);
        payroll = new Payroll(dbMock);
    }

    @Property
    public void everyPayrollIsPositive(@ForAll @DoubleRange(min = 0.1) Double payment, @ForAll @DoubleRange(min = 0.0, max = 0.99) Double taxes)
            throws Exception {
        when(dbMock.getDiscount("taxes")).thenReturn(taxes);

        payroll.calculateAndPay("e1", payment);

        verify(dbMock).setPayment(eq("e1"), AdditionalMatchers.geq(0.0));
    }

    @Property
    public void zeroPaymentIdAlwaysZeroAfterTaxes(@ForAll @DoubleRange(min = 0.0, max = 1.0) Double taxes)
            throws Exception {
        when(dbMock.getDiscount("taxes")).thenReturn(taxes);

        payroll.calculateAndPay("e1", 0.0);

        verify(dbMock).setPayment(eq("e1"), AdditionalMatchers.eq(0.0, 0.0));
    }

    @Property
    public void employeeCanPay100PercentSalaryInTaxes(@ForAll @DoubleRange(min = 100.0) Double payment)
            throws Exception {
        when(dbMock.getDiscount("taxes")).thenReturn(1.0);

        payroll.calculateAndPay("e1", payment);

        verify(dbMock).setPayment(eq("e1"), AdditionalMatchers.eq(0.0, 0.0));
    }
}
