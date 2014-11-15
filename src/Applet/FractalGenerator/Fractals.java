package Applet.FractalGenerator;

import java.util.List;
import java.util.Random;

public class Fractals {

   final private static int BRANCH_PYTHAGORAS = 1;
   final private static int BRANCH_ON_TRUNK = 2;
   final private static int BRANCH_FLUFF = 3;
   final private static int BRANCH_RHOMBUS_PARALLEL = 4;
   final private static int BRANCH_SUB_RHOMBUS_PARALLEL = 5;

   private int treeHeight;
   private Item root;
   private List<Item> lastGenerated;
   private static final long RANDOMIZE_SEED = 489133282872437279L;
   private final Random seed = new Random(RANDOMIZE_SEED);

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

      this.genNextBranch(genome, root);
   }

   private int randBranchCount(int maxCount) {
      int branchCount=0;
      int branchChanceSeed=(seed.nextInt((int)Math.pow(2,maxCount) - 1) ) + 1;
      while((branchChanceSeed & 1)==1 || branchCount==0) {
         branchCount+=branchChanceSeed & 1;
         branchChanceSeed>>=1;
         }
      return branchCount;
   }


   private void genNextBranch(long genome, Item parentBranch){
      int currentGen = (int)genome%10;
      genome/=10;

       switch(currentGen){
         case BRANCH_PYTHAGORAS: {
            int branchCount = randBranchCount(4);
            for(int i=0; i<branchCount; i++) {
               int nextBranchLengthFactor = seed.nextInt(15)* 5 + 10; //TODO: replace literals with const
               double nextBranchLength = parentBranch.nextLength((double) nextBranchLengthFactor);
               int nextBranchAngleFactor = seed.nextInt(10)* 8 - 40;
               double nextBranchAngle = parentBranch.nextAngleDegrees((double) nextBranchAngleFactor);

               Item currentBranch = new Item(parentBranch.getEnd(), nextBranchAngle, nextBranchLength);
               lastGenerated.add(currentBranch);
               genNextBranch(genome,currentBranch);
               }
            break;
         }
         case BRANCH_ON_TRUNK: {
            double tempLength = parentBranch.nextLength(80.0);
            while(tempLength > 5) {

            }
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
