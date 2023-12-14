import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{   
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        
        // Check mouse info
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if(mouseInfo != null) {
            int x = mouseInfo.getX();
            int y = mouseInfo.getY();
            setLocation(x, y);
        }

        checkIfEatApple();
    }

    private void checkIfEatApple() {
        // Eat the apple
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }
}
