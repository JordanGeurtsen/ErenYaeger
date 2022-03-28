package game;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import game.scenes.FinalScreen;
import game.scenes.GameScreen;
import game.scenes.TitleScreen;

public class BonkTheTowerTD extends YaegerGame {
    public static void main(String[] args) {launch(args);}

    @Override
    public void setupGame() {
        setGameTitle("Bonk The Tower TD");
        setSize(new Size(1238, 675));
        setBackgroundAudio("audio/relaxing_bg_music.mp3");
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScreen(this));
        addScene(1, new GameScreen(this));
        addScene(2, new FinalScreen(this));
    }
}
