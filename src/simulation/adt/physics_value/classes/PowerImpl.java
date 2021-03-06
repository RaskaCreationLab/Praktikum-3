package simulation.adt.physics_value.classes;

import simulation.adt.physics_value.interfaces.Power;
import simulation.adt.physics_value.interfaces.TimeDiff;
import simulation.adt.physics_value.interfaces.Force;
import simulation.adt.physics_value.interfaces.Work;
import simulation.adt.physics_value.interfaces.Speed;

class PowerImpl extends AbstractValueImpl<Power> implements Power{

    private PowerImpl(double inValue) {
        super(inValue);
    }
    
    static Power valueOf(double inValue) {
        return new PowerImpl(inValue);
    }

    @Override
    public Power fromPrototype(double value) {
        return valueOf(value);
    }
    
    @Override
    public boolean checkInstance(Object other) {
         return other instanceof Power;
    }
    
    @Override
    public Power mul(double other) {
        return PowerImpl.valueOf(other * this.value());
    }
    
    public Work mul(TimeDiff other) {
        return WorkImpl.valueOf(other.value() * this.value());
    }

    @Override
    public Power div(double other) {
        return PowerImpl.valueOf(this.value() / other);
    }   
    
    public Force div(TimeDiff other) {
        return ForceImpl.valueOf(this.value() / other.value());
    } 
    
    public Force div(Speed other) {
        return ForceImpl.valueOf(this.value() / other.value());
    }        
    
    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "W";
        return text;
    }
}