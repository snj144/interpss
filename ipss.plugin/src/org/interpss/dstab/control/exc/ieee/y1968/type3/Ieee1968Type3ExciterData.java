/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type3;

import org.interpss.dstab.control.base.BaseControllerData;

public class Ieee1968Type3ExciterData extends BaseControllerData {
	private double ka = 1.0;
	private double ta = 2.0;
	private double vrmax = 3.0;
	private double vrmin = 4.0;
	private double ke = 0.0;
	private double te = 0.0;
	private double kp = 0.0;
	private double ki = 0.0;
	private double vbmax = 0.0;
	private double kf = 0.0;
	private double tf = 0.0;
	
	private static String[][] controllerParameters= { 
		//          min         max
		{"ka", 		"-1000.0", 	"1000.0"}, 
		{"ta", 		"-1000.0", 	"1000.0"}, 
		{"vrmax", 	"-1000.0", 	"1000.0"}, 
		{"vrmin", 	"-1000.0", 	"1000.0"}, 
		{"ke", 		"-1000.0", 	"1000.0"}, 
		{"te", 		"-1000.0", 	"1000.0"}, 
		{"kp", 		"-1000.0", 	"1000.0"}, 
		{"ki", 		"-1000.0", 	"1000.0"}, 
		{"vbmax", 	"-1000.0", 	"1000.0"}, 
		{"kf", 		"-1000.0", 	"1000.0"}, 
		{"tf", 		"-1000.0", 	"1000.0"} 
	};

	public Ieee1968Type3ExciterData() {
		setRangeParameters(controllerParameters);
	}

	public void setValue(String name, int value) {
	}

	public void setValue(String name, double value) {
		if (name.equals("ka"))
			this.ta = value;
		else if (name.equals("ta"))
			this.ta = value;
		else if (name.equals("vrmax"))
			this.vrmax = value;
		else if (name.equals("vrmin"))
			this.vrmin = value;
		else if (name.equals("ke"))
			this.ke = value;
		else if (name.equals("te"))
			this.te = value;
		else if (name.equals("kp"))
			this.kp = value;
		else if (name.equals("ki"))
			this.ki = value;
		else if (name.equals("vbmax"))
			this.vbmax = value;
		else if (name.equals("kf"))
			this.kf = value;
		else if (name.equals("tf"))
			this.tf = value;
	}
	
	public double getKa() {
		return ka;
	}
	public void setKa(final double ka) {
		this.ka = ka;
	}
	public double getTa() {
		return ta;
	}
	public void setTa(final double ta) {
		this.ta = ta;
	}
	public double getVrmax() {
		return vrmax;
	}
	public void setVrmax(final double vrmax) {
		this.vrmax = vrmax;
	}
	public double getVrmin() {
		return vrmin;
	}
	public void setVrmin(final double vrmin) {
		this.vrmin = vrmin;
	}
	public double getKe() {
		return ke;
	}
	public void setKe(double ke) {
		this.ke = ke;
	}
	public double getKf() {
		return kf;
	}
	public void setKf(double kf) {
		this.kf = kf;
	}
	public double getTe() {
		return te;
	}
	public void setTe(double te) {
		this.te = te;
	}
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}

	public double getKi() {
		return ki;
	}

	public void setKi(double ki) {
		this.ki = ki;
	}

	public double getKp() {
		return kp;
	}

	public void setKp(double kp) {
		this.kp = kp;
	}

	public double getVbmax() {
		return vbmax;
	}

	public void setVbmax(double vbmax) {
		this.vbmax = vbmax;
	}
}

