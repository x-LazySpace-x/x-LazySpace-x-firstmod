package net.lazyspace.firstmod.block;

import net.lazyspace.firstmod.FirstMod;
import net.lazyspace.firstmod.block.custom.YellowCubeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PURPLE_CUBE = registerBlock("purple_cube", new Block(AbstractBlock.Settings.create()
            .strength(1f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
    ));
    public static final Block YELLOW_CUBE = registerBlock("yellow_cube", new YellowCubeBlock(AbstractBlock.Settings.create()
            .strength(1f)
            .sounds(BlockSoundGroup.METAL)
    ));

    private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, Identifier.of(FirstMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("registering Blocks for " + FirstMod.MOD_ID);
    }
}
