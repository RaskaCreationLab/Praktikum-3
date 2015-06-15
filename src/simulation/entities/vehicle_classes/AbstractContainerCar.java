package simulation.entities.vehicle_classes;

import java.awt.Container;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.stowage.classes.Bounded3DimStackImpl;
import simulation.stowage.classes.ContainerStowageImpl;
import simulation.stowage.interfaces.ContainerStowage;


public abstract class AbstractContainerCar {
        protected UniqueId id;
	protected ShipEngine engine;
	protected Speed maxSpeed;
	protected Mass emptyMass;
        protected ContainerStowage stowage;
//	protected  int bays;
//	protected  int rows;
//	protected  int tiers;
//	private ArrayList<ArrayList<ArrayList<Container>>> containerStowage;
	
	protected  AbstractContainerCar(ShipEngine engine, Speed maxSpeed, Mass emptyMass, int bays, int rows, int tiers){
		this.id = AdminValues.uniqueID();
		this.engine=engine;
		this.maxSpeed=maxSpeed;
		this.emptyMass=emptyMass;
                stowage = ContainerStowageImpl.valueOf(bays, rows, tiers, boundingBox);
		reset();
		
	}
	public abstract void reset();
        public UniqueId id() {
            return id;
        }
        
        public Mass emptyMass() {
            return emptyMass;
        }
		
}
