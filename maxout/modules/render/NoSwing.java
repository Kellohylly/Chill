package maxout.modules.render;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventRenderGUI;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import net.minecraft.client.gui.Gui;
import tv.twitch.chat.Chat;

public class NoSwing extends Module {
	
	public NoSwing(){
		super("NoSwing", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEvent(Event e) {
        mc.thePlayer.swingProgress = 1F;
			
		
	}
}
