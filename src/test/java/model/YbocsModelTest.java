package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class YbocsModelTest {

    YbocsModel ybocsModel = new YbocsModel();

    @Test
    public void initialTest(){
        assertEquals(0, ybocsModel.getYbocsScore());
    }

    @Test
    public void getYbocsScore() {
        ybocsModel.setYbocsScore(25);
        assertEquals(25, ybocsModel.getYbocsScore());
    }

    @Test
    public void getYbocsScoreAsString() {
        ybocsModel.setYbocsScore(30);
        String str = ybocsModel.getYbocsScoreAsString();
        assertTrue(ybocsModel.getYbocsScoreAsString() instanceof String);
    }

    @Test
    public void setYbocsScore() {
        ybocsModel.setYbocsScore(17);
        assertEquals(17, ybocsModel.getYbocsScore());
    }

    @Test
    public void addition() {
        int i = 23;
        ybocsModel.setYbocsScore(0);
        ybocsModel.addition(i);
        assertEquals(i, ybocsModel.getYbocsScore());

    }
}