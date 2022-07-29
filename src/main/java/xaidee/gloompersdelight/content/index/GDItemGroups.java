package xaidee.gloompersdelight.content.index;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import quek.undergarden.registry.UGBlocks;

public class GDItemGroups {

    public static final CreativeModeTab GROUP = new CreativeModeTab("gloompersdelight_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(UGBlocks.SMOG_VENT.get());
        }
    };
}
