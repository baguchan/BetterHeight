package baguchan.betterheight;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModConfiguredFeatures {
	public static final PlacedFeature ORE_ANCIENT_DEBRIS_UNDER_LARGE = PlacementUtils.register("betterheight:ore_ancient_debris_under_large", OreFeatures.ORE_ANCIENT_DEBRIS_LARGE.placed(InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)), BiomeFilter.biome()));

	public static void init() {

	}
}
