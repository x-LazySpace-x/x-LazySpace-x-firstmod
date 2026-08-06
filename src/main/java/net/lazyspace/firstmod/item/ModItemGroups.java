package net.lazyspace.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lazyspace.firstmod.FirstMod;
import net.lazyspace.firstmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LAZYS_FIRST_MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "lazys_first_mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RED_CUBE))
                    .displayName(Text.translatable("itemgroup.firstmod.lazys_first_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_CUBE);
                        entries.add(ModItems.BLUE_CUBE);
                        entries.add(ModBlocks.PURPLE_CUBE);
                        entries.add(ModItems.GREEN_CUBE);
                    })
                    .build());

    public static void registerItemGroup() {
        FirstMod.LOGGER.info("registering Item Groups for " + FirstMod.MOD_ID);
    }

}
