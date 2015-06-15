package simulation.entities.vehicle_classes;

import simulation.adt.physics_value.interfaces.Speed;
import simulation.entities.component_interfaces.Ship;
import simulation.entities.component_interfaces.ShipEngine;
import simulation.entities.component_interfaces.ShipHull;


public abstract class AbstractShip implements Ship {
	
	protected ShipHull shipHull;
	protected ShipEngine engine;
	protected Speed maxSpeed;
	
	protected AbstractShip(ShipHull shipHull,ShipEngine engine,Speed maxSpeed){
		this.shipHull=shipHull;
		this.engine=engine;
		this.maxSpeed=maxSpeed;
	}

}
