package xaidee.gloompersdelight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import quek.undergarden.entity.projectile.slingshot.SlingshotProjectile;
import quek.undergarden.item.tool.slingshot.AbstractSlingshotAmmoBehavior;
import quek.undergarden.item.tool.slingshot.SlingshotItem;
import quek.undergarden.registry.UGItems;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModItems;
import xaidee.gloompersdelight.client.GDClient;
import xaidee.gloompersdelight.content.entity.projectile.slingshot.RottenTomato;
import xaidee.gloompersdelight.content.index.*;
import xaidee.gloompersdelight.data.*;
import xaidee.gloompersdelight.data.lang.*;

@Mod(GloompersDelight.MOD_ID)
public class GloompersDelight {

    public static final String MOD_ID = "gloompersdelight";
    public static final String MOD_NAME = "Gloomper's Delight";
    public static final Logger LOGGER = LogManager.getLogger();

    public GloompersDelight() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::gatherData);

        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GDConfig.COMMON_CONFIG);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, GDConfig.CLIENT_CONFIG);

        DeferredRegister<?>[] registers = {
                GDItems.ITEMS,
                GDBlocks.BLOCKS,
        };

        for (DeferredRegister<?> register : registers) {
            register.register(bus);
        }
    }

    public void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            ComposterBlock.add(1.0F, GDBlocks.INDIGO_MUSHROOM_COLONY.get());
            ComposterBlock.add(1.0F, GDBlocks.VEIL_MUSHROOM_COLONY.get());
            ComposterBlock.add(1.0F, GDBlocks.INK_MUSHROOM_COLONY.get());
            ComposterBlock.add(1.0F, GDBlocks.BLOOD_MUSHROOM_COLONY.get());

            SlingshotItem.registerAmmo(ModItems.ROTTEN_TOMATO.get(), new AbstractSlingshotAmmoBehavior() {
                @Override
                public SlingshotProjectile getProjectile(Level world, BlockPos pos, Player shooter, ItemStack stack) {
                    return new RottenTomato(world, shooter);
                }
            });
        });
    }

    public void clientSetup(FMLClientSetupEvent event) {
        GDClient.registerBlockRenderers();

        ItemProperties.register(UGItems.SLINGSHOT.get(), new ResourceLocation("rotten_tomato"), (stack, level, entity, seed) -> entity != null && entity.getProjectile(stack).is(ModItems.ROTTEN_TOMATO.get()) ? 1.0F : 0.0F);
    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            generator.addProvider(new GDItemModels(generator, helper));

            generator.addProvider(new GDLangUS(generator));
            generator.addProvider(new GDLangGB(generator));
            generator.addProvider(new GDLangCA(generator));
            generator.addProvider(new GDLangAU(generator));
            generator.addProvider(new GDLangNZ(generator));
        }
        if(event.includeServer()) {
            generator.addProvider(new GDRecipes(generator));
            //generator.addProvider(new GDLootTables(generator));
            GDBlockTags blockTags = new GDBlockTags(generator, helper);
            generator.addProvider(blockTags);
            generator.addProvider(new GDItemTags(generator, blockTags, helper));
        }
    }
}