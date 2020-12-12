package model.common;

/**
 * Class representing a branch.
 */
public class Branch {

	private String branchName;
	private int phoneNumber;
	private int id;

	public Branch(int id, String branchName, int phoneNumber) {
		this.id = id;
		this.branchName = branchName;
		this.phoneNumber = phoneNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public int getId() {
		return id;
	}
}
