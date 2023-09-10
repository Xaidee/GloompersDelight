package xaidee.gloompersdelight.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import quek.undergarden.registry.UGItems;
import quek.undergarden.registry.UGTags;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.index.GDItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GDItemTags extends ItemTagsProvider {

    public GDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, provider, GloompersDelight.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return GloompersDelight.MOD_NAME + " Item Tags";
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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
