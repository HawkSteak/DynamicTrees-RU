package therealeststu.dtru.growthlogic;

import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import net.minecraft.resources.ResourceLocation;
import therealeststu.dtru.DynamicTreesRU;

public class DTRUGrowthLogicKits {
    public static final GrowthLogicKit MAPLE = new MapleLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "maple"));
    public static final GrowthLogicKit THIN_CONIFER = new PineLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "thin_conifer"));
    public static final GrowthLogicKit MEGA_PINE = new MegaPineLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "mega_pine"));
    public static final GrowthLogicKit REDWOOD = new RedwoodLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "redwood"));
    public static final GrowthLogicKit SMALL_REDWOOD = new SmallRedwoodLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "small_redwood"));
    public static final GrowthLogicKit BAOBAB = new BaobabLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "baobab"));
    public static final GrowthLogicKit PALM = new DiagonalPalmLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "palm"));

    public static final GrowthLogicKit VARIATE_HEIGHT = new VariateHeightLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "variate_height"));
    public static final GrowthLogicKit CYPRESS = new CypressLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "cypress"));
    public static final GrowthLogicKit MEGA_EUCALYPTUS = new MegaEucalyptusLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "mega_eucalyptus"));
    public static final GrowthLogicKit WILLOW = new WillowLogic(new ResourceLocation(DynamicTreesRU.MOD_ID, "willow"));

    public static void register(final Registry<GrowthLogicKit> registry) {
        registry.registerAll(MAPLE, THIN_CONIFER, MEGA_PINE, REDWOOD, SMALL_REDWOOD,
                BAOBAB, VARIATE_HEIGHT, CYPRESS, MEGA_EUCALYPTUS, WILLOW, PALM);
    }

}
