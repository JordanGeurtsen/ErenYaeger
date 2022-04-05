package game.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import game.BonkTheTowerTD;
import game.Screenum;
import game.entities.buttons.QuitButton;
import game.entities.buttons.SceneSwitchButton;

public class TitleScreen extends DynamicScene{
    private final BonkTheTowerTD bonkTheTowerTD;

    public TitleScreen(BonkTheTowerTD bonkTheTowerTD) {
        this.bonkTheTowerTD = bonkTheTowerTD;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/bonk_the_tower_titlescreen.jpg");
        setBackgroundAudioVolume(0.5);
        setBackgroundAudio("audio/relaxing_bg_music.mp3");
    }

    @Override
    public void setupEntities() {
        var startButton = new SceneSwitchButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.8), this.bonkTheTowerTD, Screenum.GAME, "Play Game");
      addEntity(startButton);

        var bonkTheTowerQuit = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this.bonkTheTowerTD);
        addEntity(bonkTheTowerQuit);
    }
}
