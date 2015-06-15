package simulation.adt.physics_value.classes;

import static simulation.adt.physics_value.classes.Values.force;
import simulation.adt.physics_value.interfaces.Speed;
import simulation.adt.physics_value.interfaces.Acc;
import simulation.adt.physics_value.interfaces.Force;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.TimeDiff;
import simulation.adt.physics_value.interfaces.Length;
import simulation.adt.physics_value.interfaces.Power;

class SpeedImpl extends AbstractValueImpl<Speed> implements Speed{

    private SpeedImpl(double inValue) {
        super(inValue);
    }
    
    static Speed valueOf(double inValue) {
        return new SpeedImpl(inValue);
    }

    @Override
    public Speed fromPrototype(double value) {
        return valueOf(value);
    }
    
    @Override
    public boolean checkInstance(Object other) {
         return other instanceof Speed;
    }
    
    @Override
    public Force forceDrag(Speed speedMax, Power powerPropMax) {
        return force(Math.abs(powerPropMax.value() / Math.pow(speedMax.value(), 3.0)) * Math.pow(speedMax.value(), 2.0)).mul(-this.signum().value());
    }
    
    @Override
    public Speed mul(double other) {
        return SpeedImpl.valueOf(other * this.value);
    }
    
    @Override
    public Length mul(TimeDiff other) {
        return LengthImpl.valueOf(this.value() * other.value());
    }

    @Override
    public Speed div(double other) {
        return SpeedImpl.valueOf(this.value / other);
    }   
    
//    public Acc div(TimeDiff other) {
//        return AccImpl.valueOf(this.value / other.value());
//    }
    

    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "m/s";
        return text;
    }
}