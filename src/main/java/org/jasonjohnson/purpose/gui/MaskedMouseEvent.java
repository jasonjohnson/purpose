package org.jasonjohnson.purpose.gui;

import java.awt.event.MouseEvent;


/**
 * Because we've done horrible things to our coordinate system, we need to
 * create a composite type here so we have an opportunity to intervene. See
 * getX(), getY() and dispatchMouseEvent().
 */
public class MaskedMouseEvent {
  public static int MOUSE_CLICKED = MouseEvent.MOUSE_CLICKED;
  public static int MOUSE_PRESSED = MouseEvent.MOUSE_PRESSED;
  public static int MOUSE_RELEASED = MouseEvent.MOUSE_RELEASED;
  
  public int id = 0;
  public int x = 0;
  public int y = 0;
  
  public MaskedMouseEvent(MouseEvent e) {
    id = e.getID();
    x = e.getX();
    y = e.getY();
  }
  
  public int getID() {
    return id;
  }
  
  public int getX() {
    return Math.abs(x);
  }
  
  public int getY() {
    return Math.abs(y);
  }
}