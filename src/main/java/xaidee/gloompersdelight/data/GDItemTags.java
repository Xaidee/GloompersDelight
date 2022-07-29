package xaidee.gloompersdelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import quek.undergarden.registry.UGItems;
import quek.undergarden.registry.UGTags;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.index.GDItems;

import javax.annotation.Nullable;

public class GDItemTags extends ItemTagsProvider {

    public GDItemTags(DataGenerator generator, BlockTagsProvider blockTags, @Nullable ExistingFileHelper helper) {
        super(generator, blockTags, GloompersDelight.MOD_ID, helper);
    }

    @Override
    public String getName() {
        return GloompersDelight.MOD_NAME + " Item Tags";
    }

    @Override
    protected void addTags() {
        // Gloomper's Delight


        // Undergarden
        tag(UGTags.Items.CLOGGRUM_ITEMS).add(GDItems.CLOGGRUM_KNIFE.get());
        tag(UGTags.Items.FROSTSTEEL_ITEMS).add(GDItems.FROSTSTEEL_KNIFE.get());
        tag(UGTags.Items.UTHERIUM_ITEMS).add(GDItems.UTHERIUM_KNIFE.get());

        // Farmer's Delight
        tag(ModTags.KNIVES).add(GDItems.CLOGGRUM_KNIFE.get(), GDItems.FROSTSTEEL_KNIFE.get(), GDItems.UTHERIUM_KNIFE.get(), GDItems.FORGOTTEN_KNIFE.get());
        tag(ModTags.OFFHAND_EQUIPMENT).add(UGItems.CLOGGRUM_SHIELD.get());

        // Forge
        tag(ForgeTags.TOOLS_KNIVES).add(GDItems.CLOGGRUM_KNIFE.get(), GDItems.FROSTSTEEL_KNIFE.get(), GDItems.UTHERIUM_KNIFE.get(), GDItems.FORGOTTEN_KNIFE.get());

        // Vanilla Minecraft


    }
}
