package simulation.entities.component_interfaces;

import simulation.stowage.interfaces.ContainerStowage;
import simulation.stowage.interfaces.WithCargo;



public interface ContainerShip extends Ship, WithCargo, ContainerStowage {

}
