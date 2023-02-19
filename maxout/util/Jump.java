package maxout.util;

import net.minecraft.client.Minecraft;

public class Jump {
  public Jump() {}
  
  public void jump(boolean jump) {
    if ((getMinecraftthePlayer.onGround) && (getMinecraftthePlayer.fallDistance < 0.001D)) {
      getMinecraftthePlayer.jump();
    }
  }
}
