package com.apples.opitems;

import com.apples.opitems.OPItems;
import com.apples.opitems.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class OPItemsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SPONGE_PROJ_LAYER = new EntityModelLayer(new Identifier("opitems", "sponge_projectile"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(OPItems.SPONGE_PROJ_ENTITY, (context) -> {
            return new SpongeProjectileEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_SPONGE_PROJ_LAYER, SpongeProjectileEntityModel::getTexturedModelData);
    }
}