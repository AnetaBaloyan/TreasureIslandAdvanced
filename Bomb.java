package treasureislandadvanced;

/**
 *
 * @author anetabaloyan
 */
public class Bomb extends ObjectMap{
    
    int damage;
     
    public Bomb(int x, int y, int d) {
    
        super(x, y);
        
        this. damage = d;
        this.x = x;
        this.y = y;
    }
    
    @Override public void found (User x) {
    
        x.damage(this.damage);
        this.disable();
    }
    
    @Override public int getValue() {
    
        return this.damage;
    }
}
