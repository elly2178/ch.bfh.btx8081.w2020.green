package core;

public class Branch {

    private String branchName;
    private int phoneNumber;
    private int id;
    private Branch(){

    }

    public Branch(int id,String branchName, int phoneNumber){
        this.branchName = branchName;
        this.phoneNumber = phoneNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
