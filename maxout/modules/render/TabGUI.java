package maxout.modules.render;

import java.util.List;

import org.lwjgl.input.Keyboard;

import maxout.Client;
import maxout.events.Event;
import maxout.events.listeners.EventKey;
import maxout.events.listeners.EventRenderGUI;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import maxout.settings.Setting;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import tv.twitch.chat.Chat;

public class TabGUI extends Module {


	public int currentTab, moduleIndex;
	public boolean expanded = false;

	public TabGUI(){
		super("TabGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
		
		
	}

	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = mc.fontRendererObj;
						
			
			Gui.drawRect(5, 25, 70, 30 + Module.Category.values().length * 16 + 14, 0x90000000);
			Gui.drawRect(7, 33 + currentTab * 16, 8 + 60, 33 + currentTab * 16 + 12, 0x90000000);

			int count = 0;
			for(Category c : Module.Category.values()) {
				fr.drawStringWithShadow(c.name(), 11, 36 + count*16, 0xFF00FF00);

				count++;
			}

			if(expanded) {
				Category category = Module.Category.values()[currentTab];
				List<Module> modules = Client.getModulesByCateogory(category);

				if(modules.size() == 0) {
					return;
					
				}
				

				Gui.drawRect(70, 30.5, 70 + 70, 30 + modules.size() * 16 + 15, 0);
				Gui.drawRect(72, 33 + moduleIndex * 16, 8 + 60 + 70, 33 + moduleIndex * 16 + 12, 0x90000000 );
				
				count = 0;
				for(Module m : modules) {
					fr.drawStringWithShadow(m.name, 11 + 70, 36 + count*16, 0xFF00FF00);
				
					count++;
				}
			}
			
		}


		if(e instanceof EventKey) {
			int code = ((EventKey)e).code;

			List<Module> modules = Client.getModulesByCateogory(Module.Category.values()[currentTab]);

			if(code == Keyboard.KEY_UP) {
				if(expanded) {
					if(moduleIndex <= 0) {
						moduleIndex = Module.Category.values().length - 1;
					}else
						moduleIndex--;
				}else
					if(currentTab <= 0) {
						currentTab = modules.size();
					}else
						currentTab--;

			}
			if(code == Keyboard.KEY_DOWN) {
				if(expanded) {
					if(moduleIndex >= modules.size()) {
						moduleIndex = 0;
					}else
						moduleIndex++;

				}else
					if(currentTab >= Module.Category.values().length - 1) {
						currentTab = 0;
					}else
						currentTab++;

			}
			
			if(code == Keyboard.KEY_RIGHT) {
				if(expanded) {
					Module module = modules.get(moduleIndex);
					if(moduleIndex >= 0 && !module.name.equals("TabGUI")) {
						expanded = true;
						module.toggle();
					}
						
					
				}	else { 
					expanded = true;

			}
			
		
					}
			if(code == Keyboard.KEY_LEFT) {
				
					expanded = false;
					
				}

			}
			

			
		}

	}

	


