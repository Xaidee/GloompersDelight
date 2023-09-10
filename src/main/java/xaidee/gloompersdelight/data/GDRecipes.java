package xaidee.gloompersdelight.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.index.GDItems;
import xaidee.gloompersdelight.data.provider.GDRecipeProvider;

import java.util.function.Consumer;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;

public class GDRecipes extends GDRecipeProvider {

    public GDRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        makeKnife(GDItems.CLOGGRUM_KNIFE, UGItems.CLOGGRUM_INGOT).save(consumer);
        makeKnife(GDItems.FROSTSTEEL_KNIFE, UGItems.FROSTSTEEL_INGOT).save(consumer);
        makeKnife(GDItems.UTHERIUM_KNIFE, UGItems.UTHERIUM_CRYSTAL).save(consumer);

        smithingForgotten(GDItems.CLOGGRUM_KNIFE, GDItems.FORGOTTEN_KNIFE).save(consumer, name("forgotten_knife_smithing"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ORGANIC_COMPOST.get())
                .requires(UGBlocks.DEEPSOIL.get())
                .requires(Items.ROTTEN_FLESH)
                .requires(Items.ROTTEN_FLESH)
                .requires(ModItems.STRAW.get())
                .requires(ModItems.STRAW.get())
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .unlockedBy("has_straw", has(ModItems.STRAW.get()))
                .save(consumer, name("deepsoil_organic_compost_from_rotten_flesh"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ORGANIC_COMPOST.get())
                .requires(UGBlocks.DEEPSOIL.get())
                .requires(ModItems.STRAW.get())
                .requires(ModItems.STRAW.get())
                .requires(Items.BONE_MEAL)
                .requires(Items.BONE_MEAL)
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .requires(ModItems.TREE_BARK.get())
                .unlockedBy("has_tree_bark", has(ModItems.TREE_BARK.get()))
                .unlockedBy("has_straw", has(ModItems.STRAW.get()))
                .save(consumer, name("deepsoil_organic_compost_from_tree_bark"));

        // Cutting Recipes
        knifeCut(Items.BLUE_DYE, UGBlocks.INDIGO_MUSHROOM.get()).build(consumer, name("cutting/blue_dye_from_indigo_mushroom"));
        knifeCut(Items.WHITE_DYE, UGBlocks.VEIL_MUSHROOM.get()).build(consumer, name("cutting/white_dye_from_veil_mushroom"));
        knifeCut(Items.BLACK_DYE, UGBlocks.INK_MUSHROOM.get()).build(consumer, name("cutting/black_dye_from_ink_mushroom"));
        knifeCut(Items.RED_DYE, UGBlocks.BLOOD_MUSHROOM.get()).build(consumer, name("cutting/red_dye_from_blood_mushroom"));

        knifeCut(UGItems.DITCHBULB_PASTE.get(), UGItems.DITCHBULB.get()).addResultWithChance(Items.ORANGE_DYE, 0.33F).build(consumer, name("cutting/ditchbulb_paste"));

        //knifeCut(GDItems.GLOOMGOURD_SLICE.get(), UGBlocks.GLOOMGOURD.get(), 4).build(consumer, name("cutting/gloomgourd_slice"));

        stripLogForBark(UGBlocks.GRONGLE_LOG.get(), UGBlocks.STRIPPED_GRONGLE_LOG.get()).build(consumer, name("cutting/bark_from_grongle"));
        stripLogForBark(UGBlocks.SMOGSTEM_LOG.get(), UGBlocks.STRIPPED_SMOGSTEM_LOG.get()).build(consumer, name("cutting/bark_from_smogstem"));
        stripLogForBark(UGBlocks.WIGGLEWOOD_LOG.get(), UGBlocks.STRIPPED_WIGGLEWOOD_LOG.get()).build(consumer, name("cutting/bark_from_wigglewood"));

        salvagePlankFromFurniture(consumer, UGBlocks.GRONGLE_PLANKS.get(), UGBlocks.GRONGLE_DOOR.get(), UGBlocks.GRONGLE_TRAPDOOR.get(), UGBlocks.GRONGLE_SIGN.get());
        salvagePlankFromFurniture(consumer, UGBlocks.SMOGSTEM_PLANKS.get(), UGBlocks.SMOGSTEM_DOOR.get(), UGBlocks.SMOGSTEM_TRAPDOOR.get(), UGBlocks.SMOGSTEM_SIGN.get());
        salvagePlankFromFurniture(consumer, UGBlocks.WIGGLEWOOD_PLANKS.get(), UGBlocks.WIGGLEWOOD_DOOR.get(), UGBlocks.WIGGLEWOOD_TRAPDOOR.get(), UGBlocks.WIGGLEWOOD_SIGN.get());

        // Cooking Recipes
        CookingPotRecipeBuilder.cookingPotRecipe(UGItems.INDIGO_STEW.get(), 1, NORMAL_COOKING, 0.2F, Items.BOWL)
                .addIngredient(UGBlocks.INDIGO_MUSHROOM.get())
                .addIngredient(UGBlocks.INDIGO_MUSHROOM.get())
                .addIngredient(UGBlocks.INDIGO_MUSHROOM.get())
                .build(consumer, name("cooking/indigo_stew"));
        CookingPotRecipeBuilder.cookingPotRecipe(UGItems.VEILED_STEW.get(), 1, NORMAL_COOKING, 0.2F, Items.BOWL)
                .addIngredient(UGBlocks.VEIL_MUSHROOM.get())
                .addIngredient(UGBlocks.VEIL_MUSHROOM.get())
                .addIngredient(UGBlocks.VEIL_MUSHROOM.get())
                .build(consumer, name("cooking/veiled_stew"));
        CookingPotRecipeBuilder.cookingPotRecipe(UGItems.INKY_STEW.get(), 1, NORMAL_COOKING, 0.2F, Items.BOWL)
                .addIngredient(UGBlocks.INK_MUSHROOM.get())
                .addIngredient(UGBlocks.INK_MUSHROOM.get())
                .addIngredient(UGBlocks.INK_MUSHROOM.get())
                .build(consumer, name("cooking/ink_stew"));
        CookingPotRecipeBuilder.cookingPotRecipe(UGItems.BLOODY_STEW.get(), 1, NORMAL_COOKING, 0.2F, Items.BOWL)
                .addIngredient(UGBlocks.BLOOD_MUSHROOM.get())
                .addIngredient(UGBlocks.BLOOD_MUSHROOM.get())
                .addIngredient(UGBlocks.BLOOD_MUSHROOM.get())
                .build(consumer, name("cooking/bloody_stew"));
    }

    private ResourceLocation name(String name) {
        return new ResourceLocation(GloompersDelight.MOD_ID, name);
    }
}
