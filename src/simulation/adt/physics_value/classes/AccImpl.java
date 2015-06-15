package simulation.adt.physics_value.classes;

import simulation.adt.physics_value.interfaces.Acc;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Force;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.adt.physics_value.interfaces.TimeDiff;

public class AccImpl extends AbstractValueImpl<Acc> implements Acc{

    private AccImpl(double inValue) {
        super(inValue);
    }
    
    public static Acc valueOf(double inValue) {
        return new AccImpl(inValue);
    }

    @Override
    public Acc fromPrototype(double value) {
        return valueOf(value);
    }
    
    @Override
    public boolean checkInstance(Object other) {
         return other instanceof Acc;
    }
    
    @Override
    public Acc mul(double other) {
        return AccImpl.valueOf(other * this.value());
    }
    
    @Override
    public Speed mul(TimeDiff other) {
        return SpeedImpl.valueOf(other.value() * this.value());
    }

    @Override
    public Acc div(double other) {
        return AccImpl.valueOf(this.value() / other);
    }   
    
    @Override
    public Mass div(Force other) {
        return MassImpl.valueOf(this.value() / other.value());
    }
    
    @Override
    public Force div(Mass other) {
        return ForceImpl.valueOf(this.value() / other.value());
    }
    
    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "m/s²";
        return text;
    }
}