package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "019853619835",
                LocalDate.of(2000, 1, 1)
        );

        // System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid, we can store customer in db

        // Using combinator pattern

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
