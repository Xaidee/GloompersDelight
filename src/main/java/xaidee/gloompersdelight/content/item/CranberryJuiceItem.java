package xaidee.gloompersdelight.content.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CranberryJuiceItem extends DrinkableItem {

    public CranberryJuiceItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level world, LivingEntity consumer) {
        consumer.heal(3.0F);
    }
}
