package simulation.stowage.interfaces;

import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.marker.interfaces.Mutable;

public interface WithStowLoc<S extends Stowage<?>> extends Mutable{
    public StowageLocation loc();
    public void setLocNull();   
    public void setLoc(S stowage, StowageLocation loc);
}
