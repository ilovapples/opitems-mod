package com.apples.opitems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.apples.opitems.items.*;
import com.apples.opitems.enchantments.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class OPItems implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("opitems");

	// create
	public final KnockbackStick KNOCKBACK_STICK = new KnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.RARE));

	public static final BetterKnockbackStick BETTER_KNOCKBACK_STICK = new BetterKnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC));

	public static final FireStick FIRE_STICK = new FireStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC)
			.fireproof());
	
	public static final RawBlazeCore RAW_BLAZE_CORE = new RawBlazeCore(new FabricItemSettings()
			.rarity(Rarity.RARE)
			.fireproof());
	
	public static final RefinedBlazeCore REFINED_BLAZE_CORE = new RefinedBlazeCore(new FabricItemSettings()
			.rarity(Rarity.EPIC)
			.fireproof());


	// placeholder for crafting
	public final BetterKnockbackStick PLACEHOLDER_BETTER = new BetterKnockbackStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));

	public final KnockbackStick PLACEHOLDER_NORMAL = new KnockbackStick(new FabricItemSettings()
			.rarity(Rarity.RARE));

	public final KnockbackStick PLACEHOLDER_FIRE = new KnockbackStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));


	public static Enchantment POISON_TIPPED = new PoisonTipped();
	public static Enchantment FROST_TIPPED = new FrostTipped();
	public static Enchantment WITHER_TIPPED = new WitherTipped();
	public static Enchantment WEAKNESS_TIPPED = new WeaknessTipped();
	public static Enchantment INVIS_HIT = new InvisHit();
	public static Enchantment OP_ENCH = new OPEnch();

	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("ilovapples' OP Items Mod has been successfully initialized!");
		Registry.register(Registries.ITEM, new Identifier("opitems", "knockback_stick"), KNOCKBACK_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "better_knockback_stick"), BETTER_KNOCKBACK_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "fire_stick"), FIRE_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "raw_blaze_core"), RAW_BLAZE_CORE); 
		Registry.register(Registries.ITEM, new Identifier("opitems", "refined_blaze_core"), REFINED_BLAZE_CORE); 

		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_better"), PLACEHOLDER_BETTER);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_normal"), PLACEHOLDER_NORMAL);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_fire"), PLACEHOLDER_FIRE);

		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "poison_tipped"), POISON_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "frost_tipped"), FROST_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "wither_tipped"), WITHER_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "weakness_tipped"), WEAKNESS_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "invis_hit"), INVIS_HIT);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "op_ench"), OP_ENCH);
	}
}
