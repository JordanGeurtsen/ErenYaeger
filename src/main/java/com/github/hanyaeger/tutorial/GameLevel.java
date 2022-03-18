package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private Waterworld waterworld;

    public GameLevel(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var swordfishy = new SwordFish(
                new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(swordfishy);

        var healthText  = new HealthText(
                new Coordinate2D(50,50));
        addEntity(healthText);

        var bubblesPoppedText  = new BubblesPoppedText(
                new Coordinate2D(getWidth()- 50,getHeight() - 50));
        addEntity(bubblesPoppedText);

        var hanny = new Hanny(
                new Coordinate2D(getWidth() - 50, 50), healthText, bubblesPoppedText, waterworld);
        addEntity(hanny);

        var sharky = new Sharky(
                new Coordinate2D(0 ,100));
        addEntity(sharky);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new BubbleSpawner(getWidth(), getHeight()));
    }
}
