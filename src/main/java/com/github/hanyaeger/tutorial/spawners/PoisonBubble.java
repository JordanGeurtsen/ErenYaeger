package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.Hanny;
import javafx.scene.paint.Color;

public class PoisonBubble extends DynamicCircleEntity implements Collided, SceneBorderCrossingWatcher {
    public PoisonBubble(int speed, Coordinate2D initialLocation){
        super(initialLocation); //, new Size(50, 50));
        setRadius(5.0);
        //setStrokeWidth(50.0);
        setFill(Color.GREENYELLOW); // TRANSPARRENT
        setOpacity(100.0);
        setMotion(speed, 180d);
    }

    @Override
    public void onCollision(Collider collidingObject){
        var popSound = new SoundClip("audio/pop.mp3");
        popSound.play();

        remove();
        Hanny.health --;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        Coordinate2D liveLocation = getAnchorLocation();
        if(liveLocation.getY() < 0){
            remove();
        }
    }

}