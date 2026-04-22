package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.client.model.IcidOuterLayer;
import com.vinii.v2m.entity.entities.Icid;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.zombie.DrownedModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;

@Environment(EnvType.CLIENT)
public class IcidRenderer extends AbstractZombieRenderer<Icid, ZombieRenderState, DrownedModel> {
    private static final Identifier ICID_LOCATION = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/zombie/icid.png");

    public IcidRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            new DrownedModel(context.bakeLayer(ModelLayers.DROWNED)),
            new DrownedModel(context.bakeLayer(ModelLayers.DROWNED_BABY)),
            ArmorModelSet.bake(ModelLayers.DROWNED_ARMOR, context.getModelSet(), DrownedModel::new),
            ArmorModelSet.bake(ModelLayers.DROWNED_BABY_ARMOR, context.getModelSet(), DrownedModel::new)
        );
        this.addLayer(new IcidOuterLayer(this, context.getModelSet()));
    }

    @Override
    public Identifier getTextureLocation(ZombieRenderState zombieRenderState) {
        return ICID_LOCATION;
    }

    @Override
    public ZombieRenderState createRenderState() {
        return new ZombieRenderState();
    }
}
