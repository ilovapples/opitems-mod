package com.apples.opitems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.apples.opitems.items.*;
import com.apples.opitems.blocks.*;
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

	
	// Fire Stick items: Fire Stick, Raw Blaze Core, Refined Blaze Core
	public static final FireStick FIRE_STICK = new FireStick(new FabricItemSettings()
			.maxCount(1)
			.rarity(Rarity.EPIC)
			.fireproof());
	
	/*
	Refined Blaze Core:
		Used to craft the Fire Stick, among other things.
		Does nothing by itself.
	*/
	public static final RefinedBlazeCore REFINED_BLAZE_CORE = new RefinedBlazeCore(new FabricItemSettings()
			.rarity(Rarity.EPIC)
			.fireproof());
	// residue left over after refining raw blaze cores
	public static final BlazeCoreResidue BLAZE_CORE_RESIDUE = new BlazeCoreResidue(new FabricItemSettings()
			.rarity(Rarity.UNCOMMON)
			.fireproof());
	/*
	Raw Blaze Core:
		Dropped from Blazes with a 1.25% chance.
		Combine with Netherite Scrap in Smithing Table to get Refined Blaze Core (OR with a diamond and netherite scrap in a crafting table)
	*/
	public static final RawBlazeCore RAW_BLAZE_CORE = new RawBlazeCore(new FabricItemSettings()
			.rarity(Rarity.RARE)
			.fireproof()
			.recipeRemainder(BLAZE_CORE_RESIDUE));

	public static final Item YEET_BALL = new Item(new FabricItemSettings()
			.maxCount(1));
	// placeholders for crafting (it looks better like this I promise)
	public final BetterKnockbackStick PLACEHOLDER_BETTER = new BetterKnockbackStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));

	public final KnockbackStick PLACEHOLDER_NORMAL = new KnockbackStick(new FabricItemSettings()
			.rarity(Rarity.RARE));

	public final FireStick PLACEHOLDER_FIRE = new FireStick(new FabricItemSettings()
			.rarity(Rarity.EPIC));

	public static final Item DRUM_STICK = new Item(new FabricItemSettings()
			.maxCount(1));

	public static final Item DRUM_TUNER = new Item(new FabricItemSettings()
		    .maxCount(1));

	public static PoisonTipped POISON_TIPPED = new PoisonTipped();
	public static FrostTipped FROST_TIPPED = new FrostTipped();
	public static WitherTipped WITHER_TIPPED = new WitherTipped();
	public static WeaknessTipped WEAKNESS_TIPPED = new WeaknessTipped();
	public static InvisHit INVIS_HIT = new InvisHit();
	public static OPEnch OP_ENCH = new OPEnch();

	public static final Drum DRUM_BLOCK = new Drum(FabricBlockSettings
			.of(Material.BAMBOO)
			.noBlockBreakParticles()
			.sounds(BlockSoundGroup.BAMBOO)
			.strength(1.0f));
	public static final BlockEntityType<DrumBlockEntity> DRUM_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier("opitems", "drum_block_entity"),
			FabricBlockEntityTypeBuilder.create(blocks.DrumBlockEntity::new, DRUM_BLOCK).build()
	);
	public static SoundEvent DRUM_SOUND = SoundEvent.of(new Identifier("opitems", "drum.drum_noise"));

	public static final SpongePistol SPONGE_PISTOL = new SpongePistol(new FabricItemSettings()
			.maxCount(1));
	public static final SpongeAK SPONGE_AK = new SpongeAK(new FabricItemSettings()
			.maxCount(1));
	public static final SpongeKatana SPONGE_KATANA = (SpongeKatana)((Item)(new SwordItem(ToolMaterials.NETHERITE, 15, 50.0f, new FabricItemSettings().maxDamage(10000))));
	
	ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("opitems", "op_items_group"))
    	.displayName(Text.literal("OPItems Group"))
    	.icon(() -> new ItemStack(FIRE_STICK))
    	.entries((enabledFeatures, entries, operatorEnabled) -> {
        	entries.add(KNOCKBACK_STICK);
			entries.add(BETTER_KNOCKBACK_STICK);
			entries.add(FIRE_STICK);
			entries.add(RAW_BLAZE_CORE);
			entries.add(REFINED_BLAZE_CORE);
			entries.add(DRUM_BLOCK);
			entries.add(DRUM_STICK);
			entries.add(DRUM_TUNER);
			entries.add(SPONGE_PISTOL);
			entries.add(SPONGE_AK);
			entries.add(SPONGE_KATANA);
    	})
    	.build();
	
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
		Registry.register(Registries.ITEM, new Identifier("opitems", "blaze_core_residue"), BLAZE_CORE_RESIDUE);
		Registry.register(Registries.ITEM, new Identifier("opitems", "yeet_ball"), YEET_BALL);
		Registry.register(Registries.ITEM, new Identifier("opitems", "drum_stick"), DRUM_STICK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "sponge_pistol"), SPONGE_PISTOL);
		Registry.register(Registries.ITEM, new Identifier("opitems", "sponge_ak"), SPONGE_AK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "sponge_katana"), SPONGE_KATANA);


		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_better"), PLACEHOLDER_BETTER);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_normal"), PLACEHOLDER_NORMAL);
		Registry.register(Registries.ITEM, new Identifier("opitems", "placeholder_fire"), PLACEHOLDER_FIRE);

		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "poison_tipped"), POISON_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "frost_tipped"), FROST_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "wither_tipped"), WITHER_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "weakness_tipped"), WEAKNESS_TIPPED);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "invis_hit"), INVIS_HIT);
		Registry.register(Registries.ENCHANTMENT, new Identifier("opitems", "op_ench"), OP_ENCH);

		Registry.register(Registries.BLOCK, new Identifier("opitems", "drum"), DRUM_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("opitems", "drum"), new BlockItem(DRUM_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.SOUND_EVENT, new Identifier("opitems", "drum.drum_noise"), DRUM_SOUND);
		Registry.register(Registries.ITEM, new Identifier("opitems", "drum_tuner"), DRUM_TUNER);

		FuelRegistry.INSTANCE.add(BLAZE_CORE_RESIDUE, 10000);
	}
}
