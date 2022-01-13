package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0900098231489134"));
        System.out.println(isPhoneNumberValid("070000000000"));

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0900098231489134"));
        System.out.println(isPhoneNumberValidPredicate.test("070000000000"));

        System.out.println("chaining predicates");
        System.out.println(
                "Is phone number valid and contains number 3: " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("0700098231489134"));
        System.out.println(
                "Is phone number valid and contains number 3: " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("0700098231489134"));
        System.out.println(
                "Is phone number valid and contains number 3: " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("07000000300"));

        System.out.println("testint biPredicates");
        System.out.println(isPhoneNumberValidBiPredicate.test("071200", "2"));
    }

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> isPhoneNumberValidBiPredicate = (phonenumber, number) -> phonenumber.startsWith("07") && number.contains("3");
}
