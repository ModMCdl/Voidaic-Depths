package com.modmcdl.voidaicdepths.world.dim;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationSettings;

public class VoidGenerationSettings extends GenerationSettings
{

    private BlockPos spawnPos;

    public VoidGenerationSettings()
    {
        this.defaultBlock = VoidaicBlocks.VOIDSTONE.get().getDefaultState();
    }

    public VoidGenerationSettings setSpawnPos(BlockPos pos) {
        this.spawnPos = pos;
        return this;
    }

    public BlockPos getSpawnPos() {
        return this.spawnPos;
    }

}
