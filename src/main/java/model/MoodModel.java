package model;

import javax.persistence.Id;

public class MoodModel {
	private int moodScore;

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
 