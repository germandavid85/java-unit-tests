package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PayrollWithDummyTest {
    private Payroll payroll = new Payroll(new DBDummy());

    @Test
    public void doAPayroll() throws Exception {
        payroll.calculateAndPay("e1", 1100.98);

        double actualPayment = payroll.getCurrentPayment("e1");

        assertThat(actualPayment, equalTo(1100.98));

    }
}
