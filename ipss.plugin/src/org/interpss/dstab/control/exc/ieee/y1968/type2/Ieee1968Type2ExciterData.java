/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type2;

import org.interpss.dstab.control.base.BaseControllerData;

public class Ieee1968Type2ExciterData extends BaseControllerData {
	private double ka = 1.0;
	private double ta = 2.0;
	private double vrmax = 3.0;
	private double vrmin = 4.0;
	private double ke = 0.0;
	private double te = 0.0;
	private double e1 = 0.0;
	private double seE1 = 0.0;
	private double e2 = 0.0;
	private double seE2 = 0.0;
	private double kf = 0.0;
	private double tf1 = 0.0;
	private double tf2 = 0.0;
	
	private static String[][] controllerParameters= { 
		//          min         max
		{"ka", 		"-1000.0", 	"1000.0"}, 
		{"ta", 		"-1000.0", 	"1000.0"}, 
		{"vrmax", 	"-1000.0", 	"1000.0"}, 
		{"vrmin", 	"-1000.0", 	"1000.0"}, 
		{"ke", 		"-1000.0", 	"1000.0"}, 
		{"te", 		"-1000.0", 	"1000.0"}, 
		{"e1", 		"-1000.0", 	"1000.0"}, 
		{"seE1", 	"-1000.0", 	"1000.0"}, 
		{"e2", 		"-1000.0", 	"1000.0"}, 
		{"seE2", 	"-1000.0", 	"1000.0"}, 
		{"kf", 		"-1000.0", 	"1000.0"}, 
		{"tf1", 	"-1000.0", 	"1000.0"}, 
		{"tf2", 	"-1000.0", 	"1000.0"} 
	};

	public Ieee1968Type2ExciterData() {
		setParameters(controllerParameters);
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
		else if (name.equals("e1"))
			this.e1 = value;
		else if (name.equals("seE1"))
			this.seE1 = value;
		else if (name.equals("e2"))
			this.e2 = value;
		else if (name.equals("seE2"))
			this.seE2 = value;
		else if (name.equals("kf"))
			this.kf = value;
		else if (name.equals("tf1"))
			this.tf1 = value;
		else if (name.equals("tf2"))
			this.tf2 = value;
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
	public double getE1() {
		return e1;
	}
	public void setE1(double e1) {
		this.e1 = e1;
	}
	public double getE2() {
		return e2;
	}
	public void setE2(double e2) {
		this.e2 = e2;
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
	public double getSeE1() {
		return seE1;
	}
	public void setSeE1(double seE1) {
		this.seE1 = seE1;
	}
	public double getSeE2() {
		return seE2;
	}
	public void setSeE2(double seE2) {
		this.seE2 = seE2;
	}
	public double getTe() {
		return te;
	}
	public void setTe(double te) {
		this.te = te;
	}
	public double getTf1() {
		return tf1;
	}
	public void setTf1(double tf) {
		this.tf1 = tf;
	}
	public double getTf2() {
		return tf2;
	}
	public void setTf2(double tf) {
		this.tf2 = tf;
	}
}

