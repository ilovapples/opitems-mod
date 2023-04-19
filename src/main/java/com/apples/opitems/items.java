package com.apples.opitems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class items {
    public static class KnockbackStick extends Item {
        public KnockbackStick(Settings settings) {
            super(settings);
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

            // default white text
            tooltip.add(Text.translatable("item.opitems.knockback_stick.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.knockback_stick.tooltip1"));
            tooltip.add(Text.translatable("item.opitems.knockback_stick.tooltip2"));

        }
    }

    public static class BetterKnockbackStick extends KnockbackStick {
        public BetterKnockbackStick(Settings settings) {
            super(settings);
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

            tooltip.add(Text.translatable("item.opitems.better_knockback_stick.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.better_knockback_stick.tooltip1"));
            tooltip.add(Text.translatable("item.opitems.better_knockback_stick.tooltip2"));
            tooltip.add(Text.translatable("item.opitems.better_knockback_stick.tooltip3"));
        }
    }

    public static class FireStick extends KnockbackStick {
        public FireStick(Settings settings) {
            super(settings);
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.fire_stick.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.fire_stick.tooltip1"));
            tooltip.add(Text.translatable("item.opitems.fire_stick.tooltip2"));
        }
    }
}
