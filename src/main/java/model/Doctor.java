package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import model.common.Address;
import model.common.Person;
/**
 * Class representing a doctor.
 */

@Entity
@Table(name = "doctors")
public class Doctor extends Person implements Serializable {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String title;

    @Column
    private String location;

    @OneToMany
    private List<Patient> patients;

    public Doctor(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address, String email, String phone, String title) {
        super(firstName, secondName, birthDate, gender, address, email, phone);
    }

    public Doctor() {
        super();
    }

    public String getTitle() {
        return this.title;
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
