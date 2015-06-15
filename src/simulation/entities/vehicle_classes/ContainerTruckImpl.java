package simulation.entities.vehicle_classes;

import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Length;
import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.TimeDiff;
import simulation.entities.component_interfaces.ContainerTruck;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.Vehicle;

public class ContainerTruckImpl extends AbstractContainerCar<ContainerTruck> implements ContainerTruck {

    protected ContainerTruckImpl(ShipEngine engine, Speed maxSpeed, Mass emptyMass, BoundingBox bounds) {
        super(engine, maxSpeed, emptyMass, bounds, 1, 1, 1);
    }

    public static ContainerTruck valueOf(ShipEngine engine, Speed maxSpeed, Mass emptyMass, BoundingBox bounds) {
	return new ContainerTruckImpl(engine, maxSpeed, emptyMass, bounds);
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