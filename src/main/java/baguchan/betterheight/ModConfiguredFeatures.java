package baguchan.betterheight;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> ORE_DEBRIS_UNDER = register(BetterHeight.MODID + ":ore_debris_under", Feature.SCATTERED_ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, Blocks.ANCIENT_DEBRIS.defaultBlockState(), 5, 1.0F)).rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(0)).squared());

	public static void init() {

	}

	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String p_127056_, ConfiguredFeature<FC, ?> p_127057_) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_127056_, p_127057_);
	}
}
