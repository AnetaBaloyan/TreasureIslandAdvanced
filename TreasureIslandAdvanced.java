package treasureislandadvanced;

import java.util.*;
/**
 *
 * @author anetabaloyan
 */
public class TreasureIslandAdvanced {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner U = new Scanner(System.in);
        
        System.out.println("Level of difficulty: \n 1 - easy \n 2 - medium \n 3 - hard ");
        
        int input = U.nextInt();
        int a = 0, b = 0;
        User user = null;
        Island island = null;
        
        switch(input) {
        
            case 1: island = new Island(60);
                    a = 5; b = 15;
                    user = new User(0, 0, 90, 200, 20);
                    
                break;
                
            case 2: island = new Island(80);
                    a = 10; b = 25;
                    user = new User(0, 0, 90, 100, 15);
                    
                break;
                
            case 3: island = new Island(100);
                    a = 20; b = 30;
                    user = new User(0, 0, 90, 50, 10);
                    
                break;
        }
        
        ObjectMap[] map = new ObjectMap[10];
                    
        for(int i = 0; i < 5; i++) {
            
            double x = Math.random() * (island.R + 1 + island.R) - island.R;
            double y = Math.sqrt((island.R * island.R) - (x * x));
            
            map[i] = new Treasure((int)x, (int)y, (int)(Math.random() * (b + 1 - a)) + a);
            
            System.out.println(" A treasure is in (" + map[i].x + ", " + map[i].y + ")" + " Value: " + map[i].getValue());
        }
        
        for(int i = 5; i < 10; i++) {

            double x = Math.random() * (island.R + 1 + island.R) - island.R;
            double y = Math.sqrt((island.R * island.R) - (x * x));
            
            map[i] = new Bomb((int)x, (int)y, (int)(Math.random() * (b + 1 - a)) + a);
            System.out.println(" A bomb is in (" + map[i].x + ", " + map[i].y + ")" + " Damage: " + map[i].getValue());
        }
        
        while(!user.dead()) {
            
            System.out.println(" 1 - Move X meters. \n 2 - Turn Y degrees. \n 3 - Exit");

            int command = U.nextInt();

            switch(command) {

                case 1:
                    System.out.print("X = ");
                    int x = U.nextInt();
                    user.advance(x);

                    break;

                case 2:
                    System.out.print("Y = ");
                    int y = U.nextInt();
                    user.rotate(y);

                    break;

                case 3:
                    System.exit(0);

                    break;

            }
            
            if(island.crossedTheBorder(user.getx(), user.gety())) {

                System.out.println("GAME OVER!! You fell in the ocean.");
                System.exit(0);
            }
            
            for(int i = 0; i < 5; i++) {
                
                if(map[i].near(user, 3)) {
                
                    map[i].found(user);
                    System.out.println("You found a TREASURE with value " + map[i].getValue() + "!!!!!!");
                }
            }
            
            for(int i = 5; i < 10; i++) {
                
                if(map[i].near(user, 2)) {
                
                    map[i].found(user);
                    System.out.println("You stepped on a BOMB with damage " + map[i].getValue() + "!!!!!!");
                }
            }
            
            System.out.println("Your coordinates are (" + user.getx() + ", "
                    + user.gety() + ")");
            System.out.println("You are " + (int)Island.distance(0, 0, user.getx(), user.gety()) 
                    + " meters away from the center of the island.");
            System.out.println("Life: " + user.getLife() + "\nValue: " + user.getValue());
            
        }
        
    }
    
}
