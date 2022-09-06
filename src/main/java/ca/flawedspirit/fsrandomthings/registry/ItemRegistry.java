package ca.flawedspirit.fsrandomthings.registry;

import ca.flawedspirit.fsrandomthings.FSRandomThings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FSRandomThings.MODID);

    // Begin registration of mod objects
    public static final RegistryObject<BlockItem> AMETHYST_PRESSURE_PLATE = ITEM_REGISTRY.register("amethyst_pressure_plate",
        () -> new BlockItem(BlockRegistry.AMETHYST_PRESSURE_PLATE.get(), props()));

    // Common properties shared between all basic items
    private static Item.Properties props() {
        return new Item.Properties().tab(FSRandomThings.TAB);
    }
}
