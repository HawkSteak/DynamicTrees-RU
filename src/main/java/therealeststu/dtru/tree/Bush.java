package therealeststu.dtru.tree;

import com.ferreusveritas.dynamictrees.systems.genfeature.BushGenFeature;
import com.ferreusveritas.dynamictrees.systems.genfeature.GenFeatures;
import com.ferreusveritas.dynamictrees.tree.species.Species;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import therealeststu.dtru.DynamicTreesRU;

import java.util.LinkedList;
import java.util.List;

public class Bush extends Species {

    public static List<Bush> INSTANCES = new LinkedList<>();

    ResourceLocation log, leaves, altLeaves;

    public Bush(String name, ResourceLocation log, ResourceLocation leaves) {
        this(name, log, leaves, null);
    }

    public Bush(String name, ResourceLocation log, ResourceLocation leaves, ResourceLocation altLeaves) {
        this.setRegistryName(new ResourceLocation(DynamicTreesRU.MOD_ID, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setStandardSoils();
        this.log = log;
        this.leaves = leaves;
        this.altLeaves = altLeaves;

        INSTANCES.add(this);
    }

    public void setup() {
        Block logBlock = ForgeRegistries.BLOCKS.getValue(log);
        Block leavesBlock = ForgeRegistries.BLOCKS.getValue(leaves);
        Block altLeavesBlock = null;
        if (altLeaves != null) {
            Block altLeafBlock = ForgeRegistries.BLOCKS.getValue(altLeaves);
            if (altLeafBlock != Blocks.AIR) altLeavesBlock = altLeafBlock;
        }
        this.addGenFeature(GenFeatures.BUSH.with(BushGenFeature.LOG, logBlock)
                .with(BushGenFeature.LEAVES, leavesBlock).with(BushGenFeature.SECONDARY_LEAVES, altLeavesBlock));
    }

    @Override
    public boolean isTransformable() {
        return false;
    }

}
