package xaidee.gloompersdelight;

import net.minecraftforge.common.ForgeConfigSpec;

public class GDConfig {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    // COMMON
    public static final String CATEGORY_SETTINGS = "settings";
    public static ForgeConfigSpec.BooleanValue THROWABLE_ROTTEN_TOMATOES;

    public static final String CATEGORY_WORLD = "world";
    public static ForgeConfigSpec.BooleanValue GENERATE_GD_CHEST_LOOT;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CHILLI_PEPPERS;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_CHILLI_PEPPERS;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CRANBERRIES;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_CRANBERRIES;

    // CLIENT
    public static final String CATEGORY_CLIENT = "client";


    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Game settings").push(CATEGORY_SETTINGS);
        THROWABLE_ROTTEN_TOMATOES = COMMON_BUILDER.comment("Usually Rotten Tomatoes can be thrown by hand, but by default Gloomper's Delight disables this behavior in favor of using it as slingshot ammo. Should they still be throwable by hand?")
                .define("throwableRottenTomatoes", false);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
        GENERATE_GD_CHEST_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (ropes, seeds, knives, meals etc.) as extra chest loot in the Undergarden?")
                .define("generateGDChestLoot", true);

        COMMON_BUILDER.comment("Wild Chilli Pepper generation").push("wild_chilli_peppers");
        GENERATE_WILD_CHILLI_PEPPERS = COMMON_BUILDER.comment("Generate wild chilli peppers in smog spires")
                .define("genWildChilliPeppers", true);
        CHANCE_WILD_CHILLI_PEPPERS = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("Cranberry generation").push("wild_cranberries");
        GENERATE_WILD_CRANBERRIES = COMMON_BUILDER.comment("Generate cranberries on Undergarden seabeds")
                .define("genWildBeetroots", true);
        CHANCE_WILD_CRANBERRIES = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 30, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.pop();

        CLIENT_CONFIG = COMMON_BUILDER.build();
    }
}
