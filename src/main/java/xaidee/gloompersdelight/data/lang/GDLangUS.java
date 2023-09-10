package xaidee.gloompersdelight.data.lang;

import net.minecraft.data.PackOutput;
import xaidee.gloompersdelight.content.index.GDBlocks;
import xaidee.gloompersdelight.content.index.GDItems;
import xaidee.gloompersdelight.data.provider.GDLangProvider;

public class GDLangUS extends GDLangProvider {

    public GDLangUS(PackOutput output) {
        super(output, "en_us");
    }

    // Used by other English variants that extend this class
    public GDLangUS(PackOutput output, String subLocale) {
        super(output, "en_" + subLocale);
    }

    @Override
    protected void addTranslations() {
        //addItemGroup(GDItemGroups.GROUP, GloompersDelight.MOD_NAME);

        addSubLocaleTranslations();

        /*
            Automatically create translations for blocks and items based on their registry name.

            This must be at the very bottom to avoid overwriting errors. These functions ignore objects
            that have already been translated above.
         */
        for (int i = 0; GDBlocks.BLOCKS.getEntries().size() > i; i++) {
            tryBlock(GDBlocks.BLOCKS.getEntries().stream().toList().get(i));
        }
        for (int i = 0; GDItems.ITEMS.getEntries().size() > i; i++) {
            tryItem(GDItems.ITEMS.getEntries().stream().toList().get(i));
        }
    }

    // Sub locales should override this function rather than addTranslations() to avoid code duplication.
    protected void addSubLocaleTranslations() {}
}
