import org.example.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PasswordValidatorTest {

    /**
     * password must be at least 8 and at most 12 characters
     * otherwise throw IllegalArgumentException error.
     * check boundary condition
     */
    @DisplayName("password must be at least 8 and at most 12 characters")
    @Test
    void validatePasswordTest() {
        // given
        String password = "anyPassword";
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate(password))
                .doesNotThrowAnyException();
    }

    @DisplayName("If boundary condition fail, throw IllegalArgumentException error")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String value) {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("password must be at least 8 and at most 12 characters");
    }

    /**
     * Writing code that is easy to test lead us to build low coupling
     */
    @DisplayName("password must be at least 8 and at most 12 characters")
    @Test
    void validatePasswordTest2() {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate2(new CorrectPasswordGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("If boundary condition fail, throw IllegalArgumentException error")
    @Test
    void validatePasswordTest3() {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate2(new WrongPasswordGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("password must be at least 8 and at most 12 characters");
    }
}
