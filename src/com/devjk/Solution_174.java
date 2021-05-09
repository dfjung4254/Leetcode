package com.devjk;

public class Solution_174 {

  public int calculateMinimumHP(int[][] dungeon) {

    HP[][] hps = new HP[dungeon.length][dungeon[0].length];

    // go 0-right
    hps[0][0] = new HP(dungeon[0][0], dungeon[0][0]);
    for(int j = 1; j < dungeon[0].length; j++) {
      int currentHp = hps[0][j - 1].currentHp + dungeon[0][j];
      hps[0][j] = new HP(
              currentHp,
              Math.min(hps[0][j - 1].minimumHp, currentHp)
      );
    }
    for(int i = 1; i < dungeon.length; i++) {
      int currentHp = hps[i - 1][0].currentHp + dungeon[i][0];
      hps[i][0] = new HP(
              currentHp,
              Math.min(hps[i - 1][0].minimumHp, currentHp)
      );
    }

    for(int i = 1; i < dungeon.length; i++) {
      for(int j = 1; j < dungeon[i].length; j++) {
        HP beforeHp = getMinHp(hps[i][j - 1], hps[i - 1][j]);
        int currentHp = beforeHp.currentHp + dungeon[i][j];
        hps[i][j] = new HP(
                currentHp,
                Math.min(beforeHp.minimumHp, currentHp)
        );
      }
    }

    int resultMinimum = hps[dungeon.length - 1][dungeon[0].length - 1].minimumHp;
    if(resultMinimum > 0) {
      return 1;
    }
    return 1 - resultMinimum;
  }

  private HP getMinHp(HP hp1, HP hp2) {
    if(hp1.minimumHp > hp2.minimumHp) {
      return hp1;
    }
    if(hp1.minimumHp < hp2.minimumHp) {
      return hp2;
    }
    if(hp1.currentHp > hp2.currentHp) {
      return hp1;
    }
    return hp2;
  }

  private class HP {
    int currentHp;
    int minimumHp;
    HP() {}
    HP(int currentHp, int minimumHp) {
      this.currentHp = currentHp;
      this.minimumHp = minimumHp;
    }
  }

}
