package baguchan.betterheight;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterHeight.MODID)
public class CaveEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void caveEventHandler(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if (event.getName() != null) {
			ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());

			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)) {
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_DEBRIS_UNDER);
			}

			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_COAL_UPPER);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_COAL_LOWER);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_IRON_UPPER);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_IRON_MIDDLE);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_IRON_SMALL);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_GOLD);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_EMERALD);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_LAPIS);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_LAPIS_BURIED);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_REDSTONE);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_REDSTONE_LOWER);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_COPPER);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_DIAMOND);
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Features.PROTOTYPE_ORE_DIAMOND_LARGE);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public static void caveRemoveEventHandler(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if (event.getName() != null) {
			ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());

			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_COAL;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_IRON;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_GOLD;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_EMERALD;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_LAPIS;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_REDSTONE;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_COPPER;
				});
				event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).removeIf(featureSupplier -> {
					return featureSupplier.get() == Features.ORE_DIAMOND;
				});
			}

		}
	}
}
