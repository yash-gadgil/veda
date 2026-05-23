package com.jackydoge.veda.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;

public class BoneTreeLeavesBlock extends LeavesBlock {

    public static final MapCodec<BoneTreeLeavesBlock> CODEC = simpleCodec(BoneTreeLeavesBlock::new);

    public BoneTreeLeavesBlock(Properties properties) {
        super(0.01F, properties);
    }

    @Override
    public MapCodec<BoneTreeLeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        // Small ash/bone particle falling from the leaves
        if (random.nextFloat() < 0.1F) {
            level.addParticle(ParticleTypes.WHITE_ASH,
                    pos.getX() + random.nextDouble(),
                    pos.getY(),
                    pos.getZ() + random.nextDouble(),
                    0.0, -0.05, 0.0);
        }
    }
}
