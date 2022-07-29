package xaidee.gloompersdelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import xaidee.gloompersdelight.content.index.GDItems;
import xaidee.gloompersdelight.data.provider.GDItemModelProvider;

public class GDItemModels extends GDItemModelProvider {

    public GDItemModels(DataGenerator gen, ExistingFileHelper help) {
        super(gen, help);
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

        normalItem(GDItems.CRANBERRIES);
        normalItem(GDItems.GLOOMGOURD_SLICE);
        normalItem(GDItems.UNDER_FRUIT_SALAD);
        normalItem(GDItems.SWIVEL_FLOSS);
    }
}
