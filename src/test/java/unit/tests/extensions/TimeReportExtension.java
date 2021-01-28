package unit.tests.extensions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TimeReportExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeAllCallback,
        AfterAllCallback, TestWatcher {
    private long beforeTestTime = 0L;
    private static final String REPORT_FILE = "time-report.txt";

    @Override
    public void beforeTestExecution(final ExtensionContext context) throws Exception {
        beforeTestTime = System.currentTimeMillis();

        String className = context.getTestClass().get().getName();
        String methodName = context.getTestMethod().get().getName();

        FileWriter fileWriter = new FileWriter(REPORT_FILE, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.printf("  %s#%s ", className, methodName);
        printWriter.close();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        FileWriter fileWriter = new FileWriter(REPORT_FILE, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        long afterTestTime = System.currentTimeMillis();
        long duration = afterTestTime - beforeTestTime;

        printWriter.printf("took %dms", duration);
        printWriter.close();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        FileWriter fileWriter = new FileWriter(REPORT_FILE, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String className = context.getTestClass().get().getName();
        Date date = Calendar.getInstance().getTime();

        printWriter.printf("[%s] INFO starting to run tests for class %s\n", date, className);
        printWriter.close();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        FileWriter fileWriter = new FileWriter(REPORT_FILE, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String className = context.getTestClass().get().getName();
        Date date = Calendar.getInstance().getTime();

        printWriter.printf("[%s] INFO finished to run tests for class %s\n\n", date, className);
        printWriter.close();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(REPORT_FILE, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.printf(" PASSED\n");

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(REPORT_FILE, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.printf(" FAILED - %s\n", cause.getMessage());

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
