package unit.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import unit.tests.extensions.TimeReportExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(TimeReportExtension.class)
public class ControllerTest {
    @Mock private Payroll payroll;

    @Mock private PTOPayment ptoPayment;

    private Controller controller;

    @BeforeEach
    private void setup() {
      when(payroll.getCurrentPayment("e1")).thenReturn(789.0);
      when(ptoPayment.getCurrentPayment("e1")).thenReturn(10.0);

      controller = new Controller(payroll, ptoPayment);
    }

    @Test
    public void calculatedPaymentsTest() throws Exception {
        EmployeePayment employeePayment = controller.calculateSalary("e1", 1100.98, 3.0);
        EmployeePayment expectedEmployeePayment = new EmployeePayment(789.0, 10.0);

        assertThat("incorrect employee payment", employeePayment, is(equalTo(expectedEmployeePayment)));
    }
}