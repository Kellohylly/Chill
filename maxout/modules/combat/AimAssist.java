package maxout.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import maxout.Client;
import maxout.events.Event;
import maxout.events.listeners.EventMotion;
import maxout.modules.Module;
import maxout.util.Timer;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C02PacketUseEntity.Action;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;

public class AimAssist extends Module {
	
	public Timer timer = new Timer();
	
	public int state;
	
	public AimAssist(){
		super("AimAssist", Keyboard.KEY_F, Category.COMBAT);
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
						
						targets = targets.stream().filter(entity -> entity.getDistanceToEntity(mc.thePlayer) < 5 && entity != mc.thePlayer && !entity.isDead && entity.getHealth() > 0  && !entity.isInvisible() && !entity.getName().contains("[NPC]") && !entity.getName().contains("§" ) && !(entity.getName().length() > 16) && !(entity.getName().length() < 3)).collect(Collectors.toList());
						
						targets.sort(Comparator.comparingDouble(entity -> ((EntityLivingBase)entity).getDistanceToEntity(mc.thePlayer)));
						
						
						if(!targets.isEmpty()) {
							EntityLivingBase target = targets.get(0);
							// i should check all of the but im 2 lazy 2 do it + theres like 15 and those are most common
							// -note to self: add an ac (autoclicker) check
							if (!(mc.currentScreen instanceof GuiChest) || !(mc.currentScreen instanceof GuiInventory)) {
										mc.thePlayer.rotationYaw = (getRotations(target)[0]);
										mc.thePlayer.rotationPitch = (getRotations(target)[1]);
										
									
								}
								}
							   
							}
						
							
								
							
						}

						if(this.rotationSpeed < 1.25) {
							this.rotationSpeed *= 1.5F;
						}
						if(this.cameraShakeSpeed < 2.787) {
							this.cameraShakeSpeed *= 1.8F;
						}
						
						
						
						this.state +=1;
						switch(this.state) {
						case 1:
							this.rotationSpeed = (float) 1.1 * multiplier + 0.363F;
							this.cameraShakeSpeed =  + 0.025F;
						case 2:
							this.rotationSpeed = (float) 1.1 * multiplier + 0.3167F;
							this.cameraShakeSpeed =  - 0.03F;
							
						case 3:
							this.rotationSpeed = (float) 1.1 * multiplier + 0.32415F;
							this.cameraShakeSpeed =  + 0.020F;
						case 4:
							this.cameraShakeSpeed = - 0.015F;
							
							this.state = 0;
							break;
						default:
							break;
						
						
					}
						
						
				}
					
		
				
					
					
		
			
					
			
					

				

			public float cameraShakeSpeed;
			public float multiplier = 2.9F;
			public float rotationSpeed;
			
		
			
			public float[] getRotations(Entity e) {
			    double deltaX = e.posX - (e.posX - e.lastTickPosX) - mc.thePlayer.posX;
			    double deltaY = e.posY - 3.5 + e.getEyeHeight() - mc.thePlayer.posY + mc.thePlayer.getEyeHeight();
			    double deltaZ = e.posZ + (e.posZ - e.lastTickPosZ) - mc.thePlayer.posZ;
			    double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2));
			    
			    float yaw = (float) Math.toDegrees(-Math.atan2(deltaX, deltaZ));
			    float pitch = (float) -Math.toDegrees(Math.atan2(deltaY, Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaZ, 2))));
			    
			    // calculate the delta yaw and pitch based on the rotation speed
			    float deltaYaw = yaw - mc.thePlayer.rotationYaw;
			    float deltaPitch = pitch - mc.thePlayer.rotationPitch;
			    deltaYaw = MathHelper.wrapAngleTo180_float(deltaYaw);
			    deltaPitch = MathHelper.wrapAngleTo180_float(deltaPitch);
			    
			    // adjust the delta yaw and pitch based on the rotation speed
			    float adjustedRotationSpeed = rotationSpeed;
			    deltaYaw = Math.min(adjustedRotationSpeed, Math.max(-adjustedRotationSpeed, deltaYaw));
			    deltaPitch = Math.min(adjustedRotationSpeed, Math.max(-adjustedRotationSpeed, deltaPitch));
			    
			    // apply the new rotations
			    yaw = mc.thePlayer.rotationYaw + deltaYaw + this.cameraShakeSpeed;
			    pitch = mc.thePlayer.rotationPitch + deltaPitch + this.cameraShakeSpeed;
			    
			    return new float[] { yaw, pitch };
			}
			
}