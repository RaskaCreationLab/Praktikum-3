package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.Mutable;
import simulation.entities.aspect_interfaces.WithPosition;
import simulation.entities.aspect_interfaces.WithPower;
import simulation.entities.aspect_interfaces.WithPropulsion;
import simulation.entities.aspect_interfaces.WithUniqueId;

public interface Vehicle extends Mutable, Body, WithUniqueId, WithPosition, WithPower, 
                                 WithPropulsion, Comparable<Vehicle> {

}
