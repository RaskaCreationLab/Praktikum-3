/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.physics_value.classes;

import simulation.adt.physics_value.interfaces.Angle;

public class AngleImpl extends AbstractValueImpl<Angle> implements Angle{

    private AngleImpl(double inValue) {
        super(inValue);
    }
    
    public static Angle valueOf(double inValue) {
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
    public Angle mul(double other) {
        return AngleImpl.valueOf(other * this.value());
    }

    @Override
    public Angle div(double other) {
        return AngleImpl.valueOf(this.value() / other);
    }   

    @Override
    public String toString() {
        return toString_EU();
    }
    
    public String toString_EU() {
        String text = this.value + "rad";
        return text;
    }
}
