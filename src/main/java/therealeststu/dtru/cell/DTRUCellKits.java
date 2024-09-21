package therealeststu.dtru.cell;

import com.ferreusveritas.dynamictrees.api.cell.Cell;
import com.ferreusveritas.dynamictrees.api.cell.CellKit;
import com.ferreusveritas.dynamictrees.api.cell.CellNull;
import com.ferreusveritas.dynamictrees.api.cell.CellSolver;
import com.ferreusveritas.dynamictrees.api.registry.Registry;
import com.ferreusveritas.dynamictrees.cell.CellKits;
import com.ferreusveritas.dynamictrees.cell.MetadataCell;
import com.ferreusveritas.dynamictrees.cell.NormalCell;
import com.ferreusveritas.dynamictrees.util.SimpleVoxmap;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import therealeststu.dtru.DynamicTreesRU;

public class DTRUCellKits {

    public static class SparseCellKit extends CellKit {
        protected final Cell sparseBranch = new SparseBranchCell();
        protected final Cell sparseLeaves = new NormalCell(1);

        protected final CellSolver solver = new CellKits.BasicSolver(new short[]{0x0211});

        public SparseCellKit(ResourceLocation registryName) {
            super(registryName);
        }

        @Override
        public Cell getCellForLeaves(int hydro) {
            return hydro > 0 ? sparseLeaves : CellNull.NULL_CELL;
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            return radius == 1 ? sparseBranch : CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTRULeafClusters.SPARSE;
        }

        @Override
        public CellSolver getCellSolver() {
            return solver;
        }

        @Override
        public int getDefaultHydration() {
            return 1;
        }
    }

    public static final CellKit SPARSE = new SparseCellKit(new ResourceLocation(DynamicTreesRU.MOD_ID, "sparse"));

    public static final CellKit BRUSH = new CellKit(new ResourceLocation(DynamicTreesRU.MOD_ID, "brush")) {

        private final Cell branch = new Cell() {
            @Override
            public int getValue() {
                return 5;
            }

            final int[] map = {3, 3, 5, 5, 5, 5};

            @Override
            public int getValueFromSide(Direction side) {
                return map[side.ordinal()];
            }
        };

        private final Cell[] normalCells = {
                CellNull.NULL_CELL,
                new NormalCell(1),
                new NormalCell(2),
                new NormalCell(3),
                new NormalCell(4),
        };

        private final CellSolver solver = new CellKits.BasicSolver(new short[]{
                0x0513, 0x0412, 0x0322, 0x0311, 0x0211,
        });

        @Override
        public Cell getCellForLeaves(int hydro) {
            return normalCells[hydro];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            if (radius == 1) return branch;
            return CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTRULeafClusters.BRUSH;
        }

        @Override
        public CellSolver getCellSolver() {
            return solver;
        }

        @Override
        public int getDefaultHydration() {
            return 3;
        }

    };

    public static final CellKit EUCALYPTUS = new CellKit(new ResourceLocation(DynamicTreesRU.MOD_ID, "eucalyptus")) {

        private final Cell eucalyptusTopBranch = new EucalyptusTopBranchCell();
        private final Cell eucalyptusBranch = new NormalCell(2);
        private final Cell eucalyptusUpperTrunk = new NormalCell(3);

        private final Cell[] eucalyptusLeaves = new Cell[]{
                CellNull.NULL_CELL,
                new EucalyptusLeafCell(1),
                new EucalyptusLeafCell(2),
                new EucalyptusLeafCell(3),
                new EucalyptusLeafCell(4),
        };

        private final CellSolver solver = new CellKits.BasicSolver(new short[]{
                0x0514, 0x0423, 0x0411, 0x0312, 0x0211
        });

        @Override
        public Cell getCellForLeaves(int hydro) {
            return eucalyptusLeaves[hydro];
        }

        @Override
        public Cell getCellForBranch(int radius, int meta) {
            if (meta == MetadataCell.TOP_BRANCH) return eucalyptusTopBranch;
            if (radius == 1) return eucalyptusBranch;
            if (radius <= 3) return eucalyptusUpperTrunk;
            return CellNull.NULL_CELL;
        }

        @Override
        public SimpleVoxmap getLeafCluster() {
            return DTRULeafClusters.EUCALYPTUS;
        }

        @Override
        public CellSolver getCellSolver() {
            return solver;
        }

        @Override
        public int getDefaultHydration() {
            return 4;
        }

    };


    public static void register(final Registry<CellKit> registry) {
        registry.registerAll(SPARSE, BRUSH, EUCALYPTUS);
    }

}
