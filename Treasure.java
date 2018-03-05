package treasureislandadvanced;

/**
 *
 * @author anetabaloyan
 */
public class Treasure extends ObjectMap {
    
    int value;
    
    public Treasure (int x,int y,int v) {
    
        super(x, y);
        
        this.value = v;
        this.x = x;
        this.y = y;
    }
    
    @Override public void found(User x) {
    
        x.addValue(value);
        this.disable();
        
    }
    
    @Override public int getValue() {
    
        return this.value;
    }
    
}
