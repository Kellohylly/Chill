package maxout.modules.movement;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class Sprint
  extends Module
{
  public Sprint()
  {
    super("Sprint", 49, Module.Category.MOVEMENT);
  }
  




  public void onEnable() {}
  



  public void onDisable() {}
  



  public void onEvent(Event e)
  {
    if (((e instanceof EventUpdate)) && 
      (e.isPre()) && 
      ((mc.gameSettings.keyBindSprint.pressed = 0) != 0)) {
      mc.gameSettings.keyBindSprint.pressed = true;
    }
  }
}
