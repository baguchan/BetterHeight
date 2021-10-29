package baguchan.betterheight;

import com.google.common.collect.Maps;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
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
        register(NoiseGeneratorSettings.OVERWORLD, newOverworld(new StructureSettings(true), false));
        register(NoiseGeneratorSettings.NETHER, netherLikePreset(new StructureSettings(false), Blocks.NETHERRACK.defaultBlockState(), Blocks.LAVA.defaultBlockState()));
        register(NoiseGeneratorSettings.CAVES, netherLikePreset(new StructureSettings(true), Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState()));
    }

    public static NoiseGeneratorSettings newOverworld(StructureSettings p_158564_, boolean p_158565_) {
        double d0 = 0.9999999814507745D;
        Map<StructureFeature<?>, StructureFeatureConfiguration> map = Maps.newHashMap(NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig());

        return new NoiseGeneratorSettings(new StructureSettings(Optional.ofNullable(p_158564_.stronghold()), map), NoiseSettings.create(-64, 384, new NoiseSamplingSettings(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new NoiseSlideSettings(-10, 3, 0), new NoiseSlideSettings(15, 3, 0), 1, 2, 1.0D, -0.46875D, true, true, false, p_158565_), Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(), Integer.MIN_VALUE, 0, 63, 0, true, true, true, true, true, true);
    }

    public static NoiseGeneratorSettings netherLikePreset(StructureSettings p_158554_, BlockState p_158555_, BlockState p_158556_) {
        Map<StructureFeature<?>, StructureFeatureConfiguration> map = Maps.newHashMap(NoiseGeneratorSettings.bootstrap().structureSettings().structureConfig());
        map.put(StructureFeature.RUINED_PORTAL, new StructureFeatureConfiguration(25, 10, 34222645));
        return new NoiseGeneratorSettings(new StructureSettings(Optional.ofNullable(p_158554_.stronghold()), map), NoiseSettings.create(-64, 256, new NoiseSamplingSettings(1.0D, 3.0D, 80.0D, 60.0D), new NoiseSlideSettings(120, 3, 0), new NoiseSlideSettings(320, 8, -1), 1, 2, 0.0D, 0.019921875D, false, false, false, false), p_158555_, p_158556_, 0, 0, 32, 0, true, false, false, false, false, false);
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

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }
}
