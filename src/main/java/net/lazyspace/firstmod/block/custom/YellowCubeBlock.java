package net.lazyspace.firstmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.lazyspace.firstmod.FirstMod;
import net.lazyspace.firstmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class YellowCubeBlock extends HorizontalFacingBlock {

    public static final MapCodec<YellowCubeBlock> CODEC = createCodec(YellowCubeBlock::new);

    @Override
    public MapCodec<YellowCubeBlock> getCodec() {
        return CODEC;
    }

    public YellowCubeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        return ActionResult.SUCCESS;
    }
}
