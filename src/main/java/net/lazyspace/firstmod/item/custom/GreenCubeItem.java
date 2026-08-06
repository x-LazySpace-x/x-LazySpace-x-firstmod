package net.lazyspace.firstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class GreenCubeItem extends Item {
    private static final Map<Block, Block> GREEN_CUBE_MAP =
            Map.of(
                    Blocks.STONE, Blocks.END_STONE
            );

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
                        if (playerEntity != null) {
                            context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                        }
                    }
                }
            } else if (blockState.isIn(BlockTags.PLANKS)) {
                if (playerEntity.isSneaking()) {
                    if (!world.isClient) {
                        world.setBlockState(blockPos, Blocks.EMERALD_BLOCK.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
                        if (playerEntity != null) {
                            context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                        }
                    }
                }
            }
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}
