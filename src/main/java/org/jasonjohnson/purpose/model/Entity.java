package org.jasonjohnson.purpose.model;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import org.jasonjohnson.purpose.gui.MaskedMouseEvent;


public abstract class Entity {
  public static int xOffset = 0;
  public static int yOffset = 0;
  public static int xEventOffset = 0;
  public static int yEventOffset = 0;
  protected float x;
  protected float y;
  
  /**
   * The delta value will arrive as a long type. When calculating how much
   * another value has changed over time, follow these steps:
   *    1) Promote delta to float.
   *    2) Divide delta by 1,000 - demoting it to a seconds value.
   *    3) Multiply delta by the rate of change (in per-second format) of the
   *       value under simulation.
   *    4) Use this calculated value to mutate the "position in time" of the
   *       value under simulation.
   * 
   * For example, suppose we have a player moving at 100 units per second. Our
   * simulation just ticked another 20ms (50 ticks per second):
   *    1) delta is 20ms
   *    2) delta/1000 is 0.02 seconds
   *    3) delta * speed is 2.0
   *    4) player.x += 2.0
   */
  public abstract void update(long delta);
  
  /**
   * Called from whichever Scene sub-class has asked this Entity to be
   * rendered.
   */
  public abstract void render(Graphics2D graphics);
  
  public void mouseInput(MaskedMouseEvent e) {
    System.out.println("Ignoring mouse event: " + e);
  }
  
  public void keyInput(KeyEvent e) {
    System.out.println("Ignoring key event: " + e);
  }
  
  public int getX() {
    return (int)x;
  }
  
  public int getY() {
    return (int)y;
  }
}