package maxout.modules.render;

import org.lwjgl.input.Keyboard;

import maxout.events.Event;
import maxout.events.listeners.EventUpdate;
import maxout.modules.Module;
import tv.twitch.chat.Chat;

public class FullBright extends Module {
	private boolean Gamma1;
	private boolean Gamma0;
	
	public FullBright(){
		super("FullBright", Keyboard.KEY_O, Category.RENDER);
	}
	
	public void onEnable(){
		mc.gameSettings.gammaSetting = 100;
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
	}
	
}
