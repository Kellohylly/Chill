package maxout.util;

import net.minecraft.client.Minecraft;

public class Jump {
					
					
public void jump(boolean jump) {
		if(Minecraft.getMinecraft().thePlayer.onGround && Minecraft.getMinecraft().thePlayer.fallDistance < 0.001) {
			Minecraft.getMinecraft().thePlayer.jump();
				
			}
		
			
		}

	}
