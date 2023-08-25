package application;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Utility {
	public static GameCoreWrapper setUpGameCore(GameCoreWrapper gameCoreWrapper, BeatMap beatMap, NoteTiles noteTiles) {
		if(gameCoreWrapper != null) {
			gameCoreWrapper.interrupt();
		}
		gameCoreWrapper = new GameCoreWrapper(beatMap,noteTiles);
		gameCoreWrapper.start();
		return gameCoreWrapper;
	}

	public static ScoreProcessorWrapper setUpScoreProcessor(ScoreProcessorWrapper scoreProcessorWrapper,
			BeatMap beatMap, KeyPressTiles keyPressTiles, Label hitScoreLabel, Label missScoreLabel) {
		if(scoreProcessorWrapper != null) {
			scoreProcessorWrapper.interrupt();
		}
		scoreProcessorWrapper = new ScoreProcessorWrapper(beatMap, keyPressTiles, hitScoreLabel, missScoreLabel);
		scoreProcessorWrapper.start();
		return scoreProcessorWrapper;
	}

	public static void updateLabel(Label label, String newText) {
		Platform.runLater(new Runnable() {
			public void run() {				
				label.setText(newText);
			}
		});
	}

	public static void cleanUp(Menu menu) {
		if(menu.getGameCoreWrapper() != null) {
			menu.getGameCoreWrapper().interrupt();
		}
		if(menu.getScoreProcessorWrapper()!=null) {
			menu.getScoreProcessorWrapper().interrupt();
		}
	}
}
