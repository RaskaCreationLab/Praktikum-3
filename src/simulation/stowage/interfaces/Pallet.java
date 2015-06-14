package simulation.stowage.interfaces;

import simulation.entities.aspect_interfaces.WithUniqueId;
import simulation.entities.component_interfaces.Body;
import simulation.marker.interfaces.Immutable;

public interface Pallet extends Immutable, Body, WithUniqueId, WithStowLoc<Stowage<Pallet>>, 
                                WithForm, Comparable<Pallet> {
    
}
