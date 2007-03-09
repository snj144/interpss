 /*
  * @(#)FileUtil.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.opencim.common;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.opencim.cim.SimulationModel;

/**
 *  A file utility class for persisting/loading cim model to/from files. 
 *
 */
public class FileUtil {
	/**
	 * Load a simulation model xml file into the model object
	 * 
	 * @param filename file name
	 * @param ext file extension
	 * @return the loaded cim object
	 */
	public static Object loadModel(String filename, String ext) {
		if (!filename.endsWith(ext)) {
			CIMLogger.getLogger().severe("Wrong file ext, " + 
					ext + ",  filename: " + filename);
			return null;
		}
	  	String path = new File(filename).getAbsolutePath();
	  	URI fileURI = URI.createFileURI(path);
	  	Resource re = getResourceSet(ext).getResource(fileURI, true);
  		CIMLogger.getLogger().info("Load from file " + path);
	  	return re.getContents().get(0);
	}	
	
	/**
	 * Persist the simulation model object into the an xml file 
	 * 
	 * @param filename file name
	 * @param ext file extension
	 * @return true if save successfully
	 */
	public static boolean saveModel(SimulationModel model, String filename, String ext) {
		if (!filename.endsWith(ext)) {
			CIMLogger.getLogger().severe("Wrong SimuModel file ext, " + 
					ext + ",  filename: " + filename);
			return false;
		}
	  	String path = new File(filename).getAbsolutePath();
	  	URI fileURI = URI.createFileURI(path);
	  	Resource re = getResourceSet(ext).createResource(fileURI);
	  	re.getContents().add(model);
	  	try {
	  		re.save(null);
	  		CIMLogger.getLogger().info("SimuModel save to " + path);
	  		return true;
	  	} catch (Exception e) {
	  		CIMLogger.getLogger().severe(e.toString());
	  	}
  		return false;
	}

	private static ResourceSet getResourceSet(String ext) {
  		ResourceSet resourceSet = new ResourceSetImpl();
	  	resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	  			ext, new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl()); 	
	  	return resourceSet;
  	}	
}
