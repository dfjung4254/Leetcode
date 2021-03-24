package com.devjk.challenge.march2021;

import java.util.Random;

public class Week3_GenerateRandomPointInACircle {

  /**
   * Your Solution object will be instantiated and called as such:
   * Solution obj = new Solution(radius, x_center, y_center);
   * double[] param_1 = obj.randPoint();
   */

  private final double RADIUS;
  private final double X;
  private final double Y;

  public Week3_GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
    this.RADIUS = radius;
    this.X = x_center;
    this.Y = y_center;
  }

  public double[] randPoint() {

    Random rand = new Random();

    double x_min = X - RADIUS;
    double x_max = X + RADIUS;
    double y_min = Y - RADIUS;
    double y_max = Y + RADIUS;

    rand.nextDouble();

    return null;
  }

}
