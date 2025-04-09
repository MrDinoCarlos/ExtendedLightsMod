package net.mrdino.extendedlightsmod.registry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

import net.mrdino.extendedlightsmod.ExtendedLightsMod;
import net.mrdino.extendedlightsmod.registry.ModBlocks;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtendedLightsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXTENDED_LIGHTS_TAB =
            TABS.register("extended_lights_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SPOTLIGHT_BLOCK_ITEM.get()))
                    .title(Component.literal("Extended Lights"))
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.SPOTLIGHT_BLOCK_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
