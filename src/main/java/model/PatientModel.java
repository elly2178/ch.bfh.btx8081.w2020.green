package model;
 

public class PatientModel {
	int ybocs;
	int mood;
	int combined = ybocs + mood;
	 
	//calculateAVr score
	public float calculateAvarageScore() {
		int inputTime = 14;
		float avarageScore = (float) combined / inputTime;
		return avarageScore;
		
	}
}
