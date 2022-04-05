package game.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import game.scenes.GameScreen;

public class DerpyCoot extends Enemy{
        private double speed = 1.3;
        private int health = 50;
        private int damage = 2;

        public DerpyCoot(String resource, Coordinate2D initialLocation, GameScreen gameScreen) {
                super(resource, initialLocation, gameScreen);
                setSpeed(speed);
        }

        public double getMovementSpeed() {return speed;}

        public int getHealth() {return health;}

        @Override
        public void setHealth(double newHealth) {this.health += newHealth;}

        @Override
        public int getDamage() {return damage;}

        @Override
        public void setMovementSpeed(MovementSpeed movementSpeed) {
                switch (movementSpeed) {
                        case SLOW:
                                speed = 1.5;
                                setSpeed(speed);
                                break;
                        case NORMAL:
                                speed = 1.3;
                                setSpeed(speed);
                                break;
                        default:
                                System.out.println("ERROR: movementSpeed is incorrect");
                                break;
                }
        }
}
