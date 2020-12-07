package model;
/**
 * model
 * @author ADEK
 *
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

	public void addition(int arg) {
		ybocsScore = ybocsScore + arg;	
	}

}
