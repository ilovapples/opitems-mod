package com.apples.opitems;

import com.apples.opitems.OPItemsClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class entities {
    public class SpongeProjectileEntity extends PathAwareEntity {
        public SpongeProjectileEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
            super(entityType, world);
        }


    }

    public static class SpongeProjectileEntityRenderer extends MobEntityRenderer<SpongeProjectileEntity, SpongeProjectileEntityModel> {
        public SpongeProjectileEntityRenderer(EntityRendererFactory.Context context) {
            super(context, new SpongeProjectileEntityModel(context.getPart(OPItemsClient.MODEL_SPONGE_PROJ_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(SpongeProjectileEntity entity) {
            return new Identifier("opitems", "textures/entity/sponge_proj/sponge_proj.png");
        }
    }

    public class SpongeProjectileEntityModel extends EntityModel<SpongeProjectileEntity> {
        private final ModelPart base;

        public SpongeProjectileEntityModel(ModelPart modelPart) {
            this.base = modelPart.getChild(EntityModelPartNames.CUBE);
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0, 0).cuboid(-6.0f, 12.0f, -6.0f, 12.0f, 12.0f, 12.0f), ModelTransform.pivot(0.0f, 0.0f, 0.0f));
        }

        @Override
        public void setAngles(SpongeProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
            ImmutableList.of(this.base).forEach((modelRenderer) -> {
                modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            });
        }
    }
}