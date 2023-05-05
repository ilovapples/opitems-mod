package com.apples.opitems;

import com.mojang.brigadier.ParseResults;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.mojang.brigadier.ParseResults;
import net.minecraft.server.command.ServerCommandSource;

import com.apples.opitems.OPItems;

import javax.swing.*;
import java.util.Objects;

public class blocks {
    public static class Drum extends Block {
        public Drum(Settings settings) {
            super(settings);
        }

        @Override
        public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity placedBy, Hand hand, BlockHitResult blockHitResult) {
            OPItems.LOGGER.info("MAIN HAND: " + placedBy.getMainHandStack().getItem().getTranslationKey());
            OPItems.LOGGER.info("OFF HAND: " + placedBy.getOffHandStack().getItem().getTranslationKey());
            if (Objects.equals(placedBy.getMainHandStack().getItem().getTranslationKey(), "item.opitems.drum_stick") || Objects.equals(placedBy.getOffHandStack().getItem().getTranslationKey(), "item.opitems.drum_stick")) {
//                CommandManager commandManager = placedBy.getServer().getCommandManager();
//                 commandManager.execute(, "playsound opitems:opitems.drum_stick.drum_noise block @s");
                world.playSound(null, blockPos, OPItems.DRUM_SOUND, SoundCategory.BLOCKS, 1f, 1f);
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }
    }
}