package maxout.modules.render;

import maxout.events.Event;
import maxout.events.listeners.EventRenderGUI;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;











public class Animations
  extends Module
{
  public Animations()
  {
    super("Animations", 0, Module.Category.RENDER);
  }
  
  public void onEvent(Event e) {
    if ((e instanceof EventRenderGUI)) {
      if (mc.thePlayer.isCollidedHorizontally) {
        mc.thePlayer.cameraYaw = 1.5F;
        mc.thePlayer.cameraPitch = 0.0F;
        mc.thePlayer.performHurtAnimation();
      }
      if (mc.thePlayer.isBlocking())
      {


        mc.thePlayer.renderArmPitch = -120.0F;
        mc.thePlayer.renderArmYaw = -500.0F;
      }
    }
  }
}
