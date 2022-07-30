package xaidee.gloompersdelight.content.index;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import quek.undergarden.registry.UGItemGroups;
import quek.undergarden.registry.UGItemTiers;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.FoodValues;
import xaidee.gloompersdelight.content.item.BloodBottleItem;
import xaidee.gloompersdelight.content.item.CranberryJuiceItem;
import xaidee.gloompersdelight.content.item.tool.GDKnifeItem;

public class GDItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GloompersDelight.MOD_ID);

    // Knives
    public static final RegistryObject<Item> CLOGGRUM_KNIFE = ITEMS.register("cloggrum_knife",
            () -> new GDKnifeItem(UGItemTiers.CLOGGRUM, 0.5F, -2.0F));
    public static final RegistryObject<Item> FROSTSTEEL_KNIFE = ITEMS.register("froststeel_knife",
            () -> new GDKnifeItem(UGItemTiers.FROSTSTEEL, 0.5F, -2.0F));
    public static final RegistryObject<Item> UTHERIUM_KNIFE = ITEMS.register("utherium_knife",
            () -> new GDKnifeItem(UGItemTiers.UTHERIUM, 0.5F, -2.0F));
    public static final RegistryObject<Item> FORGOTTEN_KNIFE = ITEMS.register("forgotten_knife",
            () -> new GDKnifeItem(UGItemTiers.FORGOTTEN, 0.5F, -2.0F));

    // Wild Crops


    // Basic Crops
    public static final RegistryObject<Item> CRANBERRIES = ITEMS.register("cranberries",
            () -> new Item(new Item.Properties().food(FoodValues.CRANBERRIES).craftRemainder(Items.BOWL).tab(GDItemGroups.GROUP)));

    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds", () -> new ItemNameBlockItem(GDBlocks.CHILI_PEPPER_CROP.get(), new Item.Properties().tab(GDItemGroups.GROUP)));

    // Foodstuffs
    public static final RegistryObject<Item> GLOOMGOURD_SLICE = ITEMS.register("gloomgourd_slice",
            () -> new Item(new Item.Properties().food(FoodValues.GLOOMGOURD_SLICE).tab(GDItemGroups.GROUP)));

    public static final RegistryObject<Item> BLOOD_BOTTLE = ITEMS.register("blood_bottle",
            () -> new BloodBottleItem(new Item.Properties().food(FoodValues.BLOOD_BOTTLE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(GDItemGroups.GROUP)));

    public static final RegistryObject<Item> CRANBERRY_JUICE = ITEMS.register("cranberry_juice",
            () -> new CranberryJuiceItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(GDItemGroups.GROUP)));

    // Sweets
    public static final RegistryObject<Item> SWIVEL_FLOSS = ITEMS.register("swivel_floss",
            () -> new Item(new Item.Properties().food(FoodValues.SWIVEL_FLOSS).tab(GDItemGroups.GROUP)));

    // Basic Meals
    public static final RegistryObject<Item> UNDER_FRUIT_SALAD = ITEMS.register("under_fruit_salad",
            () -> new ConsumableItem(new Item.Properties().food(FoodValues.FRUIT_SALAD).craftRemainder(Items.BOWL).stacksTo(16).tab(GDItemGroups.GROUP), true));

    // Soups and Stews
    public static final RegistryObject<Item> GLOOMGOUD_SOUP = ITEMS.register("gloomgourd_soup",
            () -> new ConsumableItem(new Item.Properties().food(FoodValues.GLOOMGOURD_SOUP).craftRemainder(Items.BOWL).stacksTo(16).tab(GDItemGroups.GROUP), true));

    // Plated Meals

    // Feasts

    // Pet Foods
}
