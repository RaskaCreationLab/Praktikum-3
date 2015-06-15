package simulation.entities.vehicle_classes;

import java.awt.Container;
import java.util.Collection;
import java.util.Set;

import simulation.adt.physics_value.interfaces.Length;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.adt.physics_value.interfaces.TimeDiff;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.VanCarrier;
import simulation.entities.component_interfaces.Vehicle;

public class VanCarrierImpl extends AbstractContainerCar implements VanCarrier {

	protected VanCarrierImpl(ShipEngine engine, Speed maxSpeed, Mass emptyMass,
			int bays, int rows, int tiers) {
		super(engine, maxSpeed, emptyMass, bays, rows, tiers);
		
	}
	public static VanCarrier valueOf(ShipEngine engine, Speed maxSpeed, Mass emptyMass,
			int bays, int rows, int tiers){
		return new VanCarrierImpl(engine,maxSpeed,emptyMass,bays,rows,tiers);
	}
	
	@Override
	public Mass mass() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public BoundingBox boundingBox() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public UniqueId id() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public Length pos() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public Power power() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public Power maxPower() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public void setLevel(double level) {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public void moveStep(TimeDiff deltaTime) {throw new UnsupportedOperationException("Not Supported");}

	public int compareTo(Vehicle arg0) {throw new UnsupportedOperationException("Not Supported");}

	public int compareTo(VanCarrier arg0) {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public void reset() {throw new UnsupportedOperationException("Not Supported");}
	
	public Mass emptyMass(){throw new UnsupportedOperationException("Not Supported");}
	
	public Mass maxMass(){throw new UnsupportedOperationException("Not Supported");}
	
	public boolean isEmpty(){throw new UnsupportedOperationException("Not Supported");}
	
	public boolean isFull(){throw new UnsupportedOperationException("Not Supported");}
	
	public boolean tierIsEmpty(int bay,int row){throw new UnsupportedOperationException("Not Supported");}
	
    public boolean tierIsFull(int bay,int row){throw new UnsupportedOperationException("Not Supported");}
    
    public boolean contains(Object elem){throw new UnsupportedOperationException("Not Supported");}
    
    public boolean containsAll(Collection<?>coll){throw new UnsupportedOperationException("Not Supported");}
    
    public Container get(StowageLocation loc){throw new UnsupportedOperationException("Not Supported");}
    
    public Set<Container> getAll(){throw new UnsupportedOperationException("Not Supported");}
    
    public StowageLocation locationOf(Container elem){throw new UnsupportedOperationException("Not Supported");}
    
    public void load(int bay_No,int row_No,Container elem){throw new UnsupportedOperationException("Not Supported");}
    
    public void load(Collection<? extends Container>coll){throw new UnsupportedOperationException("Not Supported");}

    @Override
    public void load(int bayNo, int rowNo, simulation.stowage.interfaces.Container elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(simulation.stowage.interfaces.Container elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAll(Collection<? extends simulation.stowage.interfaces.Container> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<? extends simulation.stowage.interfaces.Container> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public simulation.stowage.interfaces.Container get(StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Container> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StowageLocation locationOf(simulation.stowage.interfaces.Container elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public simulation.stowage.interfaces.Container get(StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<simulation.stowage.interfaces.Container> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


