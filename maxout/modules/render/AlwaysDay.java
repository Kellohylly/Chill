package maxout.modules.render;

import maxout.events.Event;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;

public class AlwaysDay extends Module
{
  private boolean alwaysday = false;
  
  public AlwaysDay() { super("AlwaysDay", 11, Module.Category.RENDER); }
  
  public void onEnable()
  {
    alwaysday = true;
  }
  
  public void onDisable() {
    alwaysday = false;
  }
  
  public void onEvent(Event e) {
    if ((e instanceof maxout.events.listeners.EventUpdate)) {
      e.isPre();
    }
    

    if (alwaysday) {
      mc.theWorld.setWorldTime(1000L);
    }
  }
}
