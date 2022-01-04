package baguchan.betterheight;

import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModConfiguredFeatures {
	public static final PlacedFeature ORE_ANCIENT_DEBRIS_UNDER_LARGE = PlacementUtils.register("betterheight:ore_ancient_debris_under_large", OreFeatures.ORE_ANCIENT_DEBRIS_LARGE.placed(InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)), BiomeFilter.biome()));
	public static final List<PlacementModifier> FIRE_PLACEMENT = List.of(CountPlacement.of(UniformInt.of(0, 6)), InSquarePlacement.spread(), PlacementUtils.RANGE_4_4, BiomeFilter.biome());

	public static final PlacedFeature PATCH_SOUL_FIRE = PlacementUtils.register("betterheight:patch_soul_fire", NetherFeatures.PATCH_SOUL_FIRE.placed(FIRE_PLACEMENT));
	public static final PlacedFeature PATCH_FIRE = PlacementUtils.register("betterheight:patch_fire", NetherFeatures.PATCH_FIRE.placed(FIRE_PLACEMENT));


	public static void init() {

	}
}
