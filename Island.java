package treasureislandadvanced;

/**
 *
 * @author anetabaloyan
 */
public class Island {
    
    public int R;
    
    public Island(int r) {
    
        R = r;
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

    }
    
    public boolean crossedTheBorder(double x, double y) {
    
        return (R < distance(0, 0, x, y));
    
    }
}

