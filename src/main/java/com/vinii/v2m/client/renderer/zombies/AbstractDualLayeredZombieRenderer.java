package com.vinii.v2m.client.renderer.zombies;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.client.model.DualLayeredZombieOuterLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.zombie.BabyDrownedModel;
import net.minecraft.client.model.monster.zombie.DrownedModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public abstract class AbstractDualLayeredZombieRenderer<T extends Zombie> extends AbstractZombieRenderer<T, ZombieRenderState, DrownedModel> {
    private final Identifier adultPath;
    private final Identifier babyPath;

    public AbstractDualLayeredZombieRenderer(
        EntityRendererProvider.Context context,
        String adultPath,
        String babyPath,
        String adultOuterLayerPath,
        String babyOuterLayerPath
    ) {
        super(
            context,
            new DrownedModel(context.bakeLayer(ModelLayers.DROWNED)),
            new BabyDrownedModel(context.bakeLayer(ModelLayers.DROWNED_BABY)),
            ArmorModelSet.bake(ModelLayers.DROWNED_ARMOR, context.getModelSet(), DrownedModel::new),
            ArmorModelSet.bake(ModelLayers.DROWNED_BABY_ARMOR, context.getModelSet(), BabyDrownedModel::new)
        );
        this.addLayer(new DualLayeredZombieOuterLayer(this, context.getModelSet(), adultOuterLayerPath, babyOuterLayerPath));
        this.adultPath = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, adultPath);
        this.babyPath = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, babyPath);
    }

    @Override
    public @NonNull Identifier getTextureLocation(ZombieRenderState zombieRenderState) {
        return zombieRenderState.isBaby ? babyPath : adultPath;
    }

    public ZombieRenderState createRenderState() {
        return new ZombieRenderState();
    }
}
