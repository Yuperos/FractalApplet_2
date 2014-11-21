package Applet.FractalGenerator;

import java.util.Random;

public class ValueGenerator extends Random  {

   int genCount=0;
   public final int genCountPerLevel=10;

   public void increaseGenCount() {
      genCount++;
   }

   public void increaseGenCount(int val) {
      genCount+=val;
   }

   public void resetGenCount(){
      genCount=0;
   }

   public void adjustGenCount() {
      if (genCount != 0)
         while(genCount < genCountPerLevel)
            genCount++;
   }
   public ValueGenerator(long seed) {
      super(seed);
   }

   public int nextIntBetween(int begin, int end) {
      return super.nextInt(end - begin) + begin;
   }

   public int nextIntBetween(int begin, int end, int step) {
      int stepCount = (int)Math.ceil((double)(end-begin)/step);
      return super.nextInt(stepCount)*step + begin;
   }

   @Override
   public int nextInt() {
      this.increaseGenCount();
      return super.nextInt();
   }

   public int randBranchCount(int maxCount) {
      int branchCount=0;
      int branchChanceSeed=(nextInt((int) Math.pow(2, maxCount) - 1) ) + 1;
      while((branchChanceSeed & 1)==1 || branchCount==0) {
         branchCount+=branchChanceSeed & 1;
         branchChanceSeed>>=1;
      }
      return branchCount;
   }

}
