package net.shadowfacts.shadowjs.js.event.wrapper;

import net.minecraftforge.event.ServerChatEvent;
import net.shadowfacts.shadowjs.js.player.WrappedPlayer;

/**
 * @author shadowfacts
 */
public class ServerChatMessageReceived {

	private ServerChatEvent event;

	public ServerChatMessageReceived(ServerChatEvent event) {
		this.event = event;
	}

	public String getMessage() {
		return event.message;
	}

	public String getUsername() {
		return event.username;
	}

	public WrappedPlayer getPlayer() {
		return new WrappedPlayer(event.player);
	}

	public void cancel() {
		event.setCanceled(true);
	}

}
