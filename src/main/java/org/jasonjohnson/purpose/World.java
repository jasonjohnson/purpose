package org.jasonjohnson.purpose;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.jasonjohnson.purpose.gui.MaskedMouseEvent;
import org.jasonjohnson.purpose.model.Entity;


public class World {
  private ArrayList<Entity> entities;
  
  public static World initialWorld() {
    World world = new World();
    return world;
  }
  
  public World() {
    entities = new ArrayList<Entity>();
  }
  
  public void addEntity(Entity entity) {
    entities.add(entity);
  }
  
  public ArrayList<Entity> getEntities() {
    return entities;
  }
  
  public void update(long delta) {
    if(delta <= 0) {
      return;
    }
    
    for(Entity entity : getEntities()) {
      entity.update(delta);
    }
  }

  public void mouseInput(MaskedMouseEvent e) {
    for(Entity entity : getEntities()) {
      entity.mouseInput(e);
    }
  }

  public void keyInput(KeyEvent e) {
    for(Entity entity : getEntities()) {
      entity.keyInput(e);
    }
  }
}