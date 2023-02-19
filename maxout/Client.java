package maxout;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import maxout.events.Event;
import maxout.events.listeners.EventKey;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import maxout.modules.combat.Killaura;
import maxout.modules.ghost.FastAttack;
import maxout.modules.movement.Sprint;
import maxout.modules.render.Animations;
import maxout.modules.render.FullBright;
import maxout.modules.render.NoBob;
import maxout.modules.render.TabGUI;
import maxout.ui.HUD;

public class Client
{
  public Client() {}
  
  public static String name = "Chill"; public static String version = "1.01"; public static String messageHud = "test"; public static String messageLoad = "Thanks for Beta testing!, This is Chill client v" + version + "."; public static String patchNotes = ""; public static String discord = "https://discord.gg/sYmG4xqJ";
  public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList();
  public static HUD hud = new HUD();
  
  public static void startup() { System.out.println("Starting " + name + " - v" + version);
    org.lwjgl.opengl.Display.setTitle(messageLoad);
    

    modules.add(new Sprint());
    
    modules.add(new FullBright());
    



    modules.add(new maxout.modules.render.AlwaysDay());
    



    modules.add(new TabGUI());
    



    modules.add(new NoBob());
    


    modules.add(new maxout.modules.combat.Velocity());
    









    modules.add(new Animations());
    









    modules.add(new Killaura());
    







    modules.add(new FastAttack());
    modules.add(new maxout.modules.combat.AutoClicker());
    modules.add(new maxout.modules.combat.AimAssist());
    modules.add(new maxout.modules.combat.RightClicker());
  }
  

  public static void onEvent(Event e)
  {
    for (Module m : modules) {
      if (toggled)
      {


        m.onEvent(e);
      }
    }
  }
  
  public static void onRender(Event e) {
    for (Module m : modules) {
      m.onRender();
    }
  }
  
  public static void keyPress(int key) {
    onEvent(new EventKey(key));
    
    for (Module m : modules) {
      if (m.getKey() == key) {
        m.toggle();
      }
    }
  }
  
  public static List<Module> getModulesByCateogory(Module.Category c) {
    List<Module> modules = new ArrayList();
    
    for (Module m : modules) {
      if (category == c) {
        modules.add(m);
      }
    }
    return modules;
  }
}
