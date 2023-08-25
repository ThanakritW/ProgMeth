package application;

public class GameCoreWrapper extends Thread{
	private GameCore gameCore;
	public GameCoreWrapper(BeatMap beatMap, NoteTiles noteTiles){
		gameCore = new GameCore(beatMap,noteTiles);
	}
	
    public void run() {
        gameCore.executeGameCore();
    }
}
