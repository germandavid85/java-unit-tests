package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PayrollWithDummyTest {
    PaymentDataAccess db = new DBDummy();
    private Payroll payroll = new Payroll(db);

    @Test
    public void doAPayrollTest() throws Exception {
        payroll.calculateAndPay("e1", 1100.98);

        double actualPayment = payroll.getCurrentPayment("e1");

        assertThat(actualPayment, equalTo(1100.98));
    }

    @Test
    public void doAPayrollDBTest() throws Exception {
        payroll.calculateAndPay("e1", 1100.98);

        double actualPayment = db.getPayment("e1");

        assertThat(actualPayment, equalTo(1100.98));
    }
}
