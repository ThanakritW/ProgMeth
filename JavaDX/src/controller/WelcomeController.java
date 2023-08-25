package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;
import router.AppPage;
import router.Router;

public class WelcomeController implements BaseController {
    @FXML
    private Button welcomeButton;

    @Override
    public void start() {
        Duration delay = Duration.seconds(2);
        Timeline timeline = new Timeline(
                new KeyFrame(delay, event -> {
                    enableWelcome();
                }));
        timeline.play();
    }

    @FXML
    public void buttonHandler() {
        Router.getInstance().push(AppPage.SONG_SELECTION);
    }

    public void enableWelcome() {
        welcomeButton.setDisable(false);
    }
}
