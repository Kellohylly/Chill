package maxout.ui;

import java.util.Collections;
import java.util.Comparator;
import maxout.Client;
import maxout.events.listeners.EventRenderGUI;
import maxout.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumChatFormatting;





public class HUD
{
  public Minecraft mc = Minecraft.getMinecraft();
  public HUD() {}
  
  public static class ModuleComparator implements Comparator<Module> {
    public ModuleComparator() {}
    
    public int compare(Module o1, Module o2) { if (getMinecraftfontRendererObj.getStringWidth(name) > getMinecraftfontRendererObj.getStringWidth(name)) {
        return -1;
      }
      if (getMinecraftfontRendererObj.getStringWidth(name) < getMinecraftfontRendererObj.getStringWidth(name)) {
        return 1;
      }
      return 0;
    }
  }
  
  public void draw()
  {
    ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    FontRenderer fr = mc.fontRendererObj;
    
    Collections.sort(Client.modules, new ModuleComparator());
    


    GlStateManager.pushMatrix();
    GlStateManager.translate(4.0F, 4.0F, 0.0F);
    GlStateManager.scale(1.2D, 1.2D, 1.0D);
    GlStateManager.translate(-4.0F, -4.0F, 0.0F);
    String Chill = "C" + EnumChatFormatting.WHITE + "hill";
    fr.drawStringWithShadow(Chill, 1.5D, 1.5D, 5636095);
    GlStateManager.popMatrix();
    




    GlStateManager.pushMatrix();
    GlStateManager.translate(4.0F, 14.0F, 0.0F);
    GlStateManager.scale(0.7D, 0.7D, 1.0D);
    GlStateManager.translate(-4.0F, -4.0F, 0.0F);
    fr.drawStringWithShadow(Client.version, 1.5D, 1.5D, -1);
    GlStateManager.popMatrix();
    


    int count = 0;
    for (Module m : Client.modules) {
      if ((toggled) && (!name.equals("TabGUI")))
      {

        double offset = count * (FONT_HEIGHT + 4);
        



        fr.drawStringWithShadow(name, sr.getScaledWidth() - fr.getStringWidth(name) - 1, 1.0D + offset, 5636095);
        
        count++;
      }
    }
    Client.onEvent(new EventRenderGUI());
  }
}
