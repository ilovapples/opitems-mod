package com.apples.opitems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.FallingBlockEntity;
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
    
    public static class RawBlazeCore extends Item {
        public RawBlazeCore(Settings settings) {
            super(settings);
        }
        
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.raw_blaze_core.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.raw_blaze_core.tooltip1"));
        }
    }
    
    public static class RefinedBlazeCore extends Item {
        public RefinedBlazeCore(Settings settings) {
            super(settings);
        }
        
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.refined_blaze_core.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.refined_blaze_core.tooltip1"));
        }
    }
    
    public static class BlazeCoreResidue extends Item {
        public BlazeCoreResidue(Settings settings) {
            super(settings);
        }
        
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.blaze_core_residue.tooltip0"));
            tooltip.add(Text.translatable("item.opitems.blaze_core_residue.tooltip1"));
        }
    }

    public static class SpongePistol extends Item {
        public SpongePistol(Settings settings) {
            super(settings);
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
            playerEntity.playSound(SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.PLAYERS, 1, 1);
            FallingBlockEntity sponge_block = new FallingBlockEntity(EntityType.FALLING_BLOCK, world);
            sponge_block.teleport(playerEntity.getX(), playerEntity.getY()+1, playerEntity.getZ());
            sponge_block.setVelocity(playerEntity.getRotationVector());
            sponge_block.setCustomName(Text.of("sponge_pistol_proj"));
            sponge_block.setCustomNameVisible(false);
            world.spawnEntity(sponge_block);

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.sponge_pistol.tooltip0"));
        }
    }

    public static class SpongeAK extends Item {
        public SpongeAK(Settings settings) {
            super(settings);
        }

        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
            playerEntity.playSound(SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.PLAYERS, 1, 1);
            FallingBlockEntity sponge_block = new FallingBlockEntity(EntityType.FALLING_BLOCK, world);
            sponge_block.teleport(playerEntity.getX(), playerEntity.getY()+1, playerEntity.getZ());
            sponge_block.setVelocity(playerEntity.getRotationVector().multiply(2));
            sponge_block.setCustomName(Text.of("sponge_pistol_proj"));
            sponge_block.setCustomNameVisible(false);
            world.spawnEntity(sponge_block);

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }


        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.sponge_ak.tooltip0"));
        }
    }

    public static class SpongeKatana extends Item {
        public SpongeKatana(Settings settings) {
            super(settings);
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(Text.translatable("item.opitems.sponge_katana.tooltip0"));
        }
    }
}
