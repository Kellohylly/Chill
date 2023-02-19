package maxout.util;

import net.minecraft.client.Minecraft;

public class Boost {
  public Boost() {}
  
  public boolean boost(float boostx, float boosty, float boostz, boolean status) {
    getMinecraftthePlayer.motionX *= boostx;
    getMinecraftthePlayer.motionY *= boosty;
    getMinecraftthePlayer.motionZ *= boostz;
    return true;
  }
}
