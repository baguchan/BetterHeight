package baguchan.betterheight;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = BetterHeight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterHeightConfig {
	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;

	static {
		Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static class Common {
		public final ForgeConfigSpec.BooleanValue caveAndCliffLike;

		public Common(ForgeConfigSpec.Builder builder) {
			caveAndCliffLike = builder
					.comment("Enable the Cave and Cliff like cavegen in the nether. [true / false]")
					.translation(BetterHeight.MODID + ".config.caveAndCliffLike")
					.define("Cave And Cliff Like Nether Generation", true);
		}
	}

}