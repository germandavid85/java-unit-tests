package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayrollTest
{
    private Payroll payroll;

    @BeforeAll
    public static void globalSetup()
    {
        DB.setPayment("e1", 1000.0);
        DB.setPayment("e2", 1100.0);
        DB.setPayment("e3", 800.0);
        DB.setPayment("e4", 20.25);
    }

    @BeforeEach
    public void setup()
    {
        payroll = new Payroll();
    }

    // @AfterAll
    // public static void globalTearDown()
    // {
    //     DB.setPayment("e1", 1000.0);
    //     DB.setPayment("e2", 1100.0);
    //     DB.setPayment("e3", 800.0);
    //     DB.setPayment("e4", 20.25);
    // }

    @Test
    public void doAPayroll() throws Exception
    {
        assertThat(payroll.getCurrentPayment("e1"), is(equalTo(1000.0)));

        payroll.calculateAndPay("e1", 1100.98);

        assertThat(payroll.getCurrentPayment("e1"), is(closeTo(935.83, 0.02)));
    }

    @Test
    public void getCurrentPaymentTest() throws Exception
    {
        assertThat(payroll.getCurrentPayment("e1"), is(equalTo(1000.0)));
    }
}
