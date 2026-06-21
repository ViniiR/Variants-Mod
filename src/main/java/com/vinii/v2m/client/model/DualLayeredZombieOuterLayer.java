package com.vinii.v2m.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.zombie.BabyDrownedModel;
import net.minecraft.client.model.monster.zombie.DrownedModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class DualLayeredZombieOuterLayer extends RenderLayer<ZombieRenderState, DrownedModel> {
    private final Identifier adultLocation;
    private final Identifier babyLocation;
    private final DrownedModel model;
    private final DrownedModel babyModel;

    public DualLayeredZombieOuterLayer(
        RenderLayerParent<ZombieRenderState, DrownedModel> renderLayerParent,
        EntityModelSet entityModelSet,
        String adultLocation,
        String babyLocation
    ) {
        super(renderLayerParent);
        this.model = new DrownedModel(entityModelSet.bakeLayer(ModelLayers.DROWNED_OUTER_LAYER));
        this.babyModel = new BabyDrownedModel(entityModelSet.bakeLayer(ModelLayers.DROWNED_BABY_OUTER_LAYER));
        this.adultLocation = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, adultLocation);
        this.babyLocation = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, babyLocation);
    }

    public void submit(@NonNull PoseStack poseStack, @NonNull SubmitNodeCollector submitNodeCollector, int i, ZombieRenderState zombieRenderState, float f, float g) {
        DrownedModel model = zombieRenderState.isBaby ? this.babyModel : this.model;
        Identifier layerLocation = zombieRenderState.isBaby ? babyLocation : adultLocation;
        coloredCutoutModelCopyLayerRender(model, layerLocation, poseStack, submitNodeCollector, i, zombieRenderState, -1, 1);
    }
}
