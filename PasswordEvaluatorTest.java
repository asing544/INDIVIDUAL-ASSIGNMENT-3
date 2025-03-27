package hw3;

/**
 * The {@code PasswordEvaluatorTest} class runs automated test cases
 * to verify the behavior of the {@link PasswordEvaluator} class.
 * <p>
 * It prints each test's password, expected output, actual output,
 * and whether the test passed or failed.
 */
public class PasswordEvaluatorTest {

    /**
     * Default constructor.
     */
    public PasswordEvaluatorTest() {}

    /**
     * The entry point of the program. Executes all test cases.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with expected results
        String[][] testCases = {
            {"Db1!", "Invalid – Too Short"},
            {"devinbooker!1", "Invalid – Missing Uppercase"},
            {"DevBooker1!", "Valid – Fair"},
            {"DevinBooker!@KevinDurant1&*(", "Valid – Very Strong"},
            {"DevinBooker!@#$KevinDurant&#*$SGA1234AnthonyEdwards", "Invalid – Too Long"}
        };

        int passedCount = 0;

        // Run each test case
        for (String[] testCase : testCases) {
            String password = testCase[0];
            String expected = testCase[1];
            String actual = PasswordEvaluator.evaluatePassword(password);
            boolean passed = expected.equals(actual);

            if (passed) passedCount++;

            System.out.println("--------------------------------------------------");
            System.out.println("Password:        " + password);
            System.out.println("Expected Output: " + expected);
            System.out.println("Actual Output:   " + actual);
            System.out.println("Test Result:     " + (passed ? "PASSED" : "FAILED"));
            System.out.println("--------------------------------------------------\n");
        }

        // Summary
        System.out.println("Total Tests: " + testCases.length);
        System.out.println("Passed:      " + passedCount);
        System.out.println("Failed:      " + (testCases.length - passedCount));
    }
}
