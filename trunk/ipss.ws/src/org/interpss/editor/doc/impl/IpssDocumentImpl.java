/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.interpss.editor.doc.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.interpss.editor.doc.IpssDocPackage;
import org.interpss.editor.doc.IpssDocument;
import org.interpss.editor.ws.IpssWsItem;
import org.interpss.editor.ws.IpssWsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipss Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class IpssDocumentImpl extends EObjectImpl implements IpssDocument {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpssDocumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IpssDocPackage.Literals.IPSS_DOCUMENT;
	}

} //IpssDocumentImpl
