package simulation.stowage.interfaces;

import simulation.entities.aspect_interfaces.WithUniqueId;

public interface Container extends Stowage<Pallet>, WithUniqueId, WithStowLoc, WithForm, Comparable<Container>{    
    @Override
    public boolean isFree();  
}
