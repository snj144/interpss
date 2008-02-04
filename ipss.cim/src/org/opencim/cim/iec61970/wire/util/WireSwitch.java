/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireSwitch.java,v 1.1 2007/03/02 14:01:18 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.opencim.cim.iec61970.core.ConductingEquipment;
import org.opencim.cim.iec61970.core.CurveSchedule;
import org.opencim.cim.iec61970.core.Equipment;
import org.opencim.cim.iec61970.core.EquipmentContainer;
import org.opencim.cim.iec61970.core.Naming;
import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.wire.*;

import org.opencim.cim.iec61970.wire.impl.WirePackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.opencim.cim.iec61970.wire.WirePackage
 * @generated
 */
public class WireSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WirePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireSwitch() {
		if (modelPackage == null) {
			modelPackage = WirePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WirePackage.AC_LINE_SEGMENT: {
				ACLineSegment acLineSegment = (ACLineSegment)theEObject;
				Object result = caseACLineSegment(acLineSegment);
				if (result == null) result = caseConductor(acLineSegment);
				if (result == null) result = caseConductingEquipment(acLineSegment);
				if (result == null) result = caseEquipment(acLineSegment);
				if (result == null) result = casePowerSystemResource(acLineSegment);
				if (result == null) result = caseNaming(acLineSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.BREAKER: {
				Breaker breaker = (Breaker)theEObject;
				Object result = caseBreaker(breaker);
				if (result == null) result = caseSwitch(breaker);
				if (result == null) result = caseConductingEquipment(breaker);
				if (result == null) result = caseEquipment(breaker);
				if (result == null) result = casePowerSystemResource(breaker);
				if (result == null) result = caseNaming(breaker);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.BUSBAR_SECTION: {
				BusbarSection busbarSection = (BusbarSection)theEObject;
				Object result = caseBusbarSection(busbarSection);
				if (result == null) result = caseConnector(busbarSection);
				if (result == null) result = caseConductingEquipment(busbarSection);
				if (result == null) result = caseEquipment(busbarSection);
				if (result == null) result = casePowerSystemResource(busbarSection);
				if (result == null) result = caseNaming(busbarSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.COMPENSATOR: {
				Compensator compensator = (Compensator)theEObject;
				Object result = caseCompensator(compensator);
				if (result == null) result = caseRegulatingCondEq(compensator);
				if (result == null) result = caseConductingEquipment(compensator);
				if (result == null) result = caseEquipment(compensator);
				if (result == null) result = casePowerSystemResource(compensator);
				if (result == null) result = caseNaming(compensator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.CONDUCTOR: {
				Conductor conductor = (Conductor)theEObject;
				Object result = caseConductor(conductor);
				if (result == null) result = caseConductingEquipment(conductor);
				if (result == null) result = caseEquipment(conductor);
				if (result == null) result = casePowerSystemResource(conductor);
				if (result == null) result = caseNaming(conductor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.CONDUCTOR_TYPE: {
				ConductorType conductorType = (ConductorType)theEObject;
				Object result = caseConductorType(conductorType);
				if (result == null) result = caseNaming(conductorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.DC_LINE_SEGMENT: {
				DCLineSegment dcLineSegment = (DCLineSegment)theEObject;
				Object result = caseDCLineSegment(dcLineSegment);
				if (result == null) result = caseConductor(dcLineSegment);
				if (result == null) result = caseConductingEquipment(dcLineSegment);
				if (result == null) result = caseEquipment(dcLineSegment);
				if (result == null) result = casePowerSystemResource(dcLineSegment);
				if (result == null) result = caseNaming(dcLineSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.DISCONNECTOR: {
				Disconnector disconnector = (Disconnector)theEObject;
				Object result = caseDisconnector(disconnector);
				if (result == null) result = caseSwitch(disconnector);
				if (result == null) result = caseConductingEquipment(disconnector);
				if (result == null) result = caseEquipment(disconnector);
				if (result == null) result = casePowerSystemResource(disconnector);
				if (result == null) result = caseNaming(disconnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.FUSE: {
				Fuse fuse = (Fuse)theEObject;
				Object result = caseFuse(fuse);
				if (result == null) result = caseSwitch(fuse);
				if (result == null) result = caseConductingEquipment(fuse);
				if (result == null) result = caseEquipment(fuse);
				if (result == null) result = casePowerSystemResource(fuse);
				if (result == null) result = caseNaming(fuse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.GROUND: {
				Ground ground = (Ground)theEObject;
				Object result = caseGround(ground);
				if (result == null) result = caseConductingEquipment(ground);
				if (result == null) result = caseEquipment(ground);
				if (result == null) result = casePowerSystemResource(ground);
				if (result == null) result = caseNaming(ground);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.HEAT_EXCHANGER: {
				HeatExchanger heatExchanger = (HeatExchanger)theEObject;
				Object result = caseHeatExchanger(heatExchanger);
				if (result == null) result = caseEquipment(heatExchanger);
				if (result == null) result = casePowerSystemResource(heatExchanger);
				if (result == null) result = caseNaming(heatExchanger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.JUMPER: {
				Jumper jumper = (Jumper)theEObject;
				Object result = caseJumper(jumper);
				if (result == null) result = caseSwitch(jumper);
				if (result == null) result = caseConductingEquipment(jumper);
				if (result == null) result = caseEquipment(jumper);
				if (result == null) result = casePowerSystemResource(jumper);
				if (result == null) result = caseNaming(jumper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.RECTIFIER_INVERTER: {
				RectifierInverter rectifierInverter = (RectifierInverter)theEObject;
				Object result = caseRectifierInverter(rectifierInverter);
				if (result == null) result = caseConductingEquipment(rectifierInverter);
				if (result == null) result = caseEquipment(rectifierInverter);
				if (result == null) result = casePowerSystemResource(rectifierInverter);
				if (result == null) result = caseNaming(rectifierInverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.REGULATION_SCHEDULE: {
				RegulationSchedule regulationSchedule = (RegulationSchedule)theEObject;
				Object result = caseRegulationSchedule(regulationSchedule);
				if (result == null) result = caseCurveSchedule(regulationSchedule);
				if (result == null) result = caseNaming(regulationSchedule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.STATIC_VAR_COMPENSATOR: {
				StaticVarCompensator staticVarCompensator = (StaticVarCompensator)theEObject;
				Object result = caseStaticVarCompensator(staticVarCompensator);
				if (result == null) result = caseRegulatingCondEq(staticVarCompensator);
				if (result == null) result = caseConductingEquipment(staticVarCompensator);
				if (result == null) result = caseEquipment(staticVarCompensator);
				if (result == null) result = casePowerSystemResource(staticVarCompensator);
				if (result == null) result = caseNaming(staticVarCompensator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.SWITCH: {
				Switch switch_ = (Switch)theEObject;
				Object result = caseSwitch(switch_);
				if (result == null) result = caseConductingEquipment(switch_);
				if (result == null) result = caseEquipment(switch_);
				if (result == null) result = casePowerSystemResource(switch_);
				if (result == null) result = caseNaming(switch_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.TAP_CHANGER: {
				TapChanger tapChanger = (TapChanger)theEObject;
				Object result = caseTapChanger(tapChanger);
				if (result == null) result = casePowerSystemResource(tapChanger);
				if (result == null) result = caseNaming(tapChanger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.POWER_TRANSFORMER: {
				PowerTransformer powerTransformer = (PowerTransformer)theEObject;
				Object result = casePowerTransformer(powerTransformer);
				if (result == null) result = caseEquipment(powerTransformer);
				if (result == null) result = casePowerSystemResource(powerTransformer);
				if (result == null) result = caseNaming(powerTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.TRANSFORMER_WINDING: {
				TransformerWinding transformerWinding = (TransformerWinding)theEObject;
				Object result = caseTransformerWinding(transformerWinding);
				if (result == null) result = caseConductingEquipment(transformerWinding);
				if (result == null) result = caseEquipment(transformerWinding);
				if (result == null) result = casePowerSystemResource(transformerWinding);
				if (result == null) result = caseNaming(transformerWinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.LINE: {
				Line line = (Line)theEObject;
				Object result = caseLine(line);
				if (result == null) result = casePowerSystemResource(line);
				if (result == null) result = caseNaming(line);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.VOLTAGE_CONTROL_ZONE: {
				VoltageControlZone voltageControlZone = (VoltageControlZone)theEObject;
				Object result = caseVoltageControlZone(voltageControlZone);
				if (result == null) result = casePowerSystemResource(voltageControlZone);
				if (result == null) result = caseNaming(voltageControlZone);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.WINDING_TEST: {
				WindingTest windingTest = (WindingTest)theEObject;
				Object result = caseWindingTest(windingTest);
				if (result == null) result = caseNaming(windingTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.SYNCHRONOUS_MACHINE: {
				SynchronousMachine synchronousMachine = (SynchronousMachine)theEObject;
				Object result = caseSynchronousMachine(synchronousMachine);
				if (result == null) result = caseRegulatingCondEq(synchronousMachine);
				if (result == null) result = caseConductingEquipment(synchronousMachine);
				if (result == null) result = caseEquipment(synchronousMachine);
				if (result == null) result = casePowerSystemResource(synchronousMachine);
				if (result == null) result = caseNaming(synchronousMachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.MV_AR_CAPABILITY_CURVE: {
				MVArCapabilityCurve mvArCapabilityCurve = (MVArCapabilityCurve)theEObject;
				Object result = caseMVArCapabilityCurve(mvArCapabilityCurve);
				if (result == null) result = caseCurveSchedule(mvArCapabilityCurve);
				if (result == null) result = caseNaming(mvArCapabilityCurve);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.EQUIVALENT_SOURCE: {
				EquivalentSource equivalentSource = (EquivalentSource)theEObject;
				Object result = caseEquivalentSource(equivalentSource);
				if (result == null) result = caseConductingEquipment(equivalentSource);
				if (result == null) result = caseEquipment(equivalentSource);
				if (result == null) result = casePowerSystemResource(equivalentSource);
				if (result == null) result = caseNaming(equivalentSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.WIRE_TYPE: {
				WireType wireType = (WireType)theEObject;
				Object result = caseWireType(wireType);
				if (result == null) result = caseNaming(wireType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.WIRE_ARRANGEMENT: {
				WireArrangement wireArrangement = (WireArrangement)theEObject;
				Object result = caseWireArrangement(wireArrangement);
				if (result == null) result = caseNaming(wireArrangement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.LOAD_BREAK_SWITCH: {
				LoadBreakSwitch loadBreakSwitch = (LoadBreakSwitch)theEObject;
				Object result = caseLoadBreakSwitch(loadBreakSwitch);
				if (result == null) result = caseSwitch(loadBreakSwitch);
				if (result == null) result = caseConductingEquipment(loadBreakSwitch);
				if (result == null) result = caseEquipment(loadBreakSwitch);
				if (result == null) result = casePowerSystemResource(loadBreakSwitch);
				if (result == null) result = caseNaming(loadBreakSwitch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.JUNCTION: {
				Junction junction = (Junction)theEObject;
				Object result = caseJunction(junction);
				if (result == null) result = caseConnector(junction);
				if (result == null) result = caseConductingEquipment(junction);
				if (result == null) result = caseEquipment(junction);
				if (result == null) result = casePowerSystemResource(junction);
				if (result == null) result = caseNaming(junction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.ENERGY_CONSUMER: {
				EnergyConsumer energyConsumer = (EnergyConsumer)theEObject;
				Object result = caseEnergyConsumer(energyConsumer);
				if (result == null) result = caseConductingEquipment(energyConsumer);
				if (result == null) result = caseEquipment(energyConsumer);
				if (result == null) result = casePowerSystemResource(energyConsumer);
				if (result == null) result = caseNaming(energyConsumer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				Object result = caseConnector(connector);
				if (result == null) result = caseConductingEquipment(connector);
				if (result == null) result = caseEquipment(connector);
				if (result == null) result = casePowerSystemResource(connector);
				if (result == null) result = caseNaming(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.REGULATING_COND_EQ: {
				RegulatingCondEq regulatingCondEq = (RegulatingCondEq)theEObject;
				Object result = caseRegulatingCondEq(regulatingCondEq);
				if (result == null) result = caseConductingEquipment(regulatingCondEq);
				if (result == null) result = caseEquipment(regulatingCondEq);
				if (result == null) result = casePowerSystemResource(regulatingCondEq);
				if (result == null) result = caseNaming(regulatingCondEq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.GROUND_DISCONNECTOR: {
				GroundDisconnector groundDisconnector = (GroundDisconnector)theEObject;
				Object result = caseGroundDisconnector(groundDisconnector);
				if (result == null) result = caseSwitch(groundDisconnector);
				if (result == null) result = caseConductingEquipment(groundDisconnector);
				if (result == null) result = caseEquipment(groundDisconnector);
				if (result == null) result = casePowerSystemResource(groundDisconnector);
				if (result == null) result = caseNaming(groundDisconnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.COMPOSITE_SWITCH: {
				CompositeSwitch compositeSwitch = (CompositeSwitch)theEObject;
				Object result = caseCompositeSwitch(compositeSwitch);
				if (result == null) result = caseEquipmentContainer(compositeSwitch);
				if (result == null) result = casePowerSystemResource(compositeSwitch);
				if (result == null) result = caseNaming(compositeSwitch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.WIRES_VERSION: {
				WiresVersion wiresVersion = (WiresVersion)theEObject;
				Object result = caseWiresVersion(wiresVersion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WirePackage.FREQUENCY_CONVERTER: {
				FrequencyConverter frequencyConverter = (FrequencyConverter)theEObject;
				Object result = caseFrequencyConverter(frequencyConverter);
				if (result == null) result = caseRegulatingCondEq(frequencyConverter);
				if (result == null) result = caseConductingEquipment(frequencyConverter);
				if (result == null) result = caseEquipment(frequencyConverter);
				if (result == null) result = casePowerSystemResource(frequencyConverter);
				if (result == null) result = caseNaming(frequencyConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AC Line Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AC Line Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseACLineSegment(ACLineSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Breaker</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Breaker</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBreaker(Breaker object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Busbar Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Busbar Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBusbarSection(BusbarSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compensator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compensator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompensator(Compensator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conductor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conductor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConductor(Conductor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conductor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conductor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConductorType(ConductorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DC Line Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DC Line Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDCLineSegment(DCLineSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disconnector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disconnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDisconnector(Disconnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fuse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fuse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFuse(Fuse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ground</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ground</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGround(Ground object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Heat Exchanger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Heat Exchanger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseHeatExchanger(HeatExchanger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jumper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jumper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJumper(Jumper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rectifier Inverter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rectifier Inverter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRectifierInverter(RectifierInverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regulation Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regulation Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegulationSchedule(RegulationSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Var Compensator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Var Compensator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticVarCompensator(StaticVarCompensator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSwitch(Switch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tap Changer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tap Changer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTapChanger(TapChanger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerTransformer(PowerTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformer Winding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformer Winding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransformerWinding(TransformerWinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLine(Line object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Voltage Control Zone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voltage Control Zone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVoltageControlZone(VoltageControlZone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Winding Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Winding Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWindingTest(WindingTest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synchronous Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synchronous Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSynchronousMachine(SynchronousMachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MV Ar Capability Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MV Ar Capability Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMVArCapabilityCurve(MVArCapabilityCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalent Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalent Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquivalentSource(EquivalentSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWireType(WireType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrangement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrangement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWireArrangement(WireArrangement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Break Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Break Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLoadBreakSwitch(LoadBreakSwitch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Junction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Junction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseJunction(Junction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Energy Consumer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Energy Consumer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEnergyConsumer(EnergyConsumer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regulating Cond Eq</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regulating Cond Eq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegulatingCondEq(RegulatingCondEq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ground Disconnector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ground Disconnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGroundDisconnector(GroundDisconnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCompositeSwitch(CompositeSwitch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wires Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wires Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWiresVersion(WiresVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frequency Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frequency Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFrequencyConverter(FrequencyConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Naming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Naming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNaming(Naming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power System Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power System Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePowerSystemResource(PowerSystemResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipment(Equipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conducting Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conducting Equipment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConductingEquipment(ConductingEquipment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Curve Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Curve Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCurveSchedule(CurveSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equipment Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equipment Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEquipmentContainer(EquipmentContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //WireSwitch
