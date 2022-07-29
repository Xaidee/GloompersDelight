package xaidee.gloompersdelight.data.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.ForgeRegistries;
import quek.undergarden.data.provider.UGRecipeProvider;
import vectorwing.farmersdelight.common.crafting.ingredient.ToolActionIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import xaidee.gloompersdelight.GloompersDelight;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GDRecipeProvider extends UGRecipeProvider {

    public GDRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    public ShapedRecipeBuilder makeKnife(Supplier<? extends Item> knifeOut, Supplier<? extends Item> materialIn) {
        return ShapedRecipeBuilder.shaped(knifeOut.get())
                .pattern(" #")
                .pattern("/ ")
                .define('#', materialIn.get())
                .define('/', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(materialIn.get()).getPath(), has(materialIn.get()));
    }

    public CuttingBoardRecipeBuilder knifeCut(ItemLike itemOut, ItemLike itemIn, int amount) {
        return CuttingBoardRecipeBuilder.cuttingRecipe(
                Ingredient.of(itemIn),
                Ingredient.of(ForgeTags.TOOLS_KNIVES),
                itemOut, amount
        );
    }

    public CuttingBoardRecipeBuilder knifeCut(ItemLike itemOut, ItemLike itemIn) {
        return knifeCut(itemOut, itemIn, 1);
    }

    /**
     * Generates an axe-cutting recipe for each furniture, resulting in one plank of the given type.
     */
    public static void salvagePlankFromFurniture(Consumer<FinishedRecipe> consumer, ItemLike plank, ItemLike door, ItemLike trapdoor, ItemLike sign) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(door), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, name("cutting/salvage/" + getName(door)));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(trapdoor), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, name("cutting/salvage/" + getName(trapdoor)));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(sign), new ToolActionIngredient(ToolActions.AXE_DIG), plank).build(consumer, name("cutting/salvage/" + getName(sign)));
    }

    /**
     * Generates an axe-stripping recipe for the pair of given logs, with custom sound and a Tree Bark result attached.
     */
    public CuttingBoardRecipeBuilder stripLogForBark(ItemLike log, ItemLike strippedLog) {
        return CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ToolActionIngredient(ToolActions.AXE_STRIP), strippedLog)
                .addResult(ModItems.TREE_BARK.get())
                .addSound(SoundEvents.AXE_STRIP.getRegistryName().toString());
    }

    private static ResourceLocation name(String name) {
        return new ResourceLocation(GloompersDelight.MOD_ID, name);
    }

    private static String getName(ItemLike item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem())).getPath();
    }
}
