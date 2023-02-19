package maxout.util.esp;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class ChestESP {
		
		public static void blockESPBox (BlockPos blockPos) {
			double x = blockPos.getX() - Minecraft.getMinecraft().getRenderManager().renderPosX;
			double y = blockPos.getY() - Minecraft.getMinecraft().getRenderManager().renderPosY;
			double z = blockPos.getZ() - Minecraft.getMinecraft().getRenderManager().renderPosZ;
			
			GL11.glBlendFunc(770, 771);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glLineWidth(2.0F);
			GL11.glColor4d(0, 1, 0, 0.15F);
			
		}
		
}
