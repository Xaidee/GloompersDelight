package xaidee.gloompersdelight.data.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.data.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.translate.JavaUnicodeEscaper;
import xaidee.gloompersdelight.GloompersDelight;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class GDLangProvider implements DataProvider {

    private final Map<String, String> data = new TreeMap<>();
    private final PackOutput output;
    private final String modid;
    private final String locale;

    public GDLangProvider(PackOutput output, String locale) {
        this.modid = GloompersDelight.MOD_ID;
        this.output = output;
        this.locale = locale;
    }

    protected abstract void addTranslations();

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        addTranslations();
        if (!data.isEmpty())
            return save(cache, this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(this.modid).resolve("lang").resolve(this.locale + ".json"));

        return CompletableFuture.allOf();
    }

    @Override
    public String getName() {
        return "Languages: " + locale;
    }

    private CompletableFuture<?> save(CachedOutput cache, Path target) {
        // TODO: DataProvider.saveStable handles the caching and hashing already, but creating the JSON Object this way seems unreliable. -C
        JsonObject json = new JsonObject();
        this.data.forEach(json::addProperty);

        return DataProvider.saveStable(cache, json, target);
    }

    public void addBlock(Supplier<? extends Block> key, String name) {
        add(key.get(), name);
    }

    public void add(Block key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void addItem(Supplier<? extends Item> key, String name) {
        add(key.get(), name);
    }

    public void add(Item key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void addItemGroup(CreativeModeTab group, String name) {
        add(group.getDisplayName().getString(), name);
    }

    public void addPotion(Supplier<? extends Potion> potion, String name) {
        add("item.minecraft.potion.effect." + ForgeRegistries.POTIONS.getKey(potion.get()).getPath(), "Potion of " + name);
        add("item.minecraft.splash_potion.effect." + ForgeRegistries.POTIONS.getKey(potion.get()).getPath(), "Splash Potion of " + name);
        add("item.minecraft.lingering_potion.effect." + ForgeRegistries.POTIONS.getKey(potion.get()).getPath(), "Lingering Potion of " + name);
        add("item.minecraft.tipped_arrow.effect." + ForgeRegistries.POTIONS.getKey(potion.get()).getPath(), "Arrow of " + name);
    }

    public void addTooltip(Supplier<? extends Item> item, String tooltip) {
        add("tooltip." + GloompersDelight.MOD_ID + "." + ForgeRegistries.ITEMS.getKey(item.get()).getPath(), tooltip);
    }

    public void addDisc(Supplier<? extends RecordItem> disc, String desc) {
        addItem(disc, "Music Disc");
        add(disc.get().getDescriptionId() + ".desc", desc);
    }

    public void addDisc(Supplier<? extends RecordItem> disc, String artist, String song) {
        addDisc(disc, artist + " - " + song);
    }

    public void addAdvTitle(String advancementTitle, String name) {
        add("advancements.oreganized." + advancementTitle + ".title", name);
    }

    public void addAdvDesc(String advancementTitle, String name) {
        add("advancements.oreganized." + advancementTitle + ".desc", name);
    }

    public void addSubtitle(String category, String subtitleName, String name) {
        add("subtitles." + category + "." + subtitleName, name);
    }

    public void addDeath(String deathName, String name) {
        add("death.attack." + deathName, name);
    }

    public void addItemStack(Supplier<ItemStack> key, String name) {
        add(key.get(), name);
    }

    public void add(ItemStack key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void addEnchantment(Supplier<? extends Enchantment> key, String name) {
        add(key.get(), name);
    }

    public void add(Enchantment key, String name) {
        add(key.getDescriptionId(), name);
    }

    /*
    public void addBiome(Supplier<? extends Biome> key, String name) {
        add(key.get(), name);
    }
    public void add(Biome key, String name) {
        add(key.getTranslationKey(), name);
    }
    */

    public void addEffect(Supplier<? extends MobEffect> key, String name) {
        add(key.get(), name);
    }

    public void add(MobEffect key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void addEntityType(Supplier<? extends EntityType<?>> key, String name) {
        add(key.get(), name);
    }

    public void add(EntityType<?> key, String name) {
        add(key.getDescriptionId(), name);
    }

    public void add(String key, String value) {
        if (data.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }

    public void tryBlock(Supplier<? extends Block> block) {
        String key = block.get().getDescriptionId();
        String value = formatString(ForgeRegistries.BLOCKS.getKey(block.get()).getPath());
        data.putIfAbsent(key, value);
    }

    public void tryItem(Supplier<? extends Item> item) {
        String key = item.get().getDescriptionId();
        String value = formatString(ForgeRegistries.ITEMS.getKey(item.get()).getPath());
        data.putIfAbsent(key, value);
    }

    private String formatString(String key) {
        String[] strArr = key.split("_");
        StringBuffer res = new StringBuffer();
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
        }
        return res.toString().trim();
    }
}
