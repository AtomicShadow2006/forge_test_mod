package net.atomicshadow2006.testmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BuffWandItem extends Item {

    public BuffWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100));
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
            player.setAbsorptionAmount(8);
            player.getCooldowns().addCooldown(this, 300);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Gives user Strength I, Jump Boost I, and Speed II all" +
                    "for 5 seconds, along with 4 Absorption Hearts.\n15 second cooldown")
                    .withStyle(ChatFormatting.GRAY));
        }
        else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(stack, level, components, flag);
    }
}
