package xaidee.gloompersdelight.content.index;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import quek.undergarden.registry.UGBlocks;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.block.ChiliPepperBlock;

import java.util.function.Supplier;

public class GDBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GloompersDelight.MOD_ID);

    // Crop Storage


    // Composting
    public static final RegistryObject<Block> INDIGO_MUSHROOM_COLONY = register("indigo_mushroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(UGBlocks.INDIGO_MUSHROOM.get()), () -> UGBlocks.INDIGO_MUSHROOM.get().asItem()));
    public static final RegistryObject<Block> VEIL_MUSHROOM_COLONY = register("veil_mushroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(UGBlocks.VEIL_MUSHROOM.get()), () -> UGBlocks.VEIL_MUSHROOM.get().asItem()));
    public static final RegistryObject<Block> INK_MUSHROOM_COLONY = register("ink_mushroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(UGBlocks.INK_MUSHROOM.get()), () -> UGBlocks.INK_MUSHROOM.get().asItem()));
    public static final RegistryObject<Block> BLOOD_MUSHROOM_COLONY = register("blood_mushroom_colony",
            () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(UGBlocks.BLOOD_MUSHROOM.get()), () -> UGBlocks.BLOOD_MUSHROOM.get().asItem()));


    // Pastries


    // Wild Crops
    public static final RegistryObject<Block> WILD_CHILI_PEPPERS = register("wild_chili_peppers",
            () -> new WildCropBlock(MobEffects.REGENERATION, 6, Block.Properties.copy(Blocks.TALL_GRASS)));

    // Crops
    public static final RegistryObject<Block> CHILI_PEPPER_CROP = register("chili_peppers",
            () -> new ChiliPepperBlock(Block.Properties.copy(Blocks.WHEAT)));

    // Feasts


    public static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends B> block, CreativeModeTab tab) {
        RegistryObject<B> blocks = BLOCKS.register(name, block);
        GDItems.ITEMS.register(name, () -> new BlockItem(blocks.get(), new Item.Properties().tab(tab)));
        return blocks;
    }

    public static <B extends Block> RegistryObject<B> register(String name, Supplier<? extends B> block) {
        return BLOCKS.register(name, block);
    }

}
