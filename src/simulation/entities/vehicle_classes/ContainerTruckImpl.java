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
import simulation.entities.component_interfaces.ContainerTruck;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.Vehicle;

public class ContainerTruckImpl extends AbstractContainerCar implements ContainerTruck{

    protected ContainerTruckImpl(ShipEngine engine, Speed maxSpeed,
			Mass emptyMass) {
        super(engine, maxSpeed, emptyMass, 1, 1, 1);
    }

    public static ContainerTruck valueOf(ShipEngine engine, Speed maxSpeed,
			Mass emptyMass){
	return new ContainerTruckImpl(engine, maxSpeed, emptyMass);
    }

    @Override
    public Mass mass() {
        Mass mass = emptyMass();
        for(Container c : getAll()) {
            mass = mass.add(c.);
        }
        return mass;
    }

    @Override
    public BoundingBox boundingBox() {
            
    }
    @Override
    public boolean isEmpty() {
        return stowage.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stowage.isFull();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void load(int bayNo, int rowNo, simulation.stowage.interfaces.Container elem) {
        stowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(simulation.stowage.interfaces.Container elem) {
        stowage.load(elem);
    }

    @Override
    public void loadAll(Collection<? extends simulation.stowage.interfaces.Container> coll) {
        stowage.loadAll(coll);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return stowage.tierIsFull(bay, row);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return stowage.tierIsEmpty(bay, row);
    }

    @Override
    public boolean contains(Object elem) {
        return stowage.contains(elem);
    }

    @Override
    public boolean containsAll(Collection<? extends simulation.stowage.interfaces.Container> coll) {
        return stowage.containsAll(coll);
    }

    @Override
    public simulation.stowage.interfaces.Container get(StowageLocation loc) {
        return (simulation.stowage.interfaces.Container)stowage.get(loc);
    }

    @Override
    public Set<simulation.stowage.interfaces.Container> getAll() {
        return stowage.getAll();
    }

    @Override
    public StowageLocation locationOf(simulation.stowage.interfaces.Container elem) {
        return elem.loc();
    }   
    
    @Override
    public BoundingBox boundingBox() {
        return boundingBox;
    }
}
