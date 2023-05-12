package com.apples.opitems;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class entities {
    public static class MimicEntity extends PathAwareEntity {
        public MimicEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
            super(entityType, world);
        }
    }

    public class MimicEntityRenderer extends MobEntityRenderer<MimicEntity, MimicEntityModel> {
        public MimicEntityRenderer(EntityRendererFactory.Context context) {
            super(context, new MimicEntityModel(context.getPart(OPItems.MODEL_MIMIC_LAYER)), 0.5f);
        }

        @Override
        public Identifier getTexture(MimicEntity entity) {
            return new Identifier("opitems", "textures/entity/mimic/mimic.png");
        }
    }

    public class MimicEntityModel extends EntityModel<MimicEntity> {

        private static ModelPart mimic;
        private static ModelPartData teeth_r1;
        private static ModelPartData bottom_r1;
        private static ModelPartData top;
        private static ModelPartData top_r1;
        public MimicEntityModel(ModelPart root) {
            this.mimic = root.getChild("mimic");
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData mimic = modelPartData.addChild("mimic", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            teeth_r1 = mimic.addChild("teeth_r1", ModelPartBuilder.create().uv(16, 50).mirrored().cuboid(-6.0F, 1.0F, 1.0F, 12.0F, 2.0F, 12.0F, new Dilation(-0.001F)).mirrored(false), ModelTransform.of(0.0F, -9.0F, 7.0F, 3.1416F, 0.0F, 0.0F));

            bottom_r1 = mimic.addChild("bottom_r1", ModelPartBuilder.create().uv(0, 19).cuboid(-7.0F, -10.0F, -7.0F, 14.0F, 10.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

            top = mimic.addChild("top", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.001F)).mirrored(false)
                    .uv(16, 50).cuboid(-6.0F, 0.0F, -13.0F, 12.0F, 2.0F, 12.0F, new Dilation(-0.001F)), ModelTransform.pivot(0.0F, -9.0F, 7.0F));

            top_r1 = top.addChild("top_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));
            return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(MimicEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

        }
    }
}
