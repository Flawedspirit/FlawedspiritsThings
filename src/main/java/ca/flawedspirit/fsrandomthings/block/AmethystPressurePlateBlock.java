package ca.flawedspirit.fsrandomthings.block;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;

public class AmethystPressurePlateBlock extends PressurePlateBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final PressurePlateBlock.Sensitivity sensitivity;

    public AmethystPressurePlateBlock() {
        super(Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.AMETHYST)
            .color(MaterialColor.COLOR_MAGENTA)
            .sound(SoundType.AMETHYST)
            .requiresCorrectToolForDrops()
            .noCollission()
            .strength(1.5f, 1.5f)
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.valueOf(false)));
        this.sensitivity = Sensitivity.MOBS;
    }

    @Override
    protected int getSignalStrength(Level level, BlockPos pos) {
        AABB aabb = TOUCH_AABB.move(pos);
        List<? extends Entity> list;

        switch(this.sensitivity) {
            case MOBS:
                list = level.getEntitiesOfClass(LivingEntity.class, aabb);
                break;
            default:
                return 0;
        }

        if(!list.isEmpty()) {
            for(Entity entity : list) {
                if(entity instanceof Player && !entity.isIgnoringBlockTriggers()) {
                    return 15;
                }
            }
        }

        return 0;
    }
}
