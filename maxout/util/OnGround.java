package maxout.util;

import net.minecraft.client.Minecraft;

public class OnGround {
	
	
	public boolean onGround(boolean onGround) {
		if(Minecraft.getMinecraft().thePlayer.onGround && Minecraft.getMinecraft().thePlayer.fallDistance < 0.1F) {
			return true;
		} else {
			return false;
			
		}

	}

	
}