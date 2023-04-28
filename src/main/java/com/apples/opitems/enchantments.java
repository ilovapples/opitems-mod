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
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2 * level, level, false, false, false));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    public static class FrostTipped extends Enchantment {
        public FrostTipped() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level, false, false, false));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    public static class WitherTipped extends Enchantment {
        public WitherTipped() {
            super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 2 * level, level, false, false, false));
            }

            super.onTargetDamaged(user, target, level);
        }
    }

    public static class WeaknessTipped extends Enchantment {
        public WeaknessTipped() {
            super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 2 * level, level, false, false, false));
            }

            super.onTargetDamaged(user, target, level);
        }
    }
    
    public static class InvisHit extends Enchantment {
        public InvisHit() {
            super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }
        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }
        
        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20 * 2 * level, level, false, false, false));

            super.onTargetDamaged(user, target, level);
        }
    }


    public static class OPEnch extends Enchantment {
        public OPEnch() {
            super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
        }

        @Override
        public int getMinPower(int level) {
            return 1;
        }

        @Override
        public int getMaxLevel() {
            return 15;
        }

        @Override
        public void onTargetDamaged(LivingEntity user, Entity target, int level) {
            if (target instanceof LivingEntity) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 2 * level, level, false, false, false));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2 * level, level, false, false, false));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level, false, false, false));
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 2 * level, level, false, false, false));
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20 * 2 * level, level, false, false, true));
        }
    }
}