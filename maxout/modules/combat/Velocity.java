package maxout.modules.combat;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;

public class Velocity extends Module {
	
	public Velocity(){
		super("Velocity", Keyboard.KEY_K, Category.COMBAT);}
		
		public void onEnable(){
			
		}
	
	public void onDisable(){
		
           
	}

	public void onEvent(Event e){
		if(e instanceof EventUpdate) {
			if(e.isPre()){
				if(mc.thePlayer.hurtTime > 1) {
					mc.thePlayer.motionX *= 0.9;
					mc.thePlayer.motionZ *= 0.9;
			}
		}
	}
	
}
	
}
