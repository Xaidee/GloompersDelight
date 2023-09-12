package xaidee.gloompersdelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import xaidee.gloompersdelight.content.index.GDItems;
import xaidee.gloompersdelight.data.provider.GDItemModelProvider;

public class GDItemModels extends GDItemModelProvider {

    public GDItemModels(DataGenerator generator, ExistingFileHelper help) {
        super(generator, help);
    }

    @Override
    public String getName() {
        return "Gloomper's Delight Item Models";
    }

    @Override
    protected void registerModels() {
        toolItem(GDItems.CLOGGRUM_KNIFE);
        toolItem(GDItems.FROSTSTEEL_KNIFE);
        toolItem(GDItems.UTHERIUM_KNIFE);
        toolItem(GDItems.FORGOTTEN_KNIFE);
    }
}
