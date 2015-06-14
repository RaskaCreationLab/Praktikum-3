package simulation.entities.aspect_interfaces;


public interface WithSteering {
	
	public Angle steeringAngle();
	public CourseAngle courseAngle();
	public void setSteeringAngle(Angle angle);

}
