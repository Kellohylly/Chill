package maxout.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventMotion;
import maxout.modules.Module;
import maxout.settings.BooleanSetting;
import maxout.settings.ModeSetting;
import maxout.settings.NumberSetting;
import maxout.util.Timer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.network.play.client.C0APacketAnimation;

public class Killaura extends Module {
	
	public Timer timer = new Timer();
	public NumberSetting range = new NumberSetting("Range", 4, 1, 6, 0.1);
	public NumberSetting aps = new NumberSetting("APS", 10, 1, 20, 1);
	public BooleanSetting noSwing = new BooleanSetting("No Swing", false);
	public ModeSetting test = new ModeSetting("test", "One", "One", "Two", "Three");
	
	public Killaura(){
		super("Killaura", Keyboard.KEY_R, Category.COMBAT);
		this.addSetting(range, noSwing, test, aps);
	}
	
	public void onEnable() {
	            
	        }
		
		
	
	
	public void onDisable(){
							 
							 
							}
							
						
		
			public void onEvent(Event e){
				if(e instanceof EventMotion) {
					if(e.isPre()) {
						
						EventMotion event = (EventMotion)e;
						
						List<EntityLivingBase> targets = (List<EntityLivingBase>) mc.theWorld.loadedEntityList.stream().filter(EntityLivingBase.class::isInstance).collect(Collectors.toList());
						
						targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < range.getValue() && entity != mc.thePlayer  && !entity.isInvisible()).collect(Collectors.toList());
						
						targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
						
	//			targets = targets.stream().filter(EntityPlayer.class::isInstance).collect(Collectors.toList());
						
						
						if(!targets.isEmpty()) {
							EntityLivingBase target = targets.get(0);

							event.setYaw(getRotations(target)[0]);
							event.setPitch(getRotations(target)[1]);
							mc.thePlayer.renderYawOffset = ((EventMotion) e).getYaw();
							mc.thePlayer.rotationYawHead = ((EventMotion) e).getYaw();
							
							if(timer.hasTimeElapsed((long) (1000 / aps.getValue()), true)) {
								if(mc.gameSettings.keyBindSprint.pressed = false && mc.thePlayer.isSprinting()) {
									mc.thePlayer.setSprinting(false);
								} else {
									mc.gameSettings.keyBindSprint.pressed = false;
								}
								if(noSwing.isEnabled()) {
									mc.thePlayer.sendQueue.addToSendQueue(new C0APacketAnimation());
								} else {
									
								}
								mc.thePlayer.swingItem();
								mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(target, Action.ATTACK));
								
							}
						}
					}
			}
	}
			
			public float[] getRotations(Entity e) {
				double deltaX = e.posX - (e.posX - e.lastTickPosX) - mc.thePlayer.posX,
						deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight(),
						deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ,
						distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2));
				
				float yaw = (float) Math.toDegrees(-Math.atan(deltaX / deltaZ)),
						pitch = (float) -Math.toDegrees(Math.atan(deltaY / distance));
				
				if(deltaX < 0 && deltaZ < 0) {
					yaw = (float) (90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
				}else if(deltaX > 0 && deltaZ < 0) {
					yaw = (float) (-90 + Math.toDegrees(Math.atan(deltaZ / deltaX)));
				}
				
				return new float[] {yaw, pitch };
				
			}
	
}
	

		
				
		    
			
		
	
	

