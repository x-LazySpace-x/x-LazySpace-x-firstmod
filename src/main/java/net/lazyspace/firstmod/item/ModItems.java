package net.lazyspace.firstmod.item;

import net.lazyspace.firstmod.FirstMod;
import net.lazyspace.firstmod.item.custom.GreenCubeItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }

    public static final Item RED_CUBE = registerItem("red_cube", new Item(new Item.Settings()));
    public static final Item BLUE_CUBE = registerItem("blue_cube", new Item(new Item.Settings()));
    public static final Item GREEN_CUBE = registerItem("green_cube", new GreenCubeItem(new Item.Settings()));

    public static void registerModItems() {
        FirstMod.LOGGER.info("registering Items for " + FirstMod.MOD_ID);
    }
}
