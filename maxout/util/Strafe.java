package maxout.util;

import net.minecraft.client.Minecraft;

public class Strafe {
					
		JumpUtil jumpUtil = new JumpUtil();
					
					
public void strafe(boolean strafe) {
			Minecraft.getMinecraft().thePlayer.onGround = true;
			jumpUtil.CanJump = false;
		
		
			
		}

	}
