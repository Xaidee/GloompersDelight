package xaidee.gloompersdelight.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import xaidee.gloompersdelight.GloompersDelight;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GDBlockTags extends IntrinsicHolderTagsProvider<Block> {

    public GDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.BLOCK, future, block -> block.builtInRegistryHolder().key(), GloompersDelight.MOD_ID, existingFileHelper);    }

    @Override
    public String getName() {
        return GloompersDelight.MOD_NAME + " Block Tags";
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Farmer's Delight
        tag(ModTags.HEAT_SOURCES).add(UGBlocks.SMOG_VENT.get());

        // Why this has to be optional is beyond me
        tag(ModTags.COMPOST_ACTIVATORS).addOptionalTag(UGTags.Blocks.MUSHROOMS.location());

        tag(ModTags.MINEABLE_WITH_KNIFE).add(
                UGBlocks.MOGMOSS_RUG.get()
        );
    }
}
