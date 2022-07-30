package xaidee.gloompersdelight.content.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MelonJuiceItem;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class CranberryJuiceItem extends DrinkableItem {

    public CranberryJuiceItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level world, LivingEntity consumer) {
        consumer.heal(3.0F);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + ModItems.MELON_JUICE.get());

            tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
        }
    }
}
