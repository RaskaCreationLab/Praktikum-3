/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.entities.component_interfaces;

import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.ContainerStowage;
import simulation.stowage.interfaces.WithCargo;


public interface AbstractContainerVehicle<E extends AbstractContainerVehicle> extends Vehicle, WithCargo, ContainerStowage {
    
}
