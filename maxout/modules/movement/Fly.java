package maxout.modules.movement;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class Fly extends Module {
	
	public Fly(){
		super("Fly", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
			mc.thePlayer.performHurtAnimation();
	            
	        }
		
		
	
	
	public void onDisable(){
							 
							 
							}
							
						
		
			public void onEvent(Event e){
				if(e instanceof EventUpdate) {
					if(e.isPre()){
						mc.thePlayer.onGround = true;
						mc.thePlayer.motionY = 0F;
						
						
				
			}
			
		}
		
	}
	
}
	

		
				
		    
			
		
	
	

