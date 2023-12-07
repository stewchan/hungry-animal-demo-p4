import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    GreenfootSound sound = new GreenfootSound("sounds/elephantcub.mp3");
    GreenfootImage[] rightImages = new GreenfootImage[8];
    GreenfootImage[] leftImages = new GreenfootImage[8];
    SimpleTimer animationTimer = new SimpleTimer();
    boolean facingRight = true;

    public Elephant() {
        for(int i = 0; i < rightImages.length; i++) {
            rightImages[i] = new GreenfootImage("images/elephant_idle/idle" + i +".png");
            rightImages[i].scale(100, 100);
        }
        for(int i = 0; i < leftImages.length; i++) {
            leftImages[i] = new GreenfootImage("images/elephant_idle/idle" + i +".png");
            leftImages[i].scale(100, 100);
            leftImages[i].mirrorHorizontally();
        }
        setImage(rightImages[3]);
        animationTimer.mark();
    }

    private int indexFrame = 0;
    public void animateElephant() {
        if(animationTimer.millisElapsed() > 100) {
            if(facingRight) {
                indexFrame = (indexFrame + 1) % rightImages.length;
                setImage(rightImages[indexFrame]);
            } else {
                indexFrame = (indexFrame + 1) % leftImages.length;
                setImage(leftImages[indexFrame]);
            }
            animationTimer.mark();
        }
    }

    public void act()
    {
        // Animate the elephant
        animateElephant();

        // Move the elephant
        if(Greenfoot.isKeyDown("a")){
            Log.info(getX());
            facingRight = false;
            move(-2);    
        }
        if(Greenfoot.isKeyDown("d")){
            facingRight = true;
            move(2);
        }

        eat();
        checkIfLeftScreen();
    }
    
    /**
     * Check if elephant left the screen to the left
     */
    public void checkIfLeftScreen(){
        if(getX() < 0) {
            MyWorld world = (MyWorld) getWorld();
            world.toTitleWorld();
        }
    }

    /**
     * Check that Elephant eats the apple
     */
    public void eat() {
        // Eat the apple
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            sound.play();
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
        }
    }

}
