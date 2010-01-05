/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamingImpl.java,v 1.2 2007/03/03 15:19:15 mzhou Exp $
 */
package org.opencim.cim.iec61970.core.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.opencim.cim.iec61970.core.CorePackage;
import org.opencim.cim.iec61970.core.Naming;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Naming</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.NamingImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.NamingImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.NamingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.NamingImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.core.impl.NamingImpl#getMRID <em>MRID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamingImpl extends EObjectImpl implements Naming {
	/**
	 * The default value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasName()
	 * @generated
	 * @ordered
	 */
	protected String aliasName = ALIAS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathName() <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected String pathName = PATH_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMRID() <em>MRID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMRID()
	 * @generated
	 * @ordered
	 */
	protected static final String MRID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMRID() <em>MRID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMRID()
	 * @generated
	 * @ordered
	 */
	protected String mRID = MRID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.NAMING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasName() {
		return aliasName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasName(String newAliasName) {
		String oldAliasName = aliasName;
		aliasName = newAliasName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NAMING__ALIAS_NAME, oldAliasName, aliasName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NAMING__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NAMING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathName() {
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(String newPathName) {
		String oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NAMING__PATH_NAME, oldPathName, pathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMRID() {
		return mRID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMRID(String newMRID) {
		String oldMRID = mRID;
		mRID = newMRID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NAMING__MRID, oldMRID, mRID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.NAMING__ALIAS_NAME:
				return getAliasName();
			case CorePackage.NAMING__DESCRIPTION:
				return getDescription();
			case CorePackage.NAMING__NAME:
				return getName();
			case CorePackage.NAMING__PATH_NAME:
				return getPathName();
			case CorePackage.NAMING__MRID:
				return getMRID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.NAMING__ALIAS_NAME:
				setAliasName((String)newValue);
				return;
			case CorePackage.NAMING__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.NAMING__NAME:
				setName((String)newValue);
				return;
			case CorePackage.NAMING__PATH_NAME:
				setPathName((String)newValue);
				return;
			case CorePackage.NAMING__MRID:
				setMRID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.NAMING__ALIAS_NAME:
				setAliasName(ALIAS_NAME_EDEFAULT);
				return;
			case CorePackage.NAMING__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.NAMING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.NAMING__PATH_NAME:
				setPathName(PATH_NAME_EDEFAULT);
				return;
			case CorePackage.NAMING__MRID:
				setMRID(MRID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.NAMING__ALIAS_NAME:
				return ALIAS_NAME_EDEFAULT == null ? aliasName != null : !ALIAS_NAME_EDEFAULT.equals(aliasName);
			case CorePackage.NAMING__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.NAMING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.NAMING__PATH_NAME:
				return PATH_NAME_EDEFAULT == null ? pathName != null : !PATH_NAME_EDEFAULT.equals(pathName);
			case CorePackage.NAMING__MRID:
				return MRID_EDEFAULT == null ? mRID != null : !MRID_EDEFAULT.equals(mRID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(" (aliasName: ");
		result.append(aliasName);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", pathName: ");
		result.append(pathName);
		result.append(", mRID: ");
		result.append(mRID);
		result.append(')');
		return result.toString();
	}

} //NamingImpl