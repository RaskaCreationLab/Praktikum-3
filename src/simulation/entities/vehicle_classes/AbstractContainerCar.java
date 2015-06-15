package simulation.entities.vehicle_classes;

import java.util.Collection;
import java.util.Set;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.entities.component_interfaces.AbstractContainerVehicle;
import simulation.entities.component_interfaces.CarEngine;
import simulation.stowage.classes.ContainerStowageImpl;
import simulation.stowage.classes.StowageEntities;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.ContainerStowage;


public abstract class AbstractContainerCar<E extends AbstractContainerVehicle> implements AbstractContainerVehicle<E> {
    private final UniqueId id;
    private final CarEngine engine;
    private final Speed maxSpeed;
    private final Mass emptyMass;
    private final ContainerStowage stowage;
    private final BoundingBox bounds;
    
    protected  AbstractContainerCar(CarEngine engine, Speed maxSpeed, Mass emptyMass, BoundingBox bounds, int bays, int rows, int tiers){
        this.id = AdminValues.uniqueID();
	this.engine=engine;
	this.maxSpeed=maxSpeed;
	this.emptyMass=emptyMass;
        this.bounds = bounds;
        stowage = StowageEntities.containerStowage(bays, rows, tiers, Values.CONTAINER20FT_BOUNDING_BOX); //gibt mit der BoundingBox noch kein Sinn.
                
	reset();
    }
	
    public abstract void reset();
    
//<editor-fold desc="Vehicle">        
    @Override
    public UniqueId id() {
        return id;
    }
     
    @Override
    public Power power() {
        return engine.power();
    }
    
    @Override
    public Power maxPower() {
        return engine.maxPower();
    }
    
    @Override 
    public void setLevel(double level) {
        engine.setLevel(level);
    }
    
    @Override
    public Mass emptyMass() {
        return emptyMass;
    }
    
    @Override
    public Mass maxMass() {
        return stowage.maxMass().add(this.emptyMass());
    }
        
    @Override
    public Mass mass() {
        Mass mass = emptyMass();
        for(Container c : getAll()) {
            mass = mass.add(c.mass());
        }
        return mass;
    }
    
    @Override
    public BoundingBox boundingBox() {
        return bounds;
    }
    //</editor-fold>    
    //<editor-fold desc"stowage">  
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
    public void load(int bayNo, int rowNo, Container elem) {
        stowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Container elem) {
        stowage.load(elem);
    }

    @Override
    public void loadAll(Collection<? extends Container> coll) {
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
    public boolean containsAll(Collection<? extends Container> coll) {
        return stowage.containsAll(coll);
    }

    @Override
    public Container get(StowageLocation loc) {
        return (Container)stowage.get(loc);
    }

    @Override
    public Set<Container> getAll() {
        return stowage.getAll();
    }

    @Override
    public StowageLocation locationOf(Container elem) {
        return elem.loc();
    }   
    //</editor-fold>
    
		
}
