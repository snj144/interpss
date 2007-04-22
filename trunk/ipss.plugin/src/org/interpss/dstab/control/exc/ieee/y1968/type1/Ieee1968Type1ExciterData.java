/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type1;

import org.interpss.dstab.control.base.BaseControllerData;

public class Ieee1968Type1ExciterData extends BaseControllerData {
	private double ka;
	private double ta;
	private double vrmax;
	private double vrmin;
	private double ke;
	private double te;
	private double e1;
	private double seE1;
	private double e2;
	private double seE2;
	private double kf;
	private double tf;
	
	private static String[][] controllerParameters= { 
		//          init    max         min
		{"ka", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"ta", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"vrmax", 	"0.0", 	"-1000.0", 	"1000.0"}, 
		{"vrman", 	"0.0", 	"-1000.0", 	"1000.0"}, 
		{"ke", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"te", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"e1", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"seE1", 	"0.0", 	"-1000.0", 	"1000.0"}, 
		{"e2", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"seE2", 	"0.0", 	"-1000.0", 	"1000.0"}, 
		{"kf", 		"0.0", 	"-1000.0", 	"1000.0"}, 
		{"tf", 		"0.0", 	"-1000.0", 	"1000.0"} 
	};

	public Ieee1968Type1ExciterData() {
		setParameters(controllerParameters);
		this.ka = getInitValue("ka");
		this.ta = getInitValue("ta");
		this.vrmax = getInitValue("vrmax");
		this.vrmin = getInitValue("vrmin");
		this.ke = getInitValue("ke");
		this.te = getInitValue("te");
		this.e1 = getInitValue("e1");
		this.seE1 = getInitValue("seE1");
		this.e2 = getInitValue("e2");
		this.seE2 = getInitValue("seE2");
		this.kf = getInitValue("kf");
		this.tf = getInitValue("tf");
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
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}
}

