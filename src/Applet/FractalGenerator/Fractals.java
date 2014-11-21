package Applet.FractalGenerator;

import java.util.List;

public class Fractals {

   final private static int BRANCH_PYTHAGORAS = 1;
   final private static int BRANCH_ON_TRUNK_ONE_SIDE = 2;
   final private static int BRANCH_ON_TRUNK_BOTH_SIDES = 3;
   final private static int BRANCH_FLUFF = 4;
   final private static int BRANCH_RHOMBUS_PARALLEL = 5;
   final private static int BRANCH_SUB_RHOMBUS_PARALLEL = 6;

   private int treeHeight;
   private Item root;
   private List<Item> lastGenerated;
   private static final long RANDOMIZE_SEED = 489133282872437279L;
   private final ValueGenerator seed = new ValueGenerator(RANDOMIZE_SEED);

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
      long genome = assemblyBranchingGenome(BRANCH_ON_TRUNK_BOTH_SIDES, BRANCH_ON_TRUNK_ONE_SIDE, BRANCH_FLUFF);
      root.setSize(50,0,0,this.treeHeight);
      lastGenerated.add(root);

      this.genNextBranch(genome, root);
   }

   private void genNextBranch(long genome, Item parentBranch){
      int currentGen = (int)genome%10;
      genome/=10;
      seed.adjustGenCount();
      seed.resetGenCount();

      switch(currentGen){
        case BRANCH_PYTHAGORAS: {
           int branchCount=seed.randBranchCount(4);
           for(int i=0; i < branchCount; i++) {

              //TODO: replace literals to const with short names
              double nextBranchLength=parentBranch.adjLen(seed.nextIntBetween(10, 90, 5));
              double nextBranchAngle=parentBranch.adjAngleDeg(seed.nextIntBetween(-40, 40, 8));

              Item currentBranch=new Item(parentBranch.getEnd(), nextBranchAngle, nextBranchLength);
              lastGenerated.add(currentBranch);
              genNextBranch(genome, currentBranch);
           }
           break;
        }
        case BRANCH_ON_TRUNK_ONE_SIDE: {
           double startLength = parentBranch.adjLen(20);
           int peakLen=(int)parentBranch.adjLen(5);

           while(startLength > peakLen) {

           }
           break;
        }

        case BRANCH_ON_TRUNK_BOTH_SIDES: {

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
