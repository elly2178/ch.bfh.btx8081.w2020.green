package model;

import javax.persistence.Id;

public class MoodModel {
	private int moodScore;
	
	/** added lines 9 to 20 for the Junit testing */
	public MoodModel(int initialScore) {
		if (initialScore <0 ) {			
			System.out.println("Initial Score can't be "+ initialScore );
			throw new IllegalArgumentException();
			// Expected in Console: Initial Score can't be -3
		}
		moodScore = initialScore;
	}
	public MoodModel() {
		this(0);
	}
	public MoodModel(String moodString) {
		this();
	}

	public int getMoodScore() {
		return moodScore;
	}

	public void setMoodScore(int moodScore) {
		this.moodScore = moodScore;
	}
	
	public void addition(int arg) {
		moodScore = moodScore + arg;
	}
	
	public String getMoodScoreAsString() {
		return String.valueOf(moodScore);
	}
}
 