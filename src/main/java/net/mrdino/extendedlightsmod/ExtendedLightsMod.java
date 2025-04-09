package net.mrdino.extendedlightsmod;

import com.mojang.logging.LogUtils;
import net.mrdino.extendedlightsmod.registry.ModBlocks;
import net.mrdino.extendedlightsmod.registry.ModBlockEntities;
import net.mrdino.extendedlightsmod.registry.ModCreativeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(ExtendedLightsMod.MOD_ID)
public class ExtendedLightsMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "extendedlightsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Aquí inicializamos el bus de eventos correctamente dentro del constructor
    public ExtendedLightsMod() {
        // Accedemos al modEventBus a través de FMLJavaModLoadingContext
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registra los bloques, entidades y demás componentes
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Añadimos los listeners necesarios
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Registra el mod en el bus de eventos de Minecraft
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Setup común del mod
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Añade ítems a la pestaña creativa
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Acciones que deben ocurrir cuando el servidor arranque
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Setup del cliente si es necesario
        }
    }
}
