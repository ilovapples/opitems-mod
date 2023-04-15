package com.apples.opitems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.apples.opitems.KnockbackSticks.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class OPItems implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("opitems");

	// create
	public final KnockbackStick KNOCKBACK_STICK = new KnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.RARE));

	public final BetterKnockbackStick BETTER_KNOCKBACK_STICK = new BetterKnockbackStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC)
			.fireproof());
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("ilovapples' OP Items Mod has been successfully initialized!");
		Registry.register(Registries.ITEM, new Identifier("opitems", "knockback_stick"), KNOCKBACK_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "better_knockback_stick"), BETTER_KNOCKBACK_STICK);
	}
}