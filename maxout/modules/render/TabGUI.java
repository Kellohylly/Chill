package maxout.modules.render;

import java.util.Iterator;
import java.util.List;
import maxout.Client;
import maxout.events.Event;
import maxout.events.listeners.EventKey;
import maxout.events.listeners.EventRenderGUI;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;



public class TabGUI
  extends Module
{
  public int currentTab;
  public int moduleIndex;
  public boolean expanded = false;
  
  public TabGUI() {
    super("TabGUI", 54, Module.Category.RENDER);
  }
  

  public void onEvent(Event e)
  {
    if ((e instanceof EventRenderGUI)) {
      FontRenderer fr = mc.fontRendererObj;
      

      Gui.drawRect(5.0D, 25.0D, 70.0D, 30 + Module.Category.values().length * 16 + 14, -1879048192);
      Gui.drawRect(7.0D, 33 + currentTab * 16, 68.0D, 33 + currentTab * 16 + 12, -1879048192);
      
      int count = 0;
      for (Module.Category c : Module.Category.values()) {
        fr.drawStringWithShadow(c.name(), 11.0D, 36 + count * 16, 5636095);
        
        count++;
      }
      
      if (expanded) {
        Module.Category category = Module.Category.values()[currentTab];
        Object modules = Client.getModulesByCateogory(category);
        
        if (((List)modules).size() == 0) {
          return;
        }
        


        Gui.drawRect(70.0D, 30.5D, 140.0D, 30 + ((List)modules).size() * 16 + 15, 0);
        Gui.drawRect(72.0D, 33 + moduleIndex * 16, 138.0D, 33 + moduleIndex * 16 + 12, -1879048192);
        
        count = 0;
        for (??? = ((List)modules).iterator(); ((Iterator)???).hasNext();) { Module m = (Module)((Iterator)???).next();
          fr.drawStringWithShadow(name, 81.0D, 36 + count * 16, 5636095);
          
          count++;
        }
      }
    }
    


    if ((e instanceof EventKey)) {
      int code = code;
      
      List<Module> modules = Client.getModulesByCateogory(Module.Category.values()[currentTab]);
      
      if (code == 200) {
        if (expanded) {
          if (moduleIndex <= 0) {
            moduleIndex = (Module.Category.values().length - 1);
          } else {
            moduleIndex -= 1;
          }
        } else if (currentTab <= 0) {
          currentTab = modules.size();
        } else {
          currentTab -= 1;
        }
      }
      if (code == 208) {
        if (expanded) {
          if (moduleIndex >= modules.size()) {
            moduleIndex = 0;
          } else {
            moduleIndex += 1;
          }
        }
        else if (currentTab >= Module.Category.values().length - 1) {
          currentTab = 0;
        } else {
          currentTab += 1;
        }
      }
      
      if (code == 205) {
        if (expanded) {
          Module module = (Module)modules.get(moduleIndex);
          if ((moduleIndex >= 0) && (!name.equals("TabGUI"))) {
            expanded = true;
            module.toggle();
          }
        }
        else
        {
          expanded = true;
        }
      }
      


      if (code == 203)
      {
        expanded = false;
      }
    }
  }
}
