package xaidee.gloompersdelight.content;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import quek.undergarden.registry.UGEffects;
import quek.undergarden.registry.UGFoods;
import quek.undergarden.registry.UGItems;

import java.util.Map;

public class FoodValues extends vectorwing.farmersdelight.common.FoodValues {

    // Raw Crops
    public static final FoodProperties CRANBERRIES = (new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).build());

    // Drinks (mostly for effects)


    // Basic Foods
    public static final FoodProperties GLOOMGOURD_SLICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).effect(() ->
            new MobEffectInstance(UGEffects.VIRULENT_RESISTANCE.get(), 600, 0, false, true), 0.3F
    ).build();


    // Sweets
    public static final FoodProperties SWIVEL_FLOSS = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.1f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F).build();

    // Handheld Foods


    // Bowl Foods


    // Plated Foods


    // Feast Portions

    public static final Map<Item, FoodProperties> UNDERGARDEN_FOOD_EFFECTS =
                (new ImmutableMap.Builder<Item, FoodProperties>())
                        .put(UGItems.BLOODY_STEW.get(), UGFoods.BLOODY)
                        .put(UGItems.INDIGO_STEW.get(), UGFoods.INDIGO)
                        .put(UGItems.INKY_STEW.get(), UGFoods.INKY)
                        .put(UGItems.VEILED_STEW.get(), UGFoods.VEILED)
                        .put(UGItems.GLOOMGOURD_PIE.get(), UGFoods.GLOOMGOURD_PIE)
                        .build();
}
