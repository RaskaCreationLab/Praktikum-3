package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.Mutable;
import simulation.entities.aspect_interfaces.WithMass;
import simulation.entities.aspect_interfaces.WithPosition;
import simulation.entities.aspect_interfaces.WithSpeed;

public interface Particle extends Mutable,PhysObject,WithMass,WithPosition,WithSpeed {

}
