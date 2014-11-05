package Applet.FractalGenerator;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.List;

public class Fractals {

   final private static int BRANCH_PYTHAGORAS = 1;
   final private static int BRANCH_ON_TRUNK = 2;
   final private static int BRANCH_FLUFF = 3;
   final private static int BRANCH_RHOMBUS_PARALLEL = 4;

   private int treeHeight;
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

   private long assemblyBranchingGenome(int... a){
      long genome=0;
      if (a.length > 0)
         for(int i:a)
            genome=i+ genome *10;
      return genome;
   }

   public void growEvergreen() {
      long genome = assemblyBranchingGenome(BRANCH_ON_TRUNK, BRANCH_ON_TRUNK, BRANCH_FLUFF);
      this.root.setSize(50,0,0,this.treeHeight);
      this.lastGenerated.add(root);



   }

   private void nextBranch(long genome, int seed){
      int currentGen = (int)genome%10;
      genome/=10;

//    TODO доделать алгоритмы в свичах

      switch(currentGen){
         case BRANCH_PYTHAGORAS: {
            break;
         }
         case BRANCH_ON_TRUNK: {
            break;
         }
         case BRANCH_FLUFF: {
            break;
         }
         case BRANCH_RHOMBUS_PARALLEL: {
            break;
         }
      }

   }
}
