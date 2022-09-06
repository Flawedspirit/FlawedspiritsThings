package ca.flawedspirit.fsrandomthings.registry;

import ca.flawedspirit.fsrandomthings.FSRandomThings;
import ca.flawedspirit.fsrandomthings.block.AmethystPressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FSRandomThings.MODID);

    // Begin registration of mod blocks
    public static final RegistryObject<Block> AMETHYST_PRESSURE_PLATE = BLOCK_REGISTRY.register("amethyst_pressure_plate", () -> new AmethystPressurePlateBlock());
}
