package simulation.entities.vehicle_classes;

import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.entities.component_interfaces.ContainerShip;
import simulation.entities.component_interfaces.ContainerTruck;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.ShipHull;
import simulation.entities.component_interfaces.VanCarrier;
import simulation.stowage.classes.ContainerStowageImpl;
import simulation.stowage.interfaces.ContainerStowage;


public class Entities {
	
	//Utility Class
	private Entities(){
		
	}
	public static ContainerTruck countainerTruck(ShipEngine engine, Speed MaxSpeed, Mass emptyMass, BoundingBox bounds){
		return ContainerTruckImpl.valueOf(engine, MaxSpeed, emptyMass, bounds);	
	}
	public static VanCarrier vanCarrierTruck(ShipEngine engine,Speed maxSpeed,Mass emptyMass, BoundingBox bounds){
	    return VanCarrierImpl.valueOf(engine, maxSpeed, emptyMass, bounds);
	}
	public static ShipEngine shipEngine(BoundingBox boudingBox,Power maxPower){
		throw new UnsupportedOperationException("Not Supported");
		
	}
	public static ShipHull shipHull (BoundingBox boudingBox){
		throw new UnsupportedOperationException("Not Supported");
		
	}
	public static ContainerShip containerShip(ShipHull hull,ShipEngine engine,Speed maxSpeed,int bays,int rows,int tiers){
		
		return ContainerShipImpl.valueOf(hull,engine,maxSpeed,bays,rows,tiers);
	}
        
	public static XXXTypeShip xxxTypeShip(ShipHull hull, ShipEngine engine, Speed maxSpeed, int bays, int rows, int tiers){
		return XXXTypeShipImpl.valueOf(hull,engine,maxSpeed,bays,rows,tiers);
	}
	
	
}
