package maxout.modules.combat;

import io.netty.util.internal.ThreadLocalRandom;
import maxout.events.Event;
import maxout.events.listeners.EventMotion;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import maxout.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Mouse;







public class AutoClicker
  extends Module
{
  public Timer timer = new Timer();
  private long lastClick;
  
  public AutoClicker() { super("AutoClicker", 47, Module.Category.COMBAT); }
  
  public void onEnable()
  {
    autoclicking = true;
    
    updateVals();
  }
  

  private long hold;
  public void onDisable()
  {
    autoclicking = false;
  }
  

  private double speed;
  
  private double holdLength;
  
  private double min = 12.0D;
  private double max = 17.0D;
  
  private boolean click;
  
  public void onEvent(Event e)
  {
    if (((e instanceof EventMotion)) && 
      (e.isPre()) && 
      (Mouse.isButtonDown(0))) {
      if (System.currentTimeMillis() - lastClick > speed * 1000.0D) {
        lastClick = System.currentTimeMillis();
        if (hold < lastClick) {
          hold = lastClick;
        }
        int key = mc.gameSettings.keyBindAttack.getKeyCode();
        KeyBinding.setKeyBindState(key, true);
        KeyBinding.onTick(key);
        updateVals();
      } else if (System.currentTimeMillis() - hold > holdLength * 1000.0D) {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
        updateVals();
      }
    }
  }
  




  private void updateVals()
  {
    if (min >= max) {
      max = (min + 1.0D);
    }
    
    speed = (1.0D / ThreadLocalRandom.current().nextDouble(min - 0.2D, max));
    holdLength = (speed / ThreadLocalRandom.current().nextDouble(min, max));
  }
}
