package simulation.adt.physics_value.classes;


import simulation.adt.physics_value.interfaces.Force;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.adt.physics_value.interfaces.Acc;
import simulation.adt.physics_value.interfaces.Work;
import simulation.adt.physics_value.interfaces.Length;

public class ForceImpl extends AbstractValueImpl<Force> implements Force{

    private ForceImpl(double inValue) {
        super(inValue);
    }
    
    public static Force valueOf(double inValue) {
        return new ForceImpl(inValue);
    }

    @Override
    public Force fromPrototype(double value) {
        return valueOf(value);
    }
    
    @Override
    public boolean checkInstance(Object other) {
         return other instanceof Force;
    }
    
    @Override
    public Force mul(double other) {
        return ForceImpl.valueOf(other * this.value());
    }
   
    @Override
    public Work mul(Length other) {
        return WorkImpl.valueOf(other.value() * this.value());
    }
    
    @Override
    public Force div(double other) {
        return ForceImpl.valueOf(this.value() / other);
    }   
    
    public Acc div(Mass other) {
       return AccImpl.valueOf(this.value() / other.value());
    }
    
    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "N";
        return text;
    }
}