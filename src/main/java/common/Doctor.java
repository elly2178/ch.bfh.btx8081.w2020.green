package common;

import java.time.LocalDate;

/**
 * Class representing a doctor.
 */
public class Doctor extends Person {

    private String title;
    private String location;


    public Doctor(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email, String phone) {
        super(firstName, secondName, birthDate, gender, address, email, phone);
    }


}
