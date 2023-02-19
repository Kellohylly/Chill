package maxout.modules.movement;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class Sprint extends Module {
	
	public Sprint(){
		super("Sprint", Keyboard.KEY_N, Category.MOVEMENT);
	}
	
	public void onEnable() {
			
	            
	        }
		
		
	
	
	public void onDisable(){
							 
							 
							}
							
						
		
			public void onEvent(Event e){
				if(e instanceof EventUpdate) {
					if(e.isPre()){
						mc.gameSettings.keyBindSprint.pressed = true;
						
						 
							
					
					
				
				
			}
			
		}
		
	}
	
}
	

		
				
		    
			
		
	
	

