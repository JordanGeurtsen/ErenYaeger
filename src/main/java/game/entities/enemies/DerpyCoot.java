package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class DerpyCoot extends Enemy{
        private int health = 20;
        private double speed = 1.8;
        private Direction direction = Direction.LEFT;
        private double walkedDistance = 0.0;
        private Coordinate2D initialLocation;

        public DerpyCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
                super(resource, initialLocation, gameScreen);
                this.initialLocation = initialLocation;
                setMotion(speed, direction);
        }

        public int getHealth() {
                return health;
        }

        @Override
        public void setHealth(double newHealth) {
                this.health += newHealth;
        }

        public double getMovementSpeed(){return speed;}

        @Override
        public void setMovementSpeed(MovementSpeed movementSpeed) {
                switch (movementSpeed){
                        case SLOW :
                                speed = 1.1;
                                direction = Direction.UP;
                                setMotion(speed, direction);
                                break;
                        case NORMAL:
                                speed = 1.8;
                                direction = Direction.LEFT;
                                setMotion(speed, direction);
                }
        }
}
