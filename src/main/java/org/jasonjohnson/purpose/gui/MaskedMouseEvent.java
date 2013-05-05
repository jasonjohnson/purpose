package org.jasonjohnson.purpose.gui;

import java.awt.event.MouseEvent;


/**
 * Because we've done horrible things to our coordinate system, we need to
 * create a composite type here so we have an opportunity to intervene. See
 * getX(), getY() and dispatchMouseEvent().
 */
public class MaskedMouseEvent {
  private MouseEvent mouseEvent;
  
  public MaskedMouseEvent(MouseEvent mouseEvent) {
    this.mouseEvent = mouseEvent;
  }
  
  public MouseEvent getMouseEvent() {
    return mouseEvent;
  }
  
  public int getID() {
    return getMouseEvent().getID();
  }
  
  public int getX() {
    return Math.abs(getMouseEvent().getX());
  }
  
  public int getY() {
    return Math.abs(getMouseEvent().getY());
  }
}