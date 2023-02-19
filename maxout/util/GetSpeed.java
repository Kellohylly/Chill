package maxout.util;

import net.minecraft.client.Minecraft;

public class GetSpeed {
	
	
		public double getSpeed() {
			return Minecraft.getMinecraft().thePlayer.motionX + Minecraft.getMinecraft().thePlayer.motionZ + Minecraft.getMinecraft().thePlayer.motionY / 3;
		}
					
			
	
	
	
}

