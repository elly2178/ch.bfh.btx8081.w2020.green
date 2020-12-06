package common;

import java.time.LocalDate;
import java.util.Date;

public class Staff extends Person{

    public Staff(String firstName, String secondName, LocalDate birthDate, boolean gender, Address address,
			String email, String phone) {
		super(firstName, secondName, birthDate, gender, address, email, phone);
		// TODO Auto-generated constructor stub
	}

	private int staffId;
    private String department;
    private String certification;
    private Date joinedDate;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }
}
