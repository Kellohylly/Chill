package maxout.modules.render;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;

public class NoBob extends Module {
	public boolean NoBob;
	public NoBob(){
		super("NoBob", Keyboard.KEY_NONE, Category.RENDER);

	}
	
	public void onEnable(){
		this.NoBob = true;
	}
	
	public void onDisable(){	
		this.NoBob = false;
	}

	public void onEvent(Event e){
		if(e instanceof EventUpdate) {
			if(e.isPre()){
				
				if(this.NoBob = true) {
				mc.thePlayer.cameraPitch = 0F;
				mc.thePlayer.cameraYaw = 0F; 
				}
			}
			
		}
		
	}
		
	}
	
