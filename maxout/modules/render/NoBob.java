package maxout.modules.render;

import maxout.events.Event;
import net.minecraft.client.Minecraft;

public class NoBob extends maxout.modules.Module
{
  public boolean NoBob;
  
  public NoBob()
  {
    super("NoBob", 0, maxout.modules.Module.Category.RENDER);
  }
  
  public void onEnable()
  {
    NoBob = true;
  }
  
  public void onDisable() {
    NoBob = false;
  }
  
  public void onEvent(Event e) {
    if (((e instanceof maxout.events.listeners.EventUpdate)) && 
      (e.isPre()))
    {
      if ((this.NoBob = 1) != 0) {
        mc.thePlayer.cameraPitch = 0.0F;
        mc.thePlayer.cameraYaw = 0.0F;
      }
    }
  }
}
