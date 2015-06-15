package simulation.entities.aspect_interfaces;

import simulation.adt.physics_value.interfaces.Angle;


public interface WithSteering {
	
	public Angle steeringAngle();
	public Angle courseAngle();
	public void setSteeringAngle(Angle angle);

}
