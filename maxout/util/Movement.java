package maxout.util;

import net.minecraft.client.Minecraft;

public class Movement
{
  public Movement() {}
  
  public float speed(float speed) {
    getMinecraftthePlayer.motionX *= speed;
    getMinecraftthePlayer.motionZ *= speed;
    return speed;
  }
  
  public class boost
  {
    public boost() {}
    
    public boolean boost(float boostx, float boosty, float boostz, boolean status) {
      getMinecraftthePlayer.motionX = boostx;
      getMinecraftthePlayer.motionY = boosty;
      getMinecraftthePlayer.motionZ = boostz;
      return true;
    }
  }
}
