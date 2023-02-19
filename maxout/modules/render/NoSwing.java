package maxout.modules.render;

import maxout.events.Event;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;



public class NoSwing
  extends Module
{
  public NoSwing()
  {
    super("NoSwing", 0, Module.Category.RENDER);
  }
  
  public void onEvent(Event e) {
    mc.thePlayer.swingProgress = 1.0F;
  }
}
