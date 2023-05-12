package com.apples.opitems;

import com.apples.opitems.OPItems;
import com.apples.opitems.entities.*;

@Environment(EnvType.CLIENT)
public class OPItemsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SPONGE_PROJ_LAYER = new EntityModelLayer(new Identifier("opitems", "sponge_projectile"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(OPItems.SPONGE_PROJ_ENTITY, (context) -> {
            return new SpongeProjectileEntityRenderer(context);
        });

        EntityModelLayerRegistry,registerModelLayer(MODEL_SPONGE_PROJ_LAYER, SpongeProjectileEntityModel::getTexturedModelData);
    }
}