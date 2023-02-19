package maxout.modules.combat;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class Velocity
  extends Module
{
  public Velocity()
  {
    super("Velocity", 37, Module.Category.COMBAT);
  }
  

  public void onEnable() {}
  

  public void onDisable() {}
  

  public void onEvent(Event e)
  {
    if (((e instanceof EventUpdate)) && 
      (e.isPre()) && 
      (mc.thePlayer.hurtTime > 1)) {
      mc.thePlayer.motionX *= 0.9D;
      mc.thePlayer.motionZ *= 0.9D;
    }
  }
}
