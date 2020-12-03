package common;

import java.time.LocalDate;

/**
 * Class representing a doctor.
 */
public class Doctor extends Person {
    public Doctor(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email) {
        super(firstName, secondName, birthDate, gender, address, email);
    }
}
