package maxout.ui;

import maxout.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen
{
  public MainMenu() {}
  
  public void initGui() {}
  
  public void drawScreen(int mouseX, int mouseY, float partialTicks)
  {
    mc.getTextureManager().bindTexture(new ResourceLocation("Maxout/maxout.jpg"));
    drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, width, height, width, height);
    
    drawGradientRect(0, height - 100, width, height, 0, -16777216);
    
    String[] buttons = { "Singleplayer", "Multiplayer", "Settings", "Language", "Quit" };
    
    int count = 0;
    for (String name : buttons) {
      float x = width / buttons.length * count + width / buttons.length / 2.0F + 8.0F - mc.fontRendererObj.getStringWidth(name) / 2.0F;
      float y = height - 20;
      
      boolean hovered = (mouseX >= x) && (mouseY >= y) && (mouseX < x + mc.fontRendererObj.getStringWidth(name)) && (mouseY < y + mc.fontRendererObj.FONT_HEIGHT);
      

      drawCenteredString(mc.fontRendererObj, name, width / buttons.length * count + width / buttons.length / 2.0F + 8.0F, height - 20, hovered ? -16740097 : 5636095);
      count++;
    }
    
    GlStateManager.pushMatrix();
    GlStateManager.translate(width / 2.0F, height / 2.0F, 0.0F);
    GlStateManager.scale(2.5D, 2.5D, 1.0D);
    GlStateManager.translate(-(width / 2.0F), -(height / 2.0F), 0.0F);
    drawCenteredString(mc.fontRendererObj, Client.name + " v" + Client.version, width / 2.0F, height / 2.0F - mc.fontRendererObj.FONT_HEIGHT / 2.0F, 5636095);
    GlStateManager.popMatrix();
    
    GlStateManager.pushMatrix();
    GlStateManager.translate(width / 2.0F, height / 2.0F, 0.0F);
    GlStateManager.scale(1.5D, 1.5D, 1.0D);
    GlStateManager.translate(-(width / 2.0F), -(height / 2.0F), 0.0F);
    drawCenteredString(mc.fontRendererObj, Client.patchNotes, 125.0F, 43.0F, 5636095);
    GlStateManager.popMatrix();
  }
  
  public void mouseClicked(int mouseX, int mouseY, int button)
  {
    String[] buttons = { "Singleplayer", "Multiplayer", "Settings", "Language", "Quit" };
    
    int count = 0;
    label393: for (String name : buttons) {
      float x = width / buttons.length * count + width / buttons.length / 2.0F + 8.0F - mc.fontRendererObj.getStringWidth(name) / 2.0F;
      float y = height - 20;
      
      if ((mouseX >= x) && (mouseY >= y) && (mouseX < x + mc.fontRendererObj.getStringWidth(name)) && (mouseY < y + mc.fontRendererObj.FONT_HEIGHT)) { String str1;
        switch ((str1 = name).hashCode()) {case -2064742086:  if (str1.equals("Multiplayer")) {} break; case -1548945544:  if (str1.equals("Language")) {} break; case -1500504759:  if (str1.equals("Singleplayer")) break; break; case 2528879:  if (str1.equals("Quit")) {} break; case 1499275331:  if (!str1.equals("Settings")) {
            break label393;
            mc.displayGuiScreen(new GuiSelectWorld(this));
            
            break label393;
            
            mc.displayGuiScreen(new GuiMultiplayer(this));
          }
          else {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
            
            break label393;
            mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings, mc.getLanguageManager()));
            
            break label393;
            mc.shutdown();
          }
          break;
        }
      }
      count++;
    }
  }
  
  public void onGuiClosed() {}
}
