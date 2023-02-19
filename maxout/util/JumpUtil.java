package maxout.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class JumpUtil
{
  public boolean CanJumpPG;
  public boolean CanJump;
  
  public JumpUtil()
  {
    if ((!CanJumpPG) && 
      (getMinecraftgameSettings.keyBindJump.pressed)) {
      getMinecraftthePlayer.setPosition(getMinecraftthePlayer.posX, getMinecraftthePlayer.lastTickPosY, getMinecraftthePlayer.posZ);
    }
    



    if (getMinecraftgameSettings.keyBindJump.pressed) {
      getMinecraftthePlayer.motionY = -100000.0D;
    }
  }
}
