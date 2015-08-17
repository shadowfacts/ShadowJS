package net.shadowfacts.shadowjs.command;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

/**
 * @author shadowfacts
 */
public class CommandHand extends CommandBase {

	public static CommandHand instance = new CommandHand();

	private CommandHand() {
	}

	@Override
	public String getCommandName() {
		return "hand";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Prints the modid, internal name, and metadata of the held item.";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)sender;
			ItemStack heldStack = player.getHeldItem();

			String result = GameData.getItemRegistry().getNameForObject(heldStack.getItem());
			result += ":" + heldStack.getItemDamage();

			player.addChatComponentMessage(new ChatComponentText(result));

		}
	}

}
