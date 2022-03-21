package game;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import game.scenes.FinalScreen;
import game.scenes.MapSelector;
import game.scenes.TitleScreen;
import game.scenes.maps.MapOne;
import game.scenes.maps.MapThree;
import game.scenes.maps.MapTwo;

public class BonkTheTowerTD extends YaegerGame {
    public static void main(String[] args) {launch(args);}
    public double buttonHeightCenter = 1.5;
    public double buttonHeightBelowCenter = 1.35;
    public double buttonWidthCenter = 2.0;
    public double buttonWidthRight = 1.35;
    public double buttonWidthLeft = 4.0;


    @Override
    public void setupGame() {
        setGameTitle("Bonk The Tower TD");
        setSize(new Size(1238, 675));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScreen(this));
        addScene(1, new MapSelector(this));
        addScene(2, new MapOne(this));
        addScene(3, new MapTwo(this));
        addScene(4, new MapThree(this));
        addScene(3, new FinalScreen(this));
    }
}
