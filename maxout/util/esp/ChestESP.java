package maxout.util.esp;

import net.minecraft.client.Minecraft;

public class ChestESP
{
  public ChestESP() {}
  
  public static void blockESPBox(net.minecraft.util.BlockPos blockPos)
  {
    double x = blockPos.getX() - getMinecraftgetRenderManagerrenderPosX;
    double y = blockPos.getY() - getMinecraftgetRenderManagerrenderPosY;
    double z = blockPos.getZ() - getMinecraftgetRenderManagerrenderPosZ;
    
    org.lwjgl.opengl.GL11.glBlendFunc(770, 771);
    org.lwjgl.opengl.GL11.glEnable(3042);
    org.lwjgl.opengl.GL11.glLineWidth(2.0F);
    org.lwjgl.opengl.GL11.glColor4d(0.0D, 1.0D, 0.0D, 0.15000000596046448D);
  }
}
