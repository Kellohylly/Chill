package maxout.modules.ghost;

import javax.swing.event.MouseInputAdapter;
import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.java.games.input.Mouse;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.util.MovementInput;

public class FastAttack extends Module {
	
	public FastAttack(){
		super("FastHit", Keyboard.KEY_B, Category.COMBAT);}
		
		public void onEnable(){
			
		}
	
	public void onDisable(){
           mc.timer.timerSpeed = 1F;
	}
	
	public void onEvent(Event e){
		if(e instanceof EventUpdate) {
			if(e.isPre()){
				ItemStack heldItem = mc.thePlayer.getHeldItem();

				if (heldItem != null && heldItem.getItem() instanceof ItemSword) {
					mc.timer.timerSpeed = 1.07F;

				} else {
					mc.timer.timerSpeed = 1F;
				}
				
		}
	}
	
}
	
}
