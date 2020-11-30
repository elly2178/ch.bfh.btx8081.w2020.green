package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a company.
 */
public class Company {

    private String name;
    private Address address;
    private List<Branch> list;

    public List<Branch> listBranches(){
        return list;
    }

    public void addBranch(int id, String branchName, int phoneNumber) {

        Branch branch = new Branch(id, branchName, phoneNumber);
        list.add(branch);
    }

    public void removeBranch(){

    }
}

