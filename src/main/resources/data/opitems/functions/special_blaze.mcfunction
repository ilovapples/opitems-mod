playsound minecraft:entity.blaze.shoot ambient @a[distance=..20]
playsound minecraft:block.anvil.land ambient @a[distance=..20]
summon minecraft:blaze ~ ~ ~ {Tags:["blaze_god"],CustomName:'[{"text":"🔥 Blaze God 🔥","color":"gold"}]',CustomNameVisible:1b,Health:50,DeathLootTable:"opitems:entities/blaze_god",HasVisualFire:1b,PersistenceRequired:1b,Attributes:[{Name:"generic.attack_damage",Base:5f},{Name:"generic.knockback_resistance",Base:0.6f},{Name:"generic.max_health",Base:50f}]}
execute at @e[tag=blaze_god] run kill @e[type=item,distance=..1,nbt={Item:{id:"minecraft:nether_star",Count:1b}}]
execute at @e[tag=blaze_god] run kill @e[type=item,distance=..1,nbt={Item:{id:"minecraft:netherite_ingot",Count:5b}}]
execute at @e[tag=blaze_god] run kill @e[type=item,distance=..1,nbt={Item:{id:"minecraft:blaze_rod",Count:16b}}]
execute at @e[tag=blaze_god] run kill @e[type=item,distance=..1,nbt={Item:{id:"minecraft:diamond_block",Count:4b}}]