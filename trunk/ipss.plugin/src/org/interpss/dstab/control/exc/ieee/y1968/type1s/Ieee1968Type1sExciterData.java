/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type1s;

import org.interpss.dstab.control.base.BaseControllerData;

public class Ieee1968Type1sExciterData extends BaseControllerData {
	private double ka = 1.0;
	private double ta = 2.0;
	private double kp = 0.0;
	private double vrmin = 4.0;
	private double kf = 0.0;
	private double tf = 0.0;
	
	private static String[][] controllerParameters= { 
		//          min         max
		{"ka", 		"-1000.0", 	"1000.0"}, 
		{"ta", 		"-1000.0", 	"1000.0"}, 
		{"kp", 		"-1000.0", 	"1000.0"}, 
		{"vrmin", 	"-1000.0", 	"1000.0"}, 
		{"kf", 		"-1000.0", 	"1000.0"}, 
		{"tf", 		"-1000.0", 	"1000.0"} 
	};

	public Ieee1968Type1sExciterData() {
		setParameters(controllerParameters);
	}

	public void setValue(String name, int value) {
	}

	public void setValue(String name, double value) {
		if (name.equals("ka"))
			this.ta = value;
		else if (name.equals("ta"))
			this.ta = value;
		else if (name.equals("kp"))
			this.kp = value;
		else if (name.equals("vrmin"))
			this.vrmin = value;
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
	public double getVrmin() {
		return vrmin;
	}
	public void setVrmin(final double vrmin) {
		this.vrmin = vrmin;
	}
	public double getKf() {
		return kf;
	}
	public void setKf(double kf) {
		this.kf = kf;
	}
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}

	public double getKp() {
		return kp;
	}

	public void setKp(double kp) {
		this.kp = kp;
	}
}

