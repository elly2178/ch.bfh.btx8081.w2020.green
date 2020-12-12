package model;

import common.Address;
import common.Person;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;
/**
 * Class representing a doctor.
 */

@Entity
public class Doctor extends Person {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private String location;

    @ManyToOne
    private List<Patient> patients;


    public Doctor(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email, String phone) {
        super(firstName, secondName, birthDate, gender, address, email, phone);
    }

    public Doctor() {
        super();
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

}
