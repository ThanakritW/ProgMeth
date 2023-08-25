package pages;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.components.BriefResult;
import logic.components.ChartCard;
import logic.components.DXButton;
import logic.components.DetailedResult;
import router.Page;
import router.Router;
import store.AppState;
import store.DataManager;
import store.Setting;
import store.SoundManager;
import utils.ImageUtil;
import utils.ScoreUtil;

public class Result implements Page {
    private StackPane node;

    private BorderPane mainPane;

    private Text titleText;

    private BriefResult briefResult;
    private DetailedResult detailedResult;

    private boolean isShowingDetailedResult = false;

    @Override
    public void initialize() throws IOException {
        this.node = new StackPane();

        // TODO Change magic constant to variable
        var background = ImageUtil
                .loadImageAsView("images/SongSelectBackground.jpg", 1600, 900);

        this.mainPane = this.createMainPane();

        this.node.getChildren().addAll(background, this.mainPane);
    }

    private BorderPane createMainPane() {
        var mainPane = new BorderPane();

        mainPane.setTop(this.createTopPane());

        this.briefResult = new BriefResult();
        this.detailedResult = new DetailedResult();

        mainPane.setLeft(this.briefResult);

        this.rightPane = this.createRightPane();
        mainPane.setRight(this.rightPane);

        mainPane.setBottom(this.createBottomPane());

        return mainPane;
    }

    private ImageView cppChan;
    private ImageView javaChan;
    private VBox rightPane;

    private VBox createRightPane() {
        var rightPane = new VBox();

        this.cppChan = ImageUtil.loadImageAsView("images/CPP.png");
        this.cppChan.setFitWidth(272);
        this.cppChan.setFitHeight(481);

        this.javaChan = ImageUtil.loadImageAsView("images/JAVA.png");
        this.javaChan.setFitWidth(272);
        this.javaChan.setFitHeight(481);

        rightPane.setSpacing(8);
        rightPane.setPadding(new Insets(0, 72, 0, 0));
        rightPane.setAlignment(Pos.CENTER);
        return rightPane;
    }

    private HBox createTopPane() {
        this.titleText = new Text("PLAY RESULT");
        this.titleText.setFont(new Font("Helvetica", 96));

        var topPane = new HBox();
        topPane.getChildren().add(this.titleText);
        topPane.setPadding(new Insets(72, 0, 16, 0));
        topPane.setAlignment(Pos.CENTER);

        return topPane;
    }

    private HBox createBottomPane() {
        var bottomPane = new HBox();

        var detailButton = new DXButton("Change Message");
        detailButton.setOnAction(event -> {
            if (this.isShowingDetailedResult) {
                this.isShowingDetailedResult = false;
                this.mainPane.setLeft(this.briefResult);
            } else {
                this.isShowingDetailedResult = true;
                this.mainPane.setLeft(this.detailedResult);
            }
        });

        var nextButton = new DXButton("Next");
        nextButton.setOnAction(
                event -> Router.getInstance().reset());

        bottomPane.getChildren().addAll(detailButton, nextButton);
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        bottomPane.setPadding(new Insets(24));
        bottomPane.setSpacing(16);

        return bottomPane;
    }

    @Override
    public void onBeforeNavigatedTo() {
        this.isShowingDetailedResult = false;
        this.mainPane.setLeft(this.briefResult);
        this.rightPane = createRightPane();
        this.mainPane.setRight(this.rightPane);
        var result = AppState.getInstance().getPlayResult();
        this.briefResult.render(result);
        this.detailedResult.render(result);

        this.rightPane.getChildren().clear();
        var chartCard = new ChartCard(
                AppState.getInstance().getCurrentChart(),
                AppState.getInstance().getSelectedDifficulty());

        this.rightPane.getChildren().add(chartCard);
        if (DataManager.getInstance().get(Setting.PARTNER).equals("CPP")) {
            this.rightPane.getChildren().add(this.cppChan);
        } else {
            this.rightPane.getChildren().add(this.javaChan);
        }
    }

    @Override
    public void startPage() {
        var partner = "partner/"
                + DataManager.getInstance().get(Setting.PARTNER);

        var playResult = AppState.getInstance().getPlayResult();
        var score = ScoreUtil.calculateScore(playResult);

        if (score < ScoreUtil.RANK_D) {
            SoundManager.getInstance().playPartner(partner + "_F.wav");
        } else if (score < ScoreUtil.RANK_S) {
            SoundManager.getInstance().playPartner(partner + "_CLEAR.wav");
        } else if (score < ScoreUtil.RANK_SSS) {
            SoundManager.getInstance().playPartner(partner + "_S.wav");
        } else {
            SoundManager.getInstance().playPartner(partner + "_SSS.wav");
        }
    }

    @Override
    public Parent getNode() {
        return this.node;
    }
}
