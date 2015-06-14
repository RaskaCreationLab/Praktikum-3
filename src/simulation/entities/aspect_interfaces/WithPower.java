package simulation.entities.aspect_interfaces;

import simulation.adt.physics_value.interfaces.Power;

public interface WithPower {
	public Power power();
	public Power maxPower();
	public void setLevel(double level);

}
