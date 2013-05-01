package org.jasonjohnson.purpose.scene;

import org.jasonjohnson.purpose.Scene;
import org.jasonjohnson.purpose.World;
import org.jasonjohnson.purpose.model.Player;


public class Menu extends Scene {
  public Menu(World world) {
    super(world);
    
    world.addEntity(new Player());
  }
}