import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        spawnApple();

    }
    
    public void spawnApple() {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Apple apple = new Apple();
        addObject(apple, x, y);
    }
}
