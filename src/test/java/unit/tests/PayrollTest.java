package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PayrollTest {
    @Mock(name = "db") private DB dbMock;
    @InjectMocks private Payroll payroll;

    @Test
    public void doAPayroll() throws Exception {
        when(dbMock.getDiscount("taxes")).thenReturn(0.15);

        payroll.calculateAndPay("e1", 1100.98);

        verify(dbMock).setPayment(eq("e1"), AdditionalMatchers.eq(935.83, 0.2));
    }

    @Test
    public void getCurrentPaymentTest() throws Exception {
        when(dbMock.getPayment("e1")).thenReturn(976.45);

        double actualPayment = payroll.getCurrentPayment("e1");

        assertThat(actualPayment, is(equalTo(976.45)));
    }
}
