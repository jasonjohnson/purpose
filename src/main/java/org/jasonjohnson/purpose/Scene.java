package org.jasonjohnson.purpose;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import org.jasonjohnson.purpose.gui.MaskedMouseEvent;
import org.jasonjohnson.purpose.model.Entity;


public class Scene extends JComponent implements MouseListener, KeyListener {
  private Dimension dimension;
  private World world;
  
  public Scene(World world) {
    this(world, 800, 600);
  }
  
  public Scene(World world, int width, int height) {
    this.world = world;
    this.dimension = new Dimension(width, height);
    
    // A little padding for window chrome.
    Entity.xOffset = -3;
    Entity.yOffset = -25;
    
    // Our events aren't inverted like the canvas. Need to wrap each with
    // some inversion. See Entity's getMouseX and getMouseY.
    Entity.xEventOffset = 0;
    Entity.yEventOffset = -height;
  }
  
  @Override
  public void paint(Graphics graphics) {
    Graphics2D g = (Graphics2D)graphics;
    
    // Translate and flip coordinate system.
    //  
    // (0,0) (+,0) -> (0,+) (+,+)
    // (0,+) (+,+) -> (0,0) (+,0)
    // 
    // Note: This is extremely expensive. We should do more intelligent
    // coordinate mapping beyond proof-of-concept.
    g.translate(0, getDimension().getHeight());
    g.scale(1.0, -1.0);
    
    // Enable anti-aliasing. Even more expense.
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                       RenderingHints.VALUE_ANTIALIAS_ON);
    
    // Flush the background. Even -more- expense!
    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, getWidth(), getHeight());
    
    for(Entity entity : getWorld().getEntities()) {
      entity.render(g);
    }
  }
  
  @Override
  public Dimension getPreferredSize() {
    return getDimension();
  }
  
  public Dimension getDimension() {
    return dimension;
  }
  
  public World getWorld() {
    return world;
  }
  
  public void mouseClicked(MouseEvent e) {
    dispatchMouseEvent(e);
  }

  public void mousePressed(MouseEvent e) {
    dispatchMouseEvent(e);
  }

  public void mouseReleased(MouseEvent e) {
    dispatchMouseEvent(e);
  }

  public void mouseEntered(MouseEvent e) {
    dispatchMouseEvent(e);
  }

  public void mouseExited(MouseEvent e) {
    dispatchMouseEvent(e);
  }
  
  public void dispatchMouseEvent(MouseEvent e) {
    // We need to mask our mouse events to honor our coordinate manipulation
    // in the rendering routines.
    e.translatePoint(Entity.xOffset+Entity.xEventOffset,
                     Entity.yOffset+Entity.yEventOffset);
    
    getWorld().mouseInput(new MaskedMouseEvent(e));
  }

  public void keyTyped(KeyEvent e) {
    getWorld().keyInput(e);
  }

  public void keyPressed(KeyEvent e) {
    getWorld().keyInput(e);
  }

  public void keyReleased(KeyEvent e) {
    getWorld().keyInput(e);
  }
}