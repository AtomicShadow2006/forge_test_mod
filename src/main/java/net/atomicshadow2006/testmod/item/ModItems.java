package net.atomicshadow2006.testmod.item;

import net.atomicshadow2006.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> SHA = ITEMS.register("sha",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> AMMU = ITEMS.register("ammu",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> SUL = ITEMS.register("sul",
            () -> new Item(new Item.Properties().stacksTo(64)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
