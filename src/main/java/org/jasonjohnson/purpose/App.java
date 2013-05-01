package org.jasonjohnson.purpose;

import org.jasonjohnson.purpose.gui.Window;
import org.jasonjohnson.purpose.scene.Menu;


public class App {
  public static long fps;
  public static long interval;
  public static long delta;
  public static long lastTick;
  public static long currentTick;
  public static Scene currentScene;
  
  public static void main(String[] args) {
    World world = World.initialWorld();
    
    // Loading
    Menu menu = new Menu(world);
    // Tutorial
    // Game ->
    //    Level01
    //    Level02
    //    Level03
    //    ...
    // Game Over
    // Score
    // <- Back to Menu
    
    // Show the user our scene.
    Window window = new Window("Purpose");
    window.loadScene(menu);
    window.display();
    
    // What is the target performance for our world?
    fps = 50;
    interval = 1000/fps;
    delta = 0;
    lastTick = now();
    currentTick = now();
    currentScene = menu;
    
    // Start the game loop!
    while(true) {
      currentTick = now();
      delta = currentTick - lastTick;
      
      world.update(delta);
      currentScene.repaint();
      
      if(delta < interval) {
        try {
          Thread.sleep(interval - delta);
        } catch(Exception e) {
          System.out.println("Could not sleep game loop!");
          System.out.println(e.getMessage());
        }
      }
      
      lastTick = currentTick;
    }
  }
  
  public static long now() {
    return System.currentTimeMillis();
  }
}