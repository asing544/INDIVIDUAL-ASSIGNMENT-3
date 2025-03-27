package hw3;

/**
 * The {@code PasswordEvaluator} class provides functionality to evaluate 
 * the validity and strength of a given password.
 * <p>
 * A password is validated based on:
 * <ul>
 *   <li>Length between 8 and 32 characters</li>
 *   <li>At least one uppercase letter</li>
 *   <li>At least one lowercase letter</li>
 *   <li>At least one digit</li>
 *   <li>At least one special character</li>
 * </ul>
 * If valid, it is categorized as Fair, Strong, or Very Strong based on length.
 */
public class PasswordEvaluator {

    /**
     * Default constructor.
     */
    public PasswordEvaluator() {}

    /**
     * Evaluates the strength or validity of a password string.
     *
     * @param password the password to evaluate
     * @return a string describing the password's validity or strength
     */
    public static String evaluatePassword(String password) {
        if (password.length() < 8) {
            return "Invalid – Too Short";
        }
        if (password.length() > 32) {
            return "Invalid – Too Long";
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        if (!hasUpper) {
            return "Invalid – Missing Uppercase";
        }
        if (!hasLower) {
            return "Invalid – Missing Lowercase";
        }
        if (!hasDigit) {
            return "Invalid – Missing Number";
        }
        if (!hasSpecial) {
            return "Invalid – Missing Special Character";
        }

        int length = password.length();

        if (length >= 8 && length <= 11) {
            return "Valid – Fair";
        } else if (length >= 12 && length <= 16) {
            return "Valid – Strong";
        } else {
            return "Valid – Very Strong";
        }
    }
}
