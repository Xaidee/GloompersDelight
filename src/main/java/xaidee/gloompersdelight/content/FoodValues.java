package xaidee.gloompersdelight.content;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import quek.undergarden.registry.UGFoods;
import quek.undergarden.registry.UGItems;

import java.util.Map;

public class FoodValues extends vectorwing.farmersdelight.common.FoodValues {

    // Raw Crops

    // Drinks (mostly for effects)

    // Basic Foods


    // Sweets

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
