package xaidee.gloompersdelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import quek.undergarden.registry.UGCreativeModeTabs;
import quek.undergarden.registry.UGItems;
import xaidee.gloompersdelight.content.index.*;
import xaidee.gloompersdelight.data.*;
import xaidee.gloompersdelight.data.lang.*;

import java.util.concurrent.CompletableFuture;

@Mod(GloompersDelight.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GloompersDelight {

    public static final String MOD_ID = "gloompersdelight";
    public static final String MOD_NAME = "Gloomper's Delight";
    public static final Logger LOGGER = LogManager.getLogger();

    public GloompersDelight() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

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

        });
    }

    public void clientSetup(FMLClientSetupEvent event) {

    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            generator.addProvider(true, new GDItemModels(output, helper));

            generator.addProvider(true, new GDLangUS(output));
            generator.addProvider(true, new GDLangGB(output));
            generator.addProvider(true, new GDLangCA(output));
            generator.addProvider(true, new GDLangAU(output));
            generator.addProvider(true, new GDLangNZ(output));
        }
        if(event.includeServer()) {
            generator.addProvider(true, new GDRecipes(output));
            //generator.addProvider(new GDLootTables(generator));
            GDBlockTags blockTags = new GDBlockTags(output, provider, helper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new GDItemTags(output, provider, blockTags.contentsGetter(), helper));
        }
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == UGCreativeModeTabs.TAB.getKey()) {
            event.getEntries().putAfter(new ItemStack(UGItems.CLOGGRUM_HOE.get()), new ItemStack(GDItems.CLOGGRUM_KNIFE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(UGItems.FROSTSTEEL_HOE.get()), new ItemStack(GDItems.FROSTSTEEL_KNIFE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(UGItems.UTHERIUM_HOE.get()), new ItemStack(GDItems.UTHERIUM_KNIFE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(new ItemStack(UGItems.FORGOTTEN_HOE.get()), new ItemStack(GDItems.FORGOTTEN_KNIFE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}