package xaidee.gloompersdelight;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xaidee.gloompersdelight.content.index.*;
import xaidee.gloompersdelight.data.*;
import xaidee.gloompersdelight.data.lang.*;

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
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            generator.addProvider(true, new GDItemModels(generator, helper));

            generator.addProvider(true, new GDLangUS(generator));
            generator.addProvider(true, new GDLangGB(generator));
            generator.addProvider(true, new GDLangCA(generator));
            generator.addProvider(true, new GDLangAU(generator));
            generator.addProvider(true, new GDLangNZ(generator));
        }
        if(event.includeServer()) {
            generator.addProvider(true, new GDRecipes(generator));
            //generator.addProvider(new GDLootTables(generator));
            GDBlockTags blockTags = new GDBlockTags(generator, helper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new GDItemTags(generator, blockTags, helper));
        }
    }
}