package maxout.modules.misc;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;

public class AutoTool extends Module {
	private boolean AutoTool = false;
	public AutoTool(){
		super("AutoTool", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEnable(){
		this.AutoTool = true;
	}
	
	public void onDisable(){	
		this.AutoTool = false;
	}

	public void onEvent(Event e){
		if(e instanceof EventUpdate) {
			if(e.isPre()){
				
			}
		}
	}
}
	
