package simulation.entities.vehicle_classes;

import java.util.Collection;
import java.util.Set;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.entities.component_interfaces.ContainerShip;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.ShipHull;
import simulation.stowage.interfaces.ContainerStowage;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Length;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.TimeDiff;
import simulation.entities.component_interfaces.Vehicle;
import simulation.stowage.interfaces.Container;

public class ContainerShipImpl extends AbstractShip implements ContainerShip {

	private final UniqueId id;
	private final ContainerStowage containerStowage;
	
	protected ContainerShipImpl(ShipHull hull, ShipEngine engine,
			Speed maxSpeed , ContainerStowage containerStowage) {
		
		super(shipHull, engine, maxSpeed);
		this.id=UniqueId();
		this.containerStowage=containerStowage;
		
	}
	public static ContainerShip valueOf(ShipHull hull, ShipEngine engine,Speed maxSpeed , ContainerStowage containerStowage){
		return new ContainerShipImpl(hull,engine,maxSpeed,containerStowage);
		
	}
	public static ContainerShip valueOf(ShipHull hull, ShipEngine engine,Speed maxSpeed,int bays,int rows,int tiers){
	   return new ContainerShipImpl(hull,engine,maxSpeed,containerStowage(bays,rows,tiers));
		
	}
	public boolean isEmpty(){return containerStowage.isEmpty();}
	
	public boolean isFull(){return containerStowage.isFull();}
	
	public boolean tier_isEmpty(int bay,int row){return containerStowage.tier_isEmpty(bay,row);}
	
	public boolean tier_isFull(int bay,int row){ return containerStowage.tier_isFull(bay,row);}
	
	public boolean contains(Object elem){return containerStowage.contains(elem);}
	
	public boolean containsAll(Collection<?> coll){return containerStowage.containsAll(coll);}
	
	public Container get(StowageLocation loc){return containerStowage.get(loc);}
	
	public Set<Container> getAll(){return containerStowage.getAll();}
	
	public StowageLocation locationOf(Container elem){return containerStowage.locationOf(elem);	}
	
	public void load(int bay_No,int row_No,Container elem ){return containerStowage.load(bay_No,row_No,elem);}
	
	public void load(Collection<? extends Container>coll){containerStowage.load(coll);}
	
	@Override
	public Mass mass() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public BoundingBox boundingBox() {throw new UnsupportedOperationException("Not Supported");}

	@Override
	public UniqueId id() {return id;}

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
	
	public Mass emptyMass(){throw new UnsupportedOperationException("Not Supported");}

    @Override
    public int compareTo(Vehicle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mass maxMass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(Container elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAll(Collection<? extends Container> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<? extends Container> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
