import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int score = 0;
    private Label scoreLabel;
    TitleWorld titleWorld;   
    
    
    public MyWorld(TitleWorld titleWorld)
    {    
        super(600, 400, 1, false);
        this.titleWorld = titleWorld;
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        spawnApple();
        
        scoreLabel = new Label(score, 70);
        addObject(scoreLabel, 50, 50);
        
    }
    
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 90);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    
    public void increaseScore() {
        score = score + 1;
        scoreLabel.setValue(score);
    }
    
    public void spawnApple() {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Apple apple = new Apple();
        addObject(apple, x, y);
    }
}
