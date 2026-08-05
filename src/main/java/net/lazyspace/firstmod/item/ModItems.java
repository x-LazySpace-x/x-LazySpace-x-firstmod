package net.lazyspace.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lazyspace.firstmod.FirstMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }

    public static final Item RED_CUBE = registerItem("red_cube", new Item(new Item.Settings()));
    public static final Item BLUE_CUBE = registerItem("blue_cube", new Item(new Item.Settings()));

    public static void registerModItems() {
        FirstMod.LOGGER.info("registering Items for " + FirstMod.MOD_ID);
    }
}
