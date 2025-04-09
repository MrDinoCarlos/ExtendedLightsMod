package net.mrdino.extendedlightsmod.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.mrdino.extendedlightsmod.block.SpotlightBlock;
import net.mrdino.extendedlightsmod.blockentity.SpotlightBlockEntity;
import net.mrdino.extendedlightsmod.ExtendedLightsMod;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExtendedLightsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SpotlightBlockEntity>> SPOTLIGHT_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("spotlight_block_entity", () ->
                    BlockEntityType.Builder.of(SpotlightBlockEntity::new, ModBlocks.SPOTLIGHT_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
