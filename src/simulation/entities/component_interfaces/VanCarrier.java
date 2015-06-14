package simulation.entities.component_interfaces;

import simulation.stowage.interfaces.ContainerStowage;
import simulation.stowage.interfaces.WithCargo;

public interface VanCarrier extends Vehicle, WithCargo, ContainerStowage, Comparable<VanCarrier> {

}
