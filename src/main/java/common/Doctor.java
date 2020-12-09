package common;

import model.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a doctor.
 */

public class Doctor extends Person {

    private int id;
    private String title;
    private String location;
    private List<Patient> patients = new ArrayList<>();


    public Doctor(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email, String phone) {
        super(firstName, secondName, birthDate, gender, address, email, phone);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
