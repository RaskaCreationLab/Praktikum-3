package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.Mutable;
import simulation.entities.aspect_interfaces.WithPower;
import simulation.entities.aspect_interfaces.WithUniqueId;

public interface ShipEngine extends Mutable, Body, WithUniqueId, WithPower, Comparable<ShipEngine> {

}
