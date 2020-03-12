import greenfoot.*;

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author Greeps Group 5 
 * @version 0.2
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }
    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        if (carryingTomato()) {
            spit("red"); 
          if(atWater() )
          {
              turn(60);
              move();
          }
      
        if (atShip()) {
            dropTomato();
        }
        else {
            turnHome();
            move();
            
            if(atWater() )
            {
                turn(75);
                move();
            }
            
        }
        
        }
        else {
            move();
            checkFood();
            if(atWater() || isAtEdge())
            {
                spit("orange");
                turn(75);
                move(2);
            }
            
            if(isTouching(Greep.class))
            {
                move();
            }
        }
    }
    
    public void seeRed()
    {
        if(seePaint("red"))
        {
            
        }
    }
    
    
    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            loadTomato();
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
            spit("red");
        }
        else {
            move();
        }
    } 
    
    
    
    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Anonymous";  // write your name here!
    }

    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if (carryingTomato()) {
            return "greep-with-food.png";
        }
        else {
            return "greep.png";
        }
    }
}