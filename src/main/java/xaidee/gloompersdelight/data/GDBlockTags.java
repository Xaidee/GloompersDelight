package xaidee.gloompersdelight.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import xaidee.gloompersdelight.GloompersDelight;

import javax.annotation.Nullable;

public class GDBlockTags extends BlockTagsProvider {

    public GDBlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, GloompersDelight.MOD_ID, existingFileHelper);    }

    @Override
    public String getName() {
        return GloompersDelight.MOD_NAME + " Block Tags";
    }

    @Override
    protected void addTags() {
        // Farmer's Delight
        tag(ModTags.HEAT_SOURCES).add(UGBlocks.SMOG_VENT.get());

        // Why this has to be optional is beyond me
        tag(ModTags.COMPOST_ACTIVATORS).addOptionalTag(UGTags.Blocks.MUSHROOMS.location());

        tag(ModTags.MINEABLE_WITH_KNIFE).add(
                UGBlocks.MOGMOSS_RUG.get()
        );
    }
}
