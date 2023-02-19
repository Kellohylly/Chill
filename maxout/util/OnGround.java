package maxout.util;

import net.minecraft.client.Minecraft;

public class OnGround {
  public OnGround() {}
  
  public boolean onGround(boolean onGround) {
    if ((getMinecraftthePlayer.onGround) && (getMinecraftthePlayer.fallDistance < 0.1F)) {
      return true;
    }
    return false;
  }
}
