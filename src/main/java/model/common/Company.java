package model.common;

import java.util.List;

/**
 * Class representing a company.
 */
public class Company {

    private String name;
    private Address address;
    private List<Branch> list;

    public List<Branch> listBranches(){
        return this.list;
    }

    public void addBranch(int id, String branchName, int phoneNumber) {

        Branch branch = new Branch(id, branchName, phoneNumber);
        this.list.add(branch);
    }

    public void removeBranch(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

