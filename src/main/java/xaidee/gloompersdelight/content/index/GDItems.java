package xaidee.gloompersdelight.content.index;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import quek.undergarden.registry.UGItemTiers;
import xaidee.gloompersdelight.GloompersDelight;
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

    // Foodstuffs

    // Sweets

    // Basic Meals

    // Soups and Stews

    // Plated Meals

    // Feasts

    // Pet Foods
}
