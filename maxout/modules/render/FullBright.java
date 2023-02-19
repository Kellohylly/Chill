package maxout.modules.render;

import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;

public class FullBright
  extends Module
{
  private boolean Gamma1;
  private boolean Gamma0;
  
  public FullBright()
  {
    super("FullBright", 24, Module.Category.RENDER);
  }
  
  public void onEnable() {
    mc.gameSettings.gammaSetting = 100.0F;
  }
  
  public void onDisable() {
    mc.gameSettings.gammaSetting = 1.0F;
  }
}
