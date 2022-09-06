package ca.flawedspirit.fsrandomthings;

import org.jetbrains.annotations.NotNull;

import ca.flawedspirit.fsrandomthings.registry.BlockRegistry;
import ca.flawedspirit.fsrandomthings.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FSRandomThings.MODID)
public class FSRandomThings {
    public static final String MODID = "fsrandomthings";

    public FSRandomThings() {
        IEventBus evbus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEM_REGISTRY.register(evbus);
        BlockRegistry.BLOCK_REGISTRY.register(evbus);
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ItemRegistry.AMETHYST_PRESSURE_PLATE.get().getDefaultInstance();
        }
    };
}
