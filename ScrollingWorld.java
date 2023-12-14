import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScrollingWorld extends World
{
    Background bg1 = new Background();
    Background bg2 = new Background();
    
    public ScrollingWorld()
    {    
        super(600, 400, 1, false); 

        bg1.setOtherBackground(bg2);
        bg2.setOtherBackground(bg1);

        addObject(bg1, 0, 200);
        addObject(bg2, 1024, 200);
    }

    public void act() {
        if(Greenfoot.mouseClicked(null)){
            bg1.increaseSpeed();
            bg2.increaseSpeed();
        }
    }
}
