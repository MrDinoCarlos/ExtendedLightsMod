package net.mrdino.extendedlightsmod.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.mrdino.extendedlightsmod.ExtendedLightsMod;
import net.mrdino.extendedlightsmod.block.SpotlightBlock;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtendedLightsMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtendedLightsMod.MOD_ID);

    public static final RegistryObject<Block> SPOTLIGHT_BLOCK =
            BLOCKS.register("spotlight_block", SpotlightBlock::new);

    public static final RegistryObject<Item> SPOTLIGHT_BLOCK_ITEM =
            ITEMS.register("spotlight_block", () ->
                    new BlockItem(SPOTLIGHT_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
