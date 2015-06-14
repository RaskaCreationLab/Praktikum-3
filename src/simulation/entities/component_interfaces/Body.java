package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.WithBoundingBox;
import simulation.entities.aspect_interfaces.WithMass;

public interface Body extends PhysObject,WithMass,WithBoundingBox {

}
