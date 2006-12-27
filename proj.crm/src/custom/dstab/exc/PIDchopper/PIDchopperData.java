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

package custom.dstab.exc.PIDchopper;

/*
 *  Controller data JavaBean class for holding controller data
 */

public class PIDchopperData {
    public PIDchopperData() {}
    
    /*
     * For each parameter, define a variable with its defaut value, a getter method and a setter method
     */
    
    private double kp = 10.000;
    public double getKp() { return kp; }
    public void setKp(double kp) { this.kp = kp; }
    
    private double ki = 1.000;
    public double getKi() { return ki; }
    public void setKi(double ki) { this.ki = ki; }
    
    private double kb = 0.1000;
    public double getKb() { return kb; }
    public void setKb(double kb) { this.kb = kb; }
    
    private double ta = 2.000;
    public double getTa() { return ta; }
    public void setTa(double ta) { this.ta = ta; }
    
    private double tb = 0.050;
    public double getTb() { return tb; }
    public void setTb(double tb) { this.tb = tb; }
    
    
    private double tr = 0.0200;
    public double getTr() { return tr; }
    public void setTr(double tr) { this.tr = tr; }
    
    
    private double vrmax = 7.00;
    public double getVrmax() { return vrmax; }
    public void setVrmax(double vrmax) { this.vrmax = vrmax; }
    
    private double vrmin = -6.40;
    public double getVrmin() { return vrmin; }
    public void setVrmin(double vrmin) { this.vrmin = vrmin; }
}
