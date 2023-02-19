package maxout.util;

import net.minecraft.client.Minecraft;

public class Strafe
{
  JumpUtil jumpUtil = new JumpUtil();
  
  public Strafe() {}
  
  public void strafe(boolean strafe) { getMinecraftthePlayer.onGround = true;
    jumpUtil.CanJump = false;
  }
}
