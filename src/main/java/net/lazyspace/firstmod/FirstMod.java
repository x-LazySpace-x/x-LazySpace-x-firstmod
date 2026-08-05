package net.lazyspace.firstmod;

import net.fabricmc.api.ModInitializer;

import net.lazyspace.firstmod.block.ModBlocks;
import net.lazyspace.firstmod.item.ModItems;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "firstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
