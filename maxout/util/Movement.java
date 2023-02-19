package maxout.util;

import net.minecraft.client.Minecraft;

public class Movement {
		
		
		
		public float speed(float speed) {
			Minecraft.getMinecraft().thePlayer.motionX *= speed;
			Minecraft.getMinecraft().thePlayer.motionZ *= speed;
			return speed;
			
		}
	
		public class boost {
			
			
			public boolean boost(float boostx, float boosty, float boostz, boolean status) {
				Minecraft.getMinecraft().thePlayer.motionX = boostx;
				Minecraft.getMinecraft().thePlayer.motionY = boosty;
				Minecraft.getMinecraft().thePlayer.motionZ = boostz;
				return true;
				
	
			}
		
			
		}

	}
