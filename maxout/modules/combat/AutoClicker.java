package maxout.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import io.netty.util.internal.ThreadLocalRandom;
import maxout.events.Event;
import maxout.events.listeners.EventMotion;
import maxout.modules.Module;
import maxout.util.Timer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;

public class AutoClicker extends Module {
	
	public Timer timer = new Timer();
	
	public AutoClicker(){
		super("AutoClicker", Keyboard.KEY_V, Category.COMBAT);
	}
	
	public void onEnable() {
		autoclicking = true;
		
		this.updateVals();
	        }
		
		
	
	
	public void onDisable(){
		autoclicking = false;
							 
							}
	private long lastClick;
	private long hold;
	
	private double speed;
	private double holdLength;
	private double min = 12;
	private double max = 17;
	private boolean click;
	
						
		
			public void onEvent(Event e){
				if(e instanceof EventMotion) {
					if(e.isPre()) {
						if (Mouse.isButtonDown(0)) {
							if (System.currentTimeMillis() - lastClick > speed * 1000) {
								lastClick = System.currentTimeMillis();
								if (hold < lastClick) {
									hold = lastClick;
								}
								int key = mc.gameSettings.keyBindAttack.getKeyCode();
								KeyBinding.setKeyBindState(key, true);
								KeyBinding.onTick(key);
								this.updateVals();
							} else if (System.currentTimeMillis() - hold > holdLength * 1000) {
								KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
								this.updateVals();
							}
						}
					}
				}
			
			}		
						
			

			private void updateVals() {
				if (min >= max) {
					max = min + 1;
				}
				
				speed = 1.0 / ThreadLocalRandom.current().nextDouble(min - 0.2, max);
				holdLength = speed / ThreadLocalRandom.current().nextDouble(min, max);
			
	}
	
}
	

		
				
		    
			
		
	
	

