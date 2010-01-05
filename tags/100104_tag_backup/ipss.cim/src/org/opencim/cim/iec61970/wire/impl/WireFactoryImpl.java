/**
 * <copyright>
 * </copyright>
 *
 * $Id: WireFactoryImpl.java,v 1.1 2007/03/02 14:00:57 mzhou Exp $
 */
package org.opencim.cim.iec61970.wire.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.opencim.cim.iec61970.wire.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WireFactoryImpl extends EFactoryImpl implements WireFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WireFactory init() {
		try {
			WireFactory theWireFactory = (WireFactory)EPackage.Registry.INSTANCE.getEFactory("org.opencim.cim.iec61970.wire"); 
			if (theWireFactory != null) {
				return theWireFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WireFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WirePackage.AC_LINE_SEGMENT: return createACLineSegment();
			case WirePackage.BREAKER: return createBreaker();
			case WirePackage.BUSBAR_SECTION: return createBusbarSection();
			case WirePackage.COMPENSATOR: return createCompensator();
			case WirePackage.CONDUCTOR: return createConductor();
			case WirePackage.CONDUCTOR_TYPE: return createConductorType();
			case WirePackage.DC_LINE_SEGMENT: return createDCLineSegment();
			case WirePackage.DISCONNECTOR: return createDisconnector();
			case WirePackage.FUSE: return createFuse();
			case WirePackage.GROUND: return createGround();
			case WirePackage.HEAT_EXCHANGER: return createHeatExchanger();
			case WirePackage.JUMPER: return createJumper();
			case WirePackage.RECTIFIER_INVERTER: return createRectifierInverter();
			case WirePackage.REGULATION_SCHEDULE: return createRegulationSchedule();
			case WirePackage.STATIC_VAR_COMPENSATOR: return createStaticVarCompensator();
			case WirePackage.SWITCH: return createSwitch();
			case WirePackage.TAP_CHANGER: return createTapChanger();
			case WirePackage.POWER_TRANSFORMER: return createPowerTransformer();
			case WirePackage.TRANSFORMER_WINDING: return createTransformerWinding();
			case WirePackage.LINE: return createLine();
			case WirePackage.VOLTAGE_CONTROL_ZONE: return createVoltageControlZone();
			case WirePackage.WINDING_TEST: return createWindingTest();
			case WirePackage.SYNCHRONOUS_MACHINE: return createSynchronousMachine();
			case WirePackage.MV_AR_CAPABILITY_CURVE: return createMVArCapabilityCurve();
			case WirePackage.EQUIVALENT_SOURCE: return createEquivalentSource();
			case WirePackage.WIRE_TYPE: return createWireType();
			case WirePackage.WIRE_ARRANGEMENT: return createWireArrangement();
			case WirePackage.LOAD_BREAK_SWITCH: return createLoadBreakSwitch();
			case WirePackage.JUNCTION: return createJunction();
			case WirePackage.ENERGY_CONSUMER: return createEnergyConsumer();
			case WirePackage.CONNECTOR: return createConnector();
			case WirePackage.GROUND_DISCONNECTOR: return createGroundDisconnector();
			case WirePackage.COMPOSITE_SWITCH: return createCompositeSwitch();
			case WirePackage.WIRES_VERSION: return createWiresVersion();
			case WirePackage.FREQUENCY_CONVERTER: return createFrequencyConverter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACLineSegment createACLineSegment() {
		ACLineSegmentImpl acLineSegment = new ACLineSegmentImpl();
		return acLineSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Breaker createBreaker() {
		BreakerImpl breaker = new BreakerImpl();
		return breaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusbarSection createBusbarSection() {
		BusbarSectionImpl busbarSection = new BusbarSectionImpl();
		return busbarSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compensator createCompensator() {
		CompensatorImpl compensator = new CompensatorImpl();
		return compensator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conductor createConductor() {
		ConductorImpl conductor = new ConductorImpl();
		return conductor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConductorType createConductorType() {
		ConductorTypeImpl conductorType = new ConductorTypeImpl();
		return conductorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DCLineSegment createDCLineSegment() {
		DCLineSegmentImpl dcLineSegment = new DCLineSegmentImpl();
		return dcLineSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Disconnector createDisconnector() {
		DisconnectorImpl disconnector = new DisconnectorImpl();
		return disconnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fuse createFuse() {
		FuseImpl fuse = new FuseImpl();
		return fuse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ground createGround() {
		GroundImpl ground = new GroundImpl();
		return ground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeatExchanger createHeatExchanger() {
		HeatExchangerImpl heatExchanger = new HeatExchangerImpl();
		return heatExchanger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jumper createJumper() {
		JumperImpl jumper = new JumperImpl();
		return jumper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RectifierInverter createRectifierInverter() {
		RectifierInverterImpl rectifierInverter = new RectifierInverterImpl();
		return rectifierInverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegulationSchedule createRegulationSchedule() {
		RegulationScheduleImpl regulationSchedule = new RegulationScheduleImpl();
		return regulationSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticVarCompensator createStaticVarCompensator() {
		StaticVarCompensatorImpl staticVarCompensator = new StaticVarCompensatorImpl();
		return staticVarCompensator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Switch createSwitch() {
		SwitchImpl switch_ = new SwitchImpl();
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TapChanger createTapChanger() {
		TapChangerImpl tapChanger = new TapChangerImpl();
		return tapChanger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerTransformer createPowerTransformer() {
		PowerTransformerImpl powerTransformer = new PowerTransformerImpl();
		return powerTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformerWinding createTransformerWinding() {
		TransformerWindingImpl transformerWinding = new TransformerWindingImpl();
		return transformerWinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line createLine() {
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoltageControlZone createVoltageControlZone() {
		VoltageControlZoneImpl voltageControlZone = new VoltageControlZoneImpl();
		return voltageControlZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindingTest createWindingTest() {
		WindingTestImpl windingTest = new WindingTestImpl();
		return windingTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousMachine createSynchronousMachine() {
		SynchronousMachineImpl synchronousMachine = new SynchronousMachineImpl();
		return synchronousMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MVArCapabilityCurve createMVArCapabilityCurve() {
		MVArCapabilityCurveImpl mvArCapabilityCurve = new MVArCapabilityCurveImpl();
		return mvArCapabilityCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentSource createEquivalentSource() {
		EquivalentSourceImpl equivalentSource = new EquivalentSourceImpl();
		return equivalentSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireType createWireType() {
		WireTypeImpl wireType = new WireTypeImpl();
		return wireType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WireArrangement createWireArrangement() {
		WireArrangementImpl wireArrangement = new WireArrangementImpl();
		return wireArrangement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBreakSwitch createLoadBreakSwitch() {
		LoadBreakSwitchImpl loadBreakSwitch = new LoadBreakSwitchImpl();
		return loadBreakSwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Junction createJunction() {
		JunctionImpl junction = new JunctionImpl();
		return junction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnergyConsumer createEnergyConsumer() {
		EnergyConsumerImpl energyConsumer = new EnergyConsumerImpl();
		return energyConsumer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroundDisconnector createGroundDisconnector() {
		GroundDisconnectorImpl groundDisconnector = new GroundDisconnectorImpl();
		return groundDisconnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSwitch createCompositeSwitch() {
		CompositeSwitchImpl compositeSwitch = new CompositeSwitchImpl();
		return compositeSwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WiresVersion createWiresVersion() {
		WiresVersionImpl wiresVersion = new WiresVersionImpl();
		return wiresVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FrequencyConverter createFrequencyConverter() {
		FrequencyConverterImpl frequencyConverter = new FrequencyConverterImpl();
		return frequencyConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WirePackage getWirePackage() {
		return (WirePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static WirePackage getPackage() {
		return WirePackage.eINSTANCE;
	}

} //WireFactoryImpl
