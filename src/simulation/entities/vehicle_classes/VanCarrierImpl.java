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

public class VanCarrierImpl extends AbstractContainerCar<VanCarrier> implements VanCarrier {

	protected VanCarrierImpl(ShipEngine engine, Speed maxSpeed, Mass emptyMass, BoundingBox bounds) {
		super(engine, maxSpeed, emptyMass, bounds, 1, 1, 1);
	}
        
	public static VanCarrier valueOf(ShipEngine engine, Speed maxSpeed, Mass emptyMass, BoundingBox bounds){
		return new VanCarrierImpl(engine,maxSpeed, emptyMass, bounds);
	}

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Length pos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power power() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power maxPower() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLevel(double level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveStep(TimeDiff deltaTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Vehicle t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


