package baguchan.tofucraft.util;

import net.minecraft.core.item.Item;

public class IDUtils {
	private static int curr_item_id = 0;
	private static int curr_block_id = 0;
	private static boolean[] usedItemIds;

	public static void initIds(int blockId, int itemId) {
		usedItemIds = new boolean[Item.itemsList.length];
		for (int i = 0; i < usedItemIds.length; i++) {
			if (Item.itemsList[i] != null) {
				usedItemIds[i] = true;
			}
		}
		curr_item_id = itemId;
		curr_block_id = blockId;
	}

	public static int nextIdItem() {
		throwException(curr_item_id);
		return curr_item_id++;
	}

	public static int nextIdBlock() {
		throwException(curr_block_id);
		return curr_block_id++;
	}

	private static void throwException(int id) {
		if (usedItemIds[id]) { // If id is already used then throw exception
			throw new RuntimeException("Tried to use id: " + id + " while its already being used by " + Item.itemsList[id].getKey() + "!");
		} else {
			usedItemIds[id] = true;
		}
	}
}
