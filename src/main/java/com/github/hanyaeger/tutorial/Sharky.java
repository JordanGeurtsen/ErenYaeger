package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Sharky extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider {

    protected Sharky(Coordinate2D initialLocation) {
        //super("sprites/hanny.png", location, new Size(20,40), 1, 2);
        super("sprites/sharky.png",initialLocation, new Size(80,100), 1, 19);//, new Size(20,15), 1, 2 );
        setMotion(3, 90d);
        setAutoCycle(80);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(-80);
        //Random height = new Random((long)getSceneHeight());
        setAnchorLocationY(getSceneHeight() / 8 * 3);
        }

}
