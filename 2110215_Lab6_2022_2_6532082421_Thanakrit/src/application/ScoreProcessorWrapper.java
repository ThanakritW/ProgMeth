package application;

import javafx.scene.control.Label;

public class ScoreProcessorWrapper extends Thread{
	private ScoreProcessor scoreProcessor;
	public ScoreProcessorWrapper(BeatMap beatMap, KeyPressTiles keyPressTiles, Label hitScoreLabel, Label missScoreLabel) {
		scoreProcessor = new ScoreProcessor(beatMap, keyPressTiles, hitScoreLabel, missScoreLabel);
	}
	public void run() {
		scoreProcessor.executeScoreProcessor();
	}
}
