package maxout.util;

import net.minecraft.client.Minecraft;

public class GetSpeed {
  public GetSpeed() {}
  
  public double getSpeed() {
    return getMinecraftthePlayer.motionX + getMinecraftthePlayer.motionZ + getMinecraftthePlayer.motionY / 3.0D;
  }
}
