package xaidee.gloompersdelight.client;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import quek.undergarden.registry.UGFoods;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.FoodValues;
import xaidee.gloompersdelight.content.index.GDBlocks;

import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = GloompersDelight.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GDClient {

    private static void render(Supplier<? extends Block> block, RenderType render) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), render);
    }

    public static void registerBlockRenderers() {
        RenderType cutout = RenderType.cutout();
        RenderType mipped = RenderType.cutoutMipped();
        RenderType translucent = RenderType.translucent();

        render(GDBlocks.INDIGO_MUSHROOM_COLONY, cutout);
        render(GDBlocks.VEIL_MUSHROOM_COLONY, cutout);
        render(GDBlocks.INK_MUSHROOM_COLONY, cutout);
        render(GDBlocks.BLOOD_MUSHROOM_COLONY, cutout);
    }

    @Mod.EventBusSubscriber(modid = GloompersDelight.MOD_ID, value = Dist.CLIENT)
    static class ToolTipEvents {
        @SubscribeEvent
        public static void addToolTipToUndergardenFoods(ItemTooltipEvent event) {
            Item food = event.getItemStack().getItem();

            FoodProperties foodEffects = FoodValues.UNDERGARDEN_FOOD_EFFECTS.get(food);

            if (foodEffects != null) {
                List<Component> tooltip = event.getToolTip();
                for (Pair<MobEffectInstance, Float> pair : foodEffects.getEffects()) {
                    MobEffectInstance effect = pair.getFirst();
                    MutableComponent effectText = new TranslatableComponent(effect.getDescriptionId());
                    if (effect.getDuration() > 20) {
                        effectText = new TranslatableComponent("potion.withDuration", effectText, MobEffectUtil.formatDuration(effect, 1));
                    }
                    tooltip.add(effectText.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
                }
            }
        }
    }
}
