package com.github.hanyaeger.tutorial.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public SwordFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 270d);
    }

    @Override
    protected void setupEntities() {
        var swordfishSprite = new SwordFishSprite(
                new Coordinate2D(0, 0));
        addEntity(swordfishSprite);
        var swordfishHitBox = new HitBox(
                new Coordinate2D(0,40));
        addEntity(swordfishHitBox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
    }
}
