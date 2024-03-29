/*
 * @(#)DefaultResourceBundle.java 1.0 04.08.2003
 *
 * Copyright (C) 2003 sven_luzar
 *
 * 6/01/2006: I, Raphpael Valyi, changed back the header of this file to LGPL
 * because nobody changed the file significantly since the last
 * 3.0 version of GPGraphpad that was LGPL. By significantly, I mean: 
 *  - less than 3 instructions changes could honnestly have been done from an old fork,
 *  - license or copyright changes in the header don't count
 *  - automaticaly updating imports don't count,
 *  - updating systematically 2 instructions to a library specification update don't count.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
package org.interpss.editor.resources;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;


/**Defaultresourcebundle for proper names. (e.g. Locales and
 * Look And Feel names are equal in any language. Therefore
 * this Class contains this proper names.)
 *
 * @author <a href="mailto:Sven.Luzar@web.de">Sven luzar</a>
 * @version 1.0
 */

public final class DefaultResourceBundle extends ResourceBundle  {

  /** Hashtable with languageskeys as key and
   *  propername as value
   *
   */
  transient Hashtable defaultNames = new Hashtable();

  /** A list of registered provider.
   *
   *
   */
  ArrayList properNameProvider = new ArrayList();

  /** Creates a new Instance an requerys all default names.
   *
   */
  public DefaultResourceBundle() {
    super();
  }

  /** Adds the Propernameprovider and asks him for
   *  the proper names.
   *
   */
  public void addProperNameProvider(final ProperNameProvider provider){
    properNameProvider.add(provider);

    final Enumeration keys = provider.getKeys();
    while (keys.hasMoreElements()){
      final String key = (String)keys.nextElement();
      final String value = provider.getString(key);
      if (key != null && value != null){
        defaultNames.put(key, value);
      }
    }
  }

  /** removes the propernameprovider
   *
   */
  public void removeProperNameProvider(final ProperNameProvider provider){
    properNameProvider.remove(provider);
  }

  /** merges the keys of any registered ProperNameProvider and returns them.
   *
   */
  public Enumeration getKeys() {
    return defaultNames.elements();
  }

  /** Returns the object for the key or null
   *
   */
  public Object handleGetObject(final String key) {
    return defaultNames.get(key);
  }
}