  /*
  * @(#)CalculationException.java   
  *
  * Copyright (C) 2006 www.interpss.com
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Ron Oosterwijk
  * @Version 1.0
  * @Date Dec 2006
  * 
  *   Revision History
  *   ================
  *
  */

package custom.dstab.exc.st5b;

/*
 *  Controller data JavaBean class for holding controller data
 */

public class st5bExciterData {
    public st5bExciterData() {}
    
    /*
     * For each parameter, define a variable with its defaut value, a getter method and a setter method
     */
    
    private double tb1 = 10.000;
    public double getTb1() { return tb1; }
    public void setTb1(double tb1) { this.tb1 = tb1; }
    
    private double tc1 = 1.000;
    public double getTc1() { return tc1; }
    public void setTc1(double tc1) { this.tc1 = tc1; }
    
    private double tb2 = 0.1000;
    public double getTb2() { return tb2; }
    public void setTb2(double tb2) { this.tb2 = tb2; }
    
    private double tc2 = 0.0500;
    public double getTc2() { return tc2; }
    public void setTc2(double tc2) { this.tc2 = tc2; }
    
    private double kr = 200.0;
    public double getKr() { return kr; }
    public void setKr(double kr) { this.kr = kr; }
    
    
    private double tub1 = 10.000;
    public double getTub1() { return tub1; }
    public void setTub1(double tub1) { this.tub1 = tub1; }
    
    private double tuc1 = 1.000;
    public double getTuc1() { return tuc1; }
    public void setTuc1(double tuc1) { this.tuc1 = tuc1; }
    
    private double tub2 = 0.1000;
    public double getTub2() { return tub2; }
    public void setTub2(double tub2) { this.tub2 = tub2; }
    
    private double tuc2 = 0.0500;
    public double getTuc2() { return tuc2; }
    public void setTuc2(double tuc2) { this.tuc2 = tuc2; }
    
    private double t1 = 0.003;
    public double getT1() { return t1; }
    public void setT1(double t1) { this.t1 = t1; }
    
    
    private double tob1 = 10.000;
    public double getTob1() { return tob1; }
    public void setTob1(double tob1) { this.tob1 = tob1; }
    
    private double toc1 = 1.000;
    public double getToc1() { return toc1; }
    public void setToc1(double toc1) { this.toc1 = toc1; }
    
    private double tob2 = 0.050;
    public double getTob2() { return tob2; }
    public void setTob2(double tob2) { this.tob2 = tb2; }
    
    private double toc2 = 0.100;
    public double getToc2() { return toc2; }
    public void setToc2(double toc2) { this.toc2 = toc2; }
    
    private double kc = 0.0;
    public double getKc() { return kc; }
    public void setKc(double kc) { this.kc = kc; }
    

    private double vrmax = 7.00;
    public double getVrmax() { return vrmax; }
    public void setVrmax(double vrmax) { this.vrmax = vrmax; }
    
    private double vrmin = -6.40;
    public double getVrmin() { return vrmin; }
    public void setVrmin(double vrmin) { this.vrmin = vrmin; }
}
