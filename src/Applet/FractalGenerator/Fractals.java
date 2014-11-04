package Applet.FractalGenerator;

import java.util.List;

public class Fractals {

   private static int BRANCH_PYTHAGORAS = 1;
   private static int BRANCH_ON_TRUNK = 2;
   private static int BRANCH_FLUFF = 3;
   private static int BRANCH_RHOMBUS_PARALLEL = 4;

   private int treeHeight;
   private long genome;
   private Item root;
   private List<Item> lastGenerated;
   private static long RANDOMIZE_SEED = 489133282872437279L;

   public List<Item> getLastGenerated() {
      return lastGenerated;
   }

   public int getTreeHeight() {
      return treeHeight;
   }

   public void setTreeHeight(int treeHeight) {
      this.treeHeight=treeHeight;
   }
   private void assemblyBranchingGenome(int... a){
      this.genome=0;
      if (a.length > 0)
         for(int i:a)
            this.genome=i+this.genome*10;
   }

   public void growEvergreen() {
      this.assemblyBranchingGenome(BRANCH_ON_TRUNK, BRANCH_ON_TRUNK, BRANCH_FLUFF);
      this.root.setSize(50,0,0,this.treeHeight);
      this.lastGenerated.add(root);

      

   }
}
