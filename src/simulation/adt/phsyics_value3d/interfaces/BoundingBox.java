
package simulation.adt.phsyics_value3d.interfaces;

import simulation.adt.physics_value.interfaces.AbstractValue;
import simulation.adt.physics_value.interfaces.Length;
import simulation.marker.interfaces.PhysicsValue;

public interface BoundingBox extends PhysicsValue {
    Length length();
    Length width();
    Length height();
    
    boolean fitsInto(BoundingBox bos);
}
