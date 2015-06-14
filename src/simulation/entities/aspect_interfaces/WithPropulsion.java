package simulation.entities.aspect_interfaces;

import simulation.adt.physics_value.interfaces.TimeDiff;


public interface WithPropulsion extends WithPower {
	
	public void moveStep(TimeDiff deltaTime);

}
