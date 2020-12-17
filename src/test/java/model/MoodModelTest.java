package model;

import org.junit.Assert;
import org.junit.Test;

public class MoodModelTest {

	@Test (expected = RuntimeException.class)
	public void minusTest() {
		MoodModel mood = new MoodModel(Integer.MIN_VALUE);
		
	}
	
	@Test
	public void plusTest() {
		MoodModel mood = new MoodModel(98);
		mood.addition(5);
		Assert.assertEquals(103, mood.getMoodScore());
	}
	
	@Test
	public void stringTest() {
		MoodModel mood = new MoodModel("random");
		Assert.assertTrue(mood.getMoodScoreAsString() instanceof String);
	}
	
}
