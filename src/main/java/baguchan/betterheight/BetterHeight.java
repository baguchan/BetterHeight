package baguchan.betterheight;

import com.google.common.collect.Maps;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Optional;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterHeight.MODID)
public class BetterHeight {
    public static final String MODID = "betterheight";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    public BetterHeight() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModConfiguredFeatures.init();
        register(NoiseGeneratorSettings.NETHER, netherLikePreset(new StructureSettings(false), Blocks.NETHERRACK.defaultBlockState(), Blocks.LAVA.defaultBlockState()));
    }

    public static NoiseGeneratorSettings netherLikePreset(StructureSettings p_158554_, BlockState p_158555_, BlockState p_158556_) {
        Map<StructureFeature<?>, StructureFeatureConfiguration> map = Maps.newHashMap(NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig());
        map.put(StructureFeature.RUINED_PORTAL, new StructureFeatureConfiguration(25, 10, 34222645));
        return new NoiseGeneratorSettings(new StructureSettings(Optional.empty(), map), NoiseSettings.create(-64, 256, new NoiseSamplingSettings(1.0D, 3.0D, 80.0D, 60.0D), new NoiseSlider(0.9375D, 3, 0), new NoiseSlider(2.5D, 8, -1), 1, 2, false, false, false, TerrainProvider.nether()), Blocks.NETHERRACK.defaultBlockState(), Blocks.LAVA.defaultBlockState(), SurfaceRuleData.nether(), 32, false, false, false, false, false, true);
    }


    public static NoiseGeneratorSettings register(ResourceKey<NoiseGeneratorSettings> p_64479_, NoiseGeneratorSettings p_64480_) {
        BuiltinRegistries.register(BuiltinRegistries.NOISE_GENERATOR_SETTINGS, p_64479_.location(), p_64480_);
        return p_64480_;
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }
}
