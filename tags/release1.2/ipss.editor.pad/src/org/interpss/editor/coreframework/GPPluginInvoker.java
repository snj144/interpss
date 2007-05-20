package org.interpss.editor.coreframework;


import javax.swing.Action;
import javax.swing.ActionMap;

import org.interpss.editor.doc.IpssProject;
import org.interpss.editor.resources.Translator;
import org.interpss.editor.util.ICommandRegistery;
import org.interpss.editor.util.Utilities;



/**
 * Utilities for JGraphpad to load plugin classes in a loose coupled manner so
 * that they can be included or not dynamically and without generating
 * compilation error. The various kind of classes you try to instanciate via
 * those utilities can be replaced by an appropriate subclasser by any
 * registered plugin if it change the key association in the the properties
 * file.
 * 
 * @author rvalyi
 */
public final class GPPluginInvoker {
    private static String[] commandSearchPath;

    public static Action getCommand(final String key, final ActionMap map,
            final ICommandRegistery registery) {
        Action action;
        action = map.get(key);
        if (action == null) {
            for (int i = 0; i < commandSearchPath.length; i++) {
                try {
                    final Class clazz = getClassForName(commandSearchPath[i] + "." + key);
                    action = (Action) clazz.newInstance();
                    break;// successful, no need for further search
                } catch (Exception ex) {// continue the search
                    continue;
                }
            }

            if (action == null) {
                System.out.print("\nCANT'T FIND LOAD ACTION " + key
                        + ". I'M CONTINUING...");
                return null;
            }

            map.put(action.getValue(Action.NAME), action);// we register this
                                                            // new command
            registery.initCommand(action);// we eventually initialize
                                            // something dealing with this new
                                            // command
        }
        return action;
    }

    public static Object instanciateObjectForKey(final String key) {
        Class clazz = null;
        try {
            clazz = getClassForKey(key);
            return clazz.newInstance();
        } catch (Exception ex) {
            System.err.print("CAN'T INSTANCIATE CLASS: " + clazz.toString()
                    + "/nMAY BE THIS CLASS HAS NO PUBLIC EMPTY CONSTRUCTOR\n");
            ex.printStackTrace();
            return null;
        }
    }

    public static Object instanciateObjectForName(final String name) {
        Class clazz = null;
        try {
            clazz = getClassForName(name);
            return clazz.newInstance();
        } catch (Exception ex) {
            System.err.print("CAN'T INSTANCIATE CLASS: " + clazz.toString()
                    + "/nMAY BE THIS CLASS HAS NO PUBLIC EMPTY CONSTRUCTOR\n");
            ex.printStackTrace();
            return null;
        }
    }

    public static Class getClassForName(final String name)
            throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(name);
    }

    public static Class getClassForKey(final String key) {
        try {
            return getClassForName(Translator.getString(key));
        } catch (ClassNotFoundException ex) {
            System.err.print("CAN'T LOAD CLASS: " + Translator.getString(key)
                    + "\n" + "MAY BE THE REQUIRED PLUGIN IS SIMPLY MISSING\n");
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Decorate the document with registered plugins if any.
     * Use the decorator pattern to allow loose couplig with plugins
     * @param doc
     * @return
     */
    public static GPDocument decorateDocument(GPDocument doc) {
		String values[] = Utilities.tokenize(Translator
				.getString("DocumentDecorators"));
		for (int i = 0; i < values.length; i++) {
			try {
	            Object param[] = {doc};
	            Class clazz[] = {GPDocument.class};
	            doc = (GPDocument) getClassForName(values[i]).getConstructor(clazz).newInstance(param);
	            //invoke(null, param);
	            //.getMethod(constructorName, clazz).invoke(null, param);
			} catch (Exception ex) {
				System.out.print(ex);
			}
		}
    		return doc;
    }

    public static Object createGraphpadAwareSingleton(final String key,
            final GPGraphpad graphpad) {
    		Object singleton = createSingleton(key);
        try {
            Object param[] = {graphpad};
            Class clazz[] = {GPGraphpad.class};
            singleton.getClass().getMethod("setGraphpad", clazz).invoke(singleton, param);
            return singleton;	
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return singleton;
    }
    
    public static Object createSingleton(final String key) {
        Object param[] = {};
        Class clazz[] = {};
        try {
            Class singleton_class = getClassForKey(key);
            Object singleton = singleton_class.getMethod("getInstance", clazz).invoke(null, param);
            	return singleton;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }	
    }

    public static Object instanciateDocumentAwareObjectForKey(final String key,
            final GPDocument document, final boolean isDocumentRefOptionnal) {
        Object object = instanciateObjectForKey(key);
        Object param[] = { document };
        Class classes[] = { GPDocument.class };
        try {
            object.getClass().getMethod("setDocument", classes).invoke(object,
                    param);
            return object;
        } catch (Exception ex) {
            if (isDocumentRefOptionnal)// Then that's OK: the object can't hold
                // a document reference
                return object;
            ex.printStackTrace();
            return null;
        }
    }

    public static void openURL(String url) {
        try {
            Class clazz = getClassForKey("BrowserLauncher.class");
            Class classes[] = { String.class };
            Object params[] = { new String(url) };
            clazz.getMethod("openURL", classes).invoke(null, params);
        } catch (Exception ex) {
            System.err.print(Translator.getString("Error.invokation"));
            ex.printStackTrace();
        }
    }

//    public static NamedInputStream provideInputStream(String fileExtension) {
//        try {
//            Object object = instanciateObjectForKey("InputStreamProvider.class");
//            Class classes[] = { String.class };
//            Object params[] = { new String(fileExtension) };
//            return (NamedInputStream) object.getClass().getMethod("provideInput",
//                    classes).invoke(object, params);
//        } catch (Exception ex) {
//            System.err.print(Translator.getString("Error.invokation"));
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    public static NamedOutputStream provideOutputStream(String fileExtension,
//            String nameToBeConfirmed, boolean isZipped) {
//    	if (nameToBeConfirmed == null)
//    		nameToBeConfirmed = "undef";
//        try {
//            Object object = instanciateObjectForKey("OutputStreamProvider.class");
//            Class classes[] = { String.class, String.class, Boolean.class };
//            Object params[] = { new String(fileExtension), new String(nameToBeConfirmed),
//                    new Boolean(isZipped) };
//            return (NamedOutputStream) object.getClass().getMethod("provideOutput",
//                    classes).invoke(object, params);
//        } catch (Exception ex) {
//            System.err.print(Translator.getString("Error.invokation"));
//            ex.printStackTrace();
//            return null;
//        }
//    }

    /**
     * Use the decorator pattern to decorate the document the way you want!
     * 
     * @param gp
     * @param url
     * @param file
     * @return
     */
    public static GPDocument createDocument(GPGraphpad gp,IpssProject p, String name,
            GPGraphpadFile file) {
        GPDocument document = new GPDocument(gp,p, name, file);
        //document = new LibraryDocument(document);
        //document = new GPGraphDocument(document);
        return document;
    }

    public static String[] getCommandSearchPath() {
        return commandSearchPath;
    }

    public static void setCommandSearchPath(String[] commandSearchPath) {
        GPPluginInvoker.commandSearchPath = commandSearchPath;
    }
}
