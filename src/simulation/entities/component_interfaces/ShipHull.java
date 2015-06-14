package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.Immutable;
import simulation.entities.aspect_interfaces.WithUniqueId;

public interface ShipHull extends Immutable, Body, WithUniqueId, Comparable<ShipHull> {

}
