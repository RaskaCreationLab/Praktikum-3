package simulation.stowage.interfaces;

import simulation.marker.interfaces.Immutable;

public interface Pallet extends Immutable, /*Body,*/ WithUniqueId, WithStowLoc<Stowage<Pallet>>, 
                                WithForm, Comparable<Pallet> {
    
}
