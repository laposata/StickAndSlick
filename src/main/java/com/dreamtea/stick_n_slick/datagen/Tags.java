package com.dreamtea.stick_n_slick.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.List;

import static com.dreamtea.stick_n_slick.StickAndSlick.NAMESPACE;
import static net.minecraft.block.Blocks.*;
import static net.minecraft.block.Blocks.SLIME_BLOCK;

public class Tags extends FabricTagProvider.BlockTagProvider{
    public static TagKey<Block> ONLY_STICKS_TO_HONEY = createBlockTag(new Identifier(NAMESPACE, "stick_honey_only"));
    public static TagKey<Block> ONLY_STICKS_TO_SLIME = createBlockTag(new Identifier(NAMESPACE, "stick_slime_only"));

    public Tags(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    public static TagKey<Block> createBlockTag(Identifier tag){
        return TagKey.of(Registry.BLOCK_KEY,tag);
    }

    public static List<Block> onlySticksToHoney(){
        return Arrays.asList(HONEYCOMB_BLOCK, HONEY_BLOCK);
    }
    public static List<Block> onlySticksToSlime(){
        return Arrays.asList(MAGMA_BLOCK, SLIME_BLOCK);
    }


    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(ONLY_STICKS_TO_HONEY).add(onlySticksToHoney().toArray(Block[]::new));
        getOrCreateTagBuilder(ONLY_STICKS_TO_SLIME).add(onlySticksToSlime().toArray(Block[]::new));

    }
}
