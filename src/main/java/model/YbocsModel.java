package model;
/**
 * Model for the ybocs test
 */
public class YbocsModel {
	private int ybocsScore;
	
	public int getYbocsScore() {
		return ybocsScore;
	}
	
	public String getYbocsScoreAsString() {
		return String.valueOf(ybocsScore);
	}

	public void setYbocsScore(int ybocsScore) {
		this.ybocsScore = ybocsScore;
	}

	public int addition(int arg) {
		return ybocsScore = ybocsScore + arg;		
	}

}
