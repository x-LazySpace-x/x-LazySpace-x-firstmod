package net.lazyspace.firstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GreenCubeItem extends Item {

    public GreenCubeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        PlayerEntity playerEntity = context.getPlayer();

        if (blockState != null) {
            if (blockState.isIn(BlockTags.WOOL)) {
                if (!playerEntity.isSneaking()) {
                    if (!world.isClient) {
                        world.setBlockState(blockPos, Blocks.DIAMOND_BLOCK.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                    }
                }
            } else if (blockState.isIn(BlockTags.PLANKS)) {
                if (playerEntity.isSneaking()) {
                    if (!world.isClient) {
                        world.setBlockState(blockPos, Blocks.EMERALD_BLOCK.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                    }
                }
            }
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}
