package game.entities.towers;

import com.github.hanyaeger.api.Coordinate2D;
import game.entities.enemies.Enemy;

import java.util.ArrayList;

public class Archer extends Tower {
    double price = 100.0;
    int rangeRadius = 100;
    int cooldown;
    int damage;
    ArrayList<Enemy > enemyList; // delete later, list isn't made yet in other class
    ArrayList<Enemy> targets = new ArrayList<>();
    int maxHealth = 0;
    Enemy target;

    public Archer(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public Arrow attackForm() {
        //if(isInRange(rangeRadius, enemyList)){ dit in set up entities met if(){ attackForm();}
            for(Enemy e : enemyList){
                if(distanceTo(e) < rangeRadius){
                    targets.add(e);
                }
            }
            for(Enemy e : targets){
                // get strongest / closest enemy, seriously who does he hit?
                if(e.getHealth() > maxHealth){
                    maxHealth = e.getHealth();
                }
            }
           var arrow = new Arrow("sprites/baby_coot.png", initialLocation, target);
            return arrow;
//            addEntity(arrow);
            // dit mag niet. kan return targetCoordinates and make arrow in GameScreen
        }
    }


}
