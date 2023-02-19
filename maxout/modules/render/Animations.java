package maxout.modules.render;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import maxout.Client;
import maxout.events.Event;
import maxout.events.listeners.EventKey;
import maxout.events.listeners.EventRenderGUI;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import tv.twitch.chat.Chat;

public class Animations extends Module {



	public Animations(){
		super("Animations", Keyboard.KEY_NONE, Category.RENDER);
	}

	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			if(mc.thePlayer.isCollidedHorizontally) {
				mc.thePlayer.cameraYaw = 1.5F; 
				mc.thePlayer.cameraPitch = 0F;
				mc.thePlayer.performHurtAnimation();
			}
			if(mc.thePlayer.isBlocking()) {
				
				// no and yes //INVASTEGETA //wth
				
				mc.thePlayer.renderArmPitch = -120F;
				mc.thePlayer.renderArmYaw = -500F;
				
			}
			

			
		}

	}
}
