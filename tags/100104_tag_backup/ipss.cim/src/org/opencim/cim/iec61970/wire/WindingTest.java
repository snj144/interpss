/**
 * <copyright>
 * </copyright>
 *
 * $Id: WindingTest.java,v 1.1 2007/03/02 14:01:02 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.Naming;

import org.opencim.datatype.integer.TapStep;

import org.opencim.datatype.real.AngleDegrees;
import org.opencim.datatype.real.ExcitingCurrent;
import org.opencim.datatype.real.Impedance;
import org.opencim.datatype.real.LoadLoss;
import org.opencim.datatype.real.NoLoadLoss;
import org.opencim.datatype.real.Voltage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Winding Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Physical winding test data for the winding/tap pairs of a transformer (or phase shifter). This test data can be used to derive other attributes of specific transformer or phase shifter models.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getExcitingCurrent <em>Exciting Current</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getFromTapStep <em>From Tap Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getLeakageImpedance <em>Leakage Impedance</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getLoadLoss <em>Load Loss</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getNoLoadLoss <em>No Load Loss</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getPhaseShift <em>Phase Shift</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getToTapStep <em>To Tap Step</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getVoltage <em>Voltage</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding <em>From Transformer Winding</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.wire.WindingTest#getTo_TransformeWindings <em>To Transforme Windings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest()
 * @generated
 */
public interface WindingTest extends Naming {
	/**
	 * Returns the value of the '<em><b>Exciting Current</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exciting current % ("to" winding open-circuited) from the test report.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exciting Current</em>' attribute.
	 * @see #setExcitingCurrent(ExcitingCurrent)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_ExcitingCurrent()
	 * @generated
	 */
	ExcitingCurrent getExcitingCurrent();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getExcitingCurrent <em>Exciting Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exciting Current</em>' attribute.
	 * @see #getExcitingCurrent()
	 * @generated
	 */
	void setExcitingCurrent(ExcitingCurrent value);

	/**
	 * Returns the value of the '<em><b>From Tap Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tap step number for the "from" winding of the test pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Tap Step</em>' attribute.
	 * @see #setFromTapStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_FromTapStep()
	 * @generated
	 */
	TapStep getFromTapStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getFromTapStep <em>From Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Tap Step</em>' attribute.
	 * @see #getFromTapStep()
	 * @generated
	 */
	void setFromTapStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Leakage Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The leakage impedance measured at the "from" winding  with the "to" winding short-circuited and all other windings open-circuited.  Leakage impedance is expressed in units based on the MVA and kV ratings of the "from" winding.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Leakage Impedance</em>' attribute.
	 * @see #setLeakageImpedance(Impedance)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_LeakageImpedance()
	 * @generated
	 */
	Impedance getLeakageImpedance();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getLeakageImpedance <em>Leakage Impedance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leakage Impedance</em>' attribute.
	 * @see #getLeakageImpedance()
	 * @generated
	 */
	void setLeakageImpedance(Impedance value);

	/**
	 * Returns the value of the '<em><b>Load Loss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The load loss kW ("to" winding short-circuited) from the test report.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Load Loss</em>' attribute.
	 * @see #setLoadLoss(LoadLoss)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_LoadLoss()
	 * @generated
	 */
	LoadLoss getLoadLoss();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getLoadLoss <em>Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Loss</em>' attribute.
	 * @see #getLoadLoss()
	 * @generated
	 */
	void setLoadLoss(LoadLoss value);

	/**
	 * Returns the value of the '<em><b>No Load Loss</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The no load loss kW "to" winding open-circuited) from the test report.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Load Loss</em>' attribute.
	 * @see #setNoLoadLoss(NoLoadLoss)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_NoLoadLoss()
	 * @generated
	 */
	NoLoadLoss getNoLoadLoss();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getNoLoadLoss <em>No Load Loss</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Load Loss</em>' attribute.
	 * @see #getNoLoadLoss()
	 * @generated
	 */
	void setNoLoadLoss(NoLoadLoss value);

	/**
	 * Returns the value of the '<em><b>Phase Shift</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The phase shift measured at the open-circuited "to" winding, with the "from" winding set to the "from" winding's rated voltage and all other windings open-circuited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Phase Shift</em>' attribute.
	 * @see #setPhaseShift(AngleDegrees)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_PhaseShift()
	 * @generated
	 */
	AngleDegrees getPhaseShift();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getPhaseShift <em>Phase Shift</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase Shift</em>' attribute.
	 * @see #getPhaseShift()
	 * @generated
	 */
	void setPhaseShift(AngleDegrees value);

	/**
	 * Returns the value of the '<em><b>To Tap Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tap step number for the "to" winding of the test pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Tap Step</em>' attribute.
	 * @see #setToTapStep(TapStep)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_ToTapStep()
	 * @generated
	 */
	TapStep getToTapStep();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getToTapStep <em>To Tap Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Tap Step</em>' attribute.
	 * @see #getToTapStep()
	 * @generated
	 */
	void setToTapStep(TapStep value);

	/**
	 * Returns the value of the '<em><b>Voltage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The voltage measured at the open-circuited "to" winding, with the "from" winding set to the "from" winding's rated voltage and all other windings open-circuited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Voltage</em>' attribute.
	 * @see #setVoltage(Voltage)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_Voltage()
	 * @generated
	 */
	Voltage getVoltage();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getVoltage <em>Voltage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voltage</em>' attribute.
	 * @see #getVoltage()
	 * @generated
	 */
	void setVoltage(Voltage value);

	/**
	 * Returns the value of the '<em><b>From Transformer Winding</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getFrom_WindingTests <em>From Winding Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The winding from which the test was conducted
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From Transformer Winding</em>' reference.
	 * @see #setFrom_TransformerWinding(TransformerWinding)
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_From_TransformerWinding()
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getFrom_WindingTests
	 * @generated
	 */
	TransformerWinding getFrom_TransformerWinding();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.wire.WindingTest#getFrom_TransformerWinding <em>From Transformer Winding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Transformer Winding</em>' reference.
	 * @see #getFrom_TransformerWinding()
	 * @generated
	 */
	void setFrom_TransformerWinding(TransformerWinding value);

	/**
	 * Returns the value of the '<em><b>To Transforme Windings</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.wire.TransformerWinding}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest <em>To Winding Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The winding to which the test was conducted
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To Transforme Windings</em>' reference list.
	 * @see org.opencim.cim.iec61970.wire.WirePackage#getWindingTest_To_TransformeWindings()
	 * @see org.opencim.cim.iec61970.wire.TransformerWinding#getTo_WindingTest
	 * @generated
	 */
	EList getTo_TransformeWindings();

} // WindingTest