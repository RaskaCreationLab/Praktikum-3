package simulation.stowage.interfaces;

public interface Container extends Stowage<Pallet>, /*WithUniqueId,*/ WithStowLoc, WithForm, Comparable<Container>{    
    @Override
    public boolean isFree();  
}
