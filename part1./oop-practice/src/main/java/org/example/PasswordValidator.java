package org.example;

public class PasswordValidator {

    /**
     * password must be at least 8 ana at most 12 characters
     * otherwise throw IllegalArgumentException error.
     */
    public void validate(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("password must be at least 8 and at most 12 characters");
        }
    }

    public void validate2(PasswordGeneratePolicy passwordGeneratePolicy) {
        String password = passwordGeneratePolicy.generatePassword();

        int length = password.length();
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
        }
    }
}
