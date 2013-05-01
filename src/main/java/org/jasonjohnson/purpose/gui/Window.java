package org.jasonjohnson.purpose.gui;

import javax.swing.JFrame;
import org.jasonjohnson.purpose.Scene;


public class Window  {
  private JFrame frame;
  
  public Window(String title) {
    frame = new JFrame();
    frame.setTitle(title);
    frame.setResizable(false);
    frame.setIgnoreRepaint(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void loadScene(Scene scene) {
    // Throw everything out to make sure we're only running one scene.
    frame.getContentPane().removeAll();
    
    // Load our scene and attach our listeners.
    frame.getContentPane().add(scene);
    frame.addMouseListener(scene);
    frame.addKeyListener(scene);
  }
  
  public void display() {
    frame.pack();
    frame.setVisible(true);
  }
}