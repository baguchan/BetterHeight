package baguchan.betterheight;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
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
				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.ORE_ANCIENT_DEBRIS_UNDER_LARGE);

				event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.PATCH_FIRE);
				if (biome == Biomes.SOUL_SAND_VALLEY) {
					event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModConfiguredFeatures.PATCH_SOUL_FIRE);
				}
			}
		}
	}
}
