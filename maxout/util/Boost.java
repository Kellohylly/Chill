package maxout.util;

import net.minecraft.client.Minecraft;

public class Boost {
	
	
	public boolean boost(float boostx, float boosty, float boostz, boolean status) {
		Minecraft.getMinecraft().thePlayer.motionX *= boostx;
		Minecraft.getMinecraft().thePlayer.motionY *= boosty;
		Minecraft.getMinecraft().thePlayer.motionZ *= boostz;
		return true;
		

	}

	
}

