package com.dreamtea.stick_n_slick.mixin;

import com.dreamtea.stick_n_slick.datagen.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {
    @Redirect(method = "isAdjacentBlockStuck",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
            ))
    private static boolean ifHoneyDontAttachToSlimeStuff(BlockState instance, Block block){
        if(block.equals(Blocks.HONEY_BLOCK)){
            return instance.isIn(Tags.ONLY_STICKS_TO_HONEY);
        }
        if(block.equals(Blocks.SLIME_BLOCK)){
            return instance.isIn(Tags.ONLY_STICKS_TO_SLIME);
        }
        return instance.isOf(block);
    }
}
