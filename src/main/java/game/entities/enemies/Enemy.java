package game.entities.enemies;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import game.PathStep;
import game.scenes.gamescreen.GameScreen;

import static game.scenes.gamescreen.GameScreen.points;

public abstract class Enemy extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private final Coordinate2D initialLocation;
    protected GameScreen gameScreen;
    private double mapProgress;
    public PathStep pathStep = PathStep.ZERO;

    public Enemy(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
        super(resource, initialLocation, new Size(75));
        this.initialLocation = initialLocation;
        this.gameScreen = gameScreen;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setDirection(Direction.DOWN);
    }

    public abstract void setMovementSpeed(MovementSpeed movementSpeed);

    public abstract double getMovementSpeed();

    public abstract int getHealth();

    public abstract void setHealth(double newHealth);

    public abstract int getDamage();

    public Coordinate2D getInitialLocation() {return initialLocation;}

    public PathStep getPathStep() {return pathStep;}

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        enemyPastBorder(this, getDamage());
    }

    public void enemyPastBorder(Enemy enemy, int damage) {
        gameScreen.enemyList.remove(enemy);
        gameScreen.spawnedEnemyList.remove(enemy);
        enemy.remove();
        gameScreen.lives -= damage;
        gameScreen.liveCounter.updateCounter("Lives: ", -damage);
        int pointPenalty = 10;
        points -= pointPenalty;
        gameScreen.pointCounter.updateCounter("Points: ", -pointPenalty);
    }

    public void setPathStep(PathStep newPathStep){this.pathStep = newPathStep;}

    public void updateWalkedDistance(double distanceWalked){
        this.mapProgress += distanceWalked;
    }

    public double getMapProgress(){
        return this.mapProgress;
    }

    public void setMapProgress(double mapProgress){
        this.mapProgress = mapProgress;
    }

    public double pathLimit(int tile){
        return  (tile - 1) * gameScreen.blockSize + (gameScreen.blockSize / 2.0);
    }
    public void enemyPath() {
        for (Enemy e : gameScreen.spawnedEnemyList) {
            Coordinate2D coordinates =  e.getAnchorLocation();
            PathStep pathStep = e.getPathStep();

            switch(pathStep) {
                case ZERO:
                    e.setDirection(Direction.DOWN);
                    if (coordinates.getY() > pathLimit(2)) {
                        e.setPathStep(PathStep.ONE);
                    }
                    break;
                case ONE:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(11)) {
                        e.setPathStep(PathStep.TWO);
                    }
                    break;
                case TWO:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setPathStep(PathStep.THREE);
                    }
                    break;
                case THREE:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(7)) {
                        e.setPathStep(PathStep.FOUR);
                    }
                    break;
                case FOUR:
                    e.setDirection(Direction.UP);
                    if(coordinates.getY() < pathLimit(4)) {
                        e.setPathStep(PathStep.FIVE);
                    }
                    break;
                case FIVE:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(4)) {
                        e.setPathStep(PathStep.SIX);
                    }
                    break;
                case SIX:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(5)) {
                        e.setPathStep(PathStep.SEVEN);
                    }
                    break;
                case SEVEN:
                    e.setDirection(Direction.LEFT);
                    if(coordinates.getX() < pathLimit(2)) {
                        e.setPathStep(PathStep.EIGHT);
                    }
                    break;
                case EIGHT:
                    e.setDirection(Direction.DOWN);
                    if(coordinates.getY() > pathLimit(8)) {
                        e.setPathStep(PathStep.NINE);
                    }
                    break;
                case NINE:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(6)) {

                        e.setPathStep(PathStep.TEN);
                    }
                    break;
                case TEN:
                    e.setDirection(Direction.UP);
                    if(coordinates.getY() < pathLimit(7)) {
                        e.setPathStep(PathStep.ELEVEN);
                    }
                    break;
                case ELEVEN:
                    e.setDirection(Direction.RIGHT);
                    if(coordinates.getX() > pathLimit(13)) {
                        e.setDirection(Direction.DOWN);
                    }
                    break;
                case TWELVE:
                    if (coordinates.getY() > pathLimit(0)) {
                        e.setPathStep(PathStep.ZERO);
                    }
                    break;
                default:
                    e.setPathStep(PathStep.ZERO);
                    System.out.println("ERROR: pathStep is wrong");
                    break;
            }
        }
    }

}
