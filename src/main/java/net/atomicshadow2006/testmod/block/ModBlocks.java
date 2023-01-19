package net.atomicshadow2006.testmod.block;

import net.atomicshadow2006.testmod.TestMod;
import net.atomicshadow2006.testmod.block.custom.CornCropBlock;
import net.atomicshadow2006.testmod.block.custom.SpedBlock;
import net.atomicshadow2006.testmod.block.custom.TrollLampBlock;
import net.atomicshadow2006.testmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);


    public static final RegistryObject<Block> BLOCK_OF_AMMU = registerBlock("block_of_ammu",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(6f)));
    public static final RegistryObject<Block> BLOCK_OF_SUL = registerBlock("block_of_sul",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE),
                    UniformInt.of(1, 200000)));
    public static final RegistryObject<Block> BLOCK_OF_SHA = registerBlock("block_of_sha",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).instabreak()));


    public static final RegistryObject<Block> SPED_BLOCK = registerBlock("sped_block",
            () -> new SpedBlock(BlockBehaviour.Properties.of(Material.STONE).friction(0.25f)
                    .requiresCorrectToolForDrops().strength(6f)));
    public static final RegistryObject<Block> TROLL_LAMP = registerBlock("troll_lamp",
            () -> new TrollLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .lightLevel(state -> state.getValue(TrollLampBlock.LIT) ? 15 : 0)
                    .requiresCorrectToolForDrops().strength(6f)));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(64)));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
