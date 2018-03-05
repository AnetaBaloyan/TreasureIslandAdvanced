package treasureislandadvanced;

/**
 *
 * @author anetabaloyan
 */
public class User {
    
    private int x, y; //Horizontal and vertical coordinates of the user’s position.
    private double alpha = 0; //Direction to which the character is looking (0 = horizontal to the right).
    private int life = 3; //Amount of damage the user can receive from bombs before dying.
    private int value = 0; //value of the treasures accumulated during the game (initially 0).
    private int speed = 10; //Maximum distance the user can advance in one step.

    
    public User(int x,int y,int alpha,int life,int speed) {
    
        this.x = x;
        this.y = y;
        this.alpha = alpha * Math.PI / 180;
        this.life = life;
        this.speed = speed;
    }
    
    public void advance (double dist) {
    
        if(dist <= this.speed) {
            x += Math.cos(this.alpha) * dist;
            y += Math.sin(this.alpha) * dist;
        }
    }
    
    public void rotate (double alpha) {
    
        this.alpha += (alpha * Math.PI / 180);
    }
    
    public boolean dead () {
        
        return (this.life <= 0);
    }
    
    public void addTreasure (int x) {
    
        this.value += x;
    }
    
    public void subtractLife(int x) {
    
        this.life -= x;
    }
    
    public int getx() {
    
        return this.x;
    }
    
    public int gety() {
    
        return this.y;
    }
    
    public void addValue(int value) {
    
        this.value += value;
    }
    
    public void damage(int damage) {
    
        this.life -= damage;
    }
    
    public int getLife() {
    
        return this.life;
    }
    
    public int getValue() {
    
        return this.value;
    }
}
