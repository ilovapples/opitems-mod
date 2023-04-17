package com.apples.opitems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class enchantments {
    public static class PoisonTipped extends Enchantment {
        public PoisonTipped() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 10;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if(target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2 * level, level));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    public static class FrostTipped extends Enchantment {
        public FrostTipped() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 10;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if(target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    public static class WitherTipped extends Enchantment {
        public WitherTipped() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 10;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if(target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 2 * level, level));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    /*public static class InvisHit extends Enchantment {
        public InvisHit() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 1;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            user.addStatusEffect(

            super.onTargetDamaged(user, target, level);
        }
    }*/
}
