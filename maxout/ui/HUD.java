package maxout.ui;

import java.util.Collections;
import java.util.Comparator;

import maxout.Client;
import maxout.events.listeners.EventRenderGUI;
import maxout.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumChatFormatting;


public class HUD {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {

		@Override
		public int compare(Module o1, Module o2) {
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(o1.name) > Minecraft.getMinecraft().fontRendererObj.getStringWidth(o2.name)) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRendererObj.getStringWidth(o1.name) < Minecraft.getMinecraft().fontRendererObj.getStringWidth(o2.name)) {
				return 1;
			}
			return 0;
		}
		
	}
	
	public void draw(){
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		FontRenderer fr = mc.fontRendererObj;
		
		Collections.sort(Client.modules, new ModuleComparator());
		
	//	Client.modules.sort.(Comparator.comparingInt(m -> mc.fontRendererObj.getStringWidth(((Module)m).name))); 
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 4, 0);
		GlStateManager.scale(1.2, 1.2, 1);
		GlStateManager.translate(-4, -4, 0);
		String Chill = "C" + EnumChatFormatting.WHITE + "hill";
		fr.drawStringWithShadow(Chill, 1.5, 1.5, 0xFF00FF00);
		GlStateManager.popMatrix(); 
	// 5636095	
	//	String Chill = "C" + EnumChatFormatting.WHITE + "hill";
	//	fr.drawStringWithShadow(Chill, 1.5, 1.5, 0);
		
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(4, 14, 0);
		GlStateManager.scale(0.7, 0.7, 1);
		GlStateManager.translate(-4, -4, 0);
		fr.drawStringWithShadow( Client.version, 1.5, 1.5, 0xFF00FF00);
		GlStateManager.popMatrix(); 
		

		
		
		
		
			
		int count = 0;
		for(Module m : Client.modules){
			if(!m.toggled || m.name.equals("TabGUI"))
				continue;
			
			
			double offset = count*(fr.FONT_HEIGHT + 4);
			
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 10, offset, sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, 4 + fr.FONT_HEIGHT + offset, 0xFF00FF00);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, offset, sr.getScaledWidth(), 4 + fr.FONT_HEIGHT + offset, 0);
			Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m.name) - 8, offset, sr.getScaledWidth(), 10 + fr.FONT_HEIGHT + offset, 0);
			fr.drawStringWithShadow(m.name, sr.getScaledWidth() - fr.getStringWidth(m.name) - 1, 1 + offset, 0xFF00FF00);
			
			count++;
		}
		
		Client.onEvent(new EventRenderGUI());
	}

}