 package maxout.util;

import net.minecraft.client.Minecraft;

public class JumpUtil {
	{
		


	}
	
	public boolean CanJumpPG; {
		if(!this.CanJumpPG) {
			if(Minecraft.getMinecraft().gameSettings.keyBindJump.pressed) {
				Minecraft.getMinecraft().thePlayer.setPosition(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.lastTickPosY, Minecraft.getMinecraft().thePlayer.posZ);
			}
			
		}
		}
		public boolean CanJump; {
				if(Minecraft.getMinecraft().gameSettings.keyBindJump.pressed) {
					Minecraft.getMinecraft().thePlayer.motionY = -100000F;
				
			}
			


		}
	
}
