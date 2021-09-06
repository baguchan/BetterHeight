package baguchan.betterheight;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Carvers;
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

			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD))
				if (event.getGeneration().getCarvers(GenerationStep.Carving.AIR).stream().anyMatch(carver -> {
					return carver.get() == Carvers.CANYON;
				})) {
					event.getGeneration().getCarvers(GenerationStep.Carving.AIR).removeIf(caver -> caver.get() == Carvers.CANYON);
				}

			if (event.getGeneration().getCarvers(GenerationStep.Carving.AIR).stream().anyMatch(carver -> {
				return carver.get() == Carvers.CAVE;
			})) {
				event.getGeneration().getCarvers(GenerationStep.Carving.AIR).removeIf(caver -> caver.get() == Carvers.CAVE);

				event.getGeneration().addCarver(GenerationStep.Carving.AIR, Carvers.PROTOTYPE_CAVE);
				event.getGeneration().addCarver(GenerationStep.Carving.AIR, Carvers.PROTOTYPE_CANYON);
				event.getGeneration().addCarver(GenerationStep.Carving.AIR, Carvers.PROTOTYPE_CREVICE);
			}
		}
	}
}
