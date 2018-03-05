package treasureislandadvanced;

/**
 *
 * @author anetabaloyan
 */
public abstract class ObjectMap {
    
    protected int x, y;
    protected boolean active;
    
    
    public ObjectMap(int x, int y) {
    
        this.x = x;
        this.y = y;
        this.active = true;
    }
    
    public boolean near (User user, double minDist) {
    
        return (distance(user.getx(), user.gety(), this.x, this.y) <= 0);
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

    }
    
    public void disable() {
    
        this.active = false;
    }
    
    abstract public void found(User x);
    
    abstract public int getValue();
}
