package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Direction;

public class DerpyCoot extends Enemy{
        private int health = 2;
        private double speed;
        private double walkedDistance = 0.0;
        private Coordinate2D initialLocation;

        public DerpyCoot(String resource, Coordinate2D initialLocation) {
                super(resource, initialLocation);
                this.initialLocation = initialLocation;
                setMovementSpeed(MovementSpeed.NORMAL);
                setMotion(speed, Direction.LEFT);

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
                                speed = 1.0;
                                break;
                        case NORMAL:
                                speed = 1.5;
                }
        }
}
