package simulation.adt.physics_value.classes;

import simulation.adt.physics_value.interfaces.Angle;

class AngleImpl extends AbstractValueImpl<Angle> implements Angle{

    private AngleImpl(double inValue) {
        super(inValue);
    }
    
    static Angle valueOf(double inValue) {
        return new AngleImpl(inValue);
    }

    @Override
    public Angle fromPrototype(double value) {
        return valueOf(value);
    }
    
    @Override
    public boolean checkInstance(Object other) {
         return other instanceof Angle;
    }
    
    @Override
    public Angle add(Angle other) {
        return AngleImpl.valueOf(other.value() + this.value());
    }
    
    @Override
    public Angle mul(double other) {
        return AngleImpl.valueOf(other * this.value());
    }

    @Override
    public Angle div(double other) {
        return AngleImpl.valueOf(this.value() / other);
    }   
    
    @Override
    public Angle sub(Angle other) {
        return this.add(AngleImpl.valueOf(-other.value()));
    }     
    
    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "m";
        return text;
    }
}
