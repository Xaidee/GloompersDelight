package xaidee.gloompersdelight.data.lang;

import net.minecraft.data.DataGenerator;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.index.GDBlocks;
import xaidee.gloompersdelight.content.index.GDItemGroups;
import xaidee.gloompersdelight.content.index.GDItems;

public class GDLangGB extends GDLangUS {

    public GDLangGB(DataGenerator generator) {
        super(generator, "gb");
    }

    public GDLangGB(DataGenerator generator, String subLocale) {
        super(generator, subLocale);
    }

    @Override
    protected void addSubLocaleTranslations() {
        addItem(GDItems.CHILI_PEPPER_SEEDS, "Chilli Pepper Seeds");

        addBlock(GDBlocks.CHILI_PEPPER_CROP, "Chilli Peppers");
        addBlock(GDBlocks.WILD_CHILI_PEPPERS, "Wild Chilli Peppers");
    }
}
