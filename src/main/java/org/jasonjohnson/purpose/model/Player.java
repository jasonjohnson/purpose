package org.jasonjohnson.purpose.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import org.jasonjohnson.purpose.gui.MaskedMouseEvent;


public class Player extends Entity {
  private float speed;
  
  public Player() {
    x = 0;
    y = 0;
    speed = 40;
  }
  
  @Override
  public void mouseInput(MaskedMouseEvent e) {
    if(e.getID() == MaskedMouseEvent.MOUSE_PRESSED) {
      x = e.getX();
      y = e.getY();
    }
  }

  @Override
  public void keyInput(KeyEvent e) {
    System.out.println(e);
  }
  
  public void update(long delta) {
    float distance = distanceTraveled((float)delta, speed);
    
    x += distance;
    y += distance;
  }
  
  public void render(Graphics2D g) {
    g.setColor(Color.WHITE);
    g.fillOval(getX()-10, getY()-10, 20, 20);
  }

  private float distanceTraveled(float delta, float speed) {
    return (delta / 1000) * speed;
  }
}