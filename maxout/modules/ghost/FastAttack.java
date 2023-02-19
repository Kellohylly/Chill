package maxout.modules.ghost;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;





public class FastAttack
  extends Module
{
  public FastAttack()
  {
    super("FastHit", 48, Module.Category.COMBAT);
  }
  
  public void onEnable() {}
  
  public void onDisable()
  {
    mc.timer.timerSpeed = 1.0F;
  }
  
  public void onEvent(Event e) {
    if (((e instanceof EventUpdate)) && 
      (e.isPre())) {
      ItemStack heldItem = mc.thePlayer.getHeldItem();
      
      if ((heldItem != null) && ((heldItem.getItem() instanceof ItemSword))) {
        mc.timer.timerSpeed = 1.07F;
      }
      else {
        mc.timer.timerSpeed = 1.0F;
      }
    }
  }
}
