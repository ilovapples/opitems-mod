package com.apples.opitems;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.apples.opitems.OPItems;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

public class blocks {
    public static class DrumBlockEntity extends BlockEntity {
        private static float pitch = 0.50f;
        private static int ticksPowered = 0;

        public DrumBlockEntity(BlockPos pos, BlockState state) {
            super(OPItems.DRUM_BLOCK_ENTITY, pos, state);
        }

        public static void tick(World world, BlockPos pos, BlockState state, DrumBlockEntity be) {
            if (!world.isReceivingRedstonePower(pos)) {
                ticksPowered = 0;
            } else {
                if (ticksPowered <= 1) {
                    world.playSound(null, pos, OPItems.DRUM_SOUND, SoundCategory.BLOCKS, 1f, pitch);
                }
                ticksPowered++;
            }
        }

        @Override
        public void writeNbt(NbtCompound nbt) {
            nbt.putFloat("drum_pitch", pitch);

            super.writeNbt(nbt);
        }

        @Override
        public void readNbt(NbtCompound nbt) {
            super.readNbt(nbt);

            pitch = nbt.getFloat("drum_pitch");
        }

        @Nullable
        @Override
        public Packet<ClientPlayPacketListener> toUpdatePacket() {
            return BlockEntityUpdateS2CPacket.create(this);
        }

        @Override
        public NbtCompound toInitialChunkDataNbt() {
            return createNbt();
        }
    }

    public static class Drum extends BlockWithEntity implements BlockEntityProvider {
        public float pitch = 0.50f;

        public Drum(Settings settings) {
            super(settings);
        }

        @Override
        public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity placedBy, Hand hand, BlockHitResult blockHitResult) {
            OPItems.LOGGER.info("MAIN HAND: " + placedBy.getMainHandStack().getItem().getTranslationKey());
            OPItems.LOGGER.info("OFF HAND: " + placedBy.getOffHandStack().getItem().getTranslationKey());
            if (Objects.equals(placedBy.getMainHandStack().getItem().getTranslationKey(), "item.opitems.drum_stick")
             || Objects.equals(placedBy.getOffHandStack().getItem().getTranslationKey(), "item.opitems.drum_stick")) {
                
                world.playSound(null, blockPos, OPItems.DRUM_SOUND, SoundCategory.BLOCKS, 1f, pitch);
                return ActionResult.SUCCESS;
            } else if (
                Objects.equals(
                    placedBy.getMainHandStack().getItem().getTranslationKey(), "item.opitems.drum_tuner")
             || Objects.equals(
                placedBy.getOffHandStack().getItem().getTranslationKey(), "item.opitems.drum_tuner")) {

                pitch += 0.05f;
                if (pitch >= 1.20f) {
                    pitch = 0.20f;
                }
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.PASS;
            }
        }

        @Override
        public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
            return new DrumBlockEntity(pos, state);
        }

        @Override
        public BlockRenderType getRenderType(BlockState state) {
            return BlockRenderType.MODEL;
        }
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
            return checkType(type, OPItems.DRUM_BLOCK_ENTITY, DrumBlockEntity::tick);
        }
    }
}
