package maxout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import maxout.events.Event;
import maxout.events.listeners.EventKey;
import maxout.modules.Module;
import maxout.modules.Module.Category;
import maxout.modules.combat.*;
import maxout.modules.ghost.*;
import maxout.modules.movement.*;
import maxout.modules.render.*;
import maxout.ui.HUD;
import net.minecraft.client.Minecraft;



public class Client {

	public static String name = "Chill", version = "1.01", messageHud = "test", messageLoad = "Thanks for Beta testing" + "!, This is Chill client v" + version + ".", patchNotes = "", discord = "https://discord.gg/sYmG4xqJ";				
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	public static HUD hud = new HUD();
	public static void startup() {
		System.out.println("Starting " + name +  " - v" + version);
		Display.setTitle(messageLoad);
	
		
		modules.add(new Sprint());
        //modules.add(new Speed());
		modules.add(new FullBright());
		//modules.add(new NoFall());
		//modules.add(new Jesus());
		//modules.add(new Glide());
		//modules.add(new Step());   
		//modules.add(new SpeedNCP());
		//modules.add(new Timer());
		//modules.add(new MatrixGlide());
		//modules.add(new FastUse());
		modules.add(new TabGUI());
		//modules.add(new LowHop());
		//modules.add(new Damage());
	//	modules.add(new Disabler());
	//	modules.add(new BetterFly());
		modules.add(new NoBob());
		//modules.add(new NoSwing());
		//modules.add(new Criticals());
		//modules.add(new TimerHop());
		modules.add(new Velocity());
		//modules.add(new GhostVelocity());
		//modules.add(new MoreVelocity());
		//modules.add(new FastFly());
	//	modules.add(new NoSlow());
		//modules.add(new VanillaFly());
	//	modules.add(new TimerFly());
		//	modules.add(new TPLongJump());
		//modules.add(new OnGroundSpeed());
		//modules.add(new SuperKB());
		//modules.add(new YesBob());
		modules.add(new Animations());
		//modules.add(new NoGround());
		//modules.add(new GoodSpeed());
		//modules.add(new Eagle());
		//modules.add(new PacketFly());
		//modules.add(new NoFallFakeGround());
		//modules.add(new DevTest());
		//modules.add(new Sneak());
		//modules.add(new MatrixSpeed());
		//modules.add(new PacketSpeed());
		//modules.add(new Phase());
		modules.add(new Killaura());
		//modules.add(new GodMode());
		//modules.add(new AimBot());
		//modules.add(new Ascend());
		//modules.add(new LongJump());
		//modules.add(new BMCSpeed());
	//	modules.add(new YesHunger());
	//	modules.add(new Teleport());
	//	modules.add(new Spammer());
		modules.add(new FastAttack());
		modules.add(new AutoClicker());
		modules.add(new AimAssist());
		modules.add(new RightClicker());
		modules.add(new Fly());
	}
	
	
	
	public static void onEvent(Event e) {
		for(Module m : modules){
			if(!m.toggled)
				continue;
			
			
			m.onEvent(e);
		}
		
	}
	
		public static void onRender(Event e) {
			for(Module m : modules){
				m.onRender();
			}
	}
	
	public static void keyPress(int key) {
		Client.onEvent(new EventKey(key));
		
		for(Module m : modules){
			if(m.getKey() == key){
				m.toggle();
			}
		}
	}
	
	public static List<Module> getModulesByCateogory(Category c){
		List<Module> modules = new ArrayList<Module>();
		
		for (Module m : Client.modules) {
			if(m.category == c)
			modules.add(m);
		}
		
		return modules;
 
		}
	

	
}
