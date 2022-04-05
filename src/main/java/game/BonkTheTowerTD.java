package game;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import game.scenes.FinalScreen;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

public class BonkTheTowerTD extends YaegerGame {
    private int screenWidth = 1238;
    private int screenHeight = 675;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Bonk The Tower TD");
        setSize(new Size(screenWidth, screenHeight));
    }

    @Override
    public void setupScenes() {
        addScene(1, new TitleScreen(this));
        addScene(2,new GameScreen(this));
        addScene(3, new FinalScreen(this));
    }
}
