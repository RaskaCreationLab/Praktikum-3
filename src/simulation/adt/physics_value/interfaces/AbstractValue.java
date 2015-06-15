package simulation.adt.physics_value.interfaces;

public interface AbstractValue<E extends AbstractValue> extends Comparable<E> {
    //Mathematical standardoperations
    default public E add(E other) {
        return fromPrototype(this.value() + other.value());
    }
    
    default public E sub(E other) {
        return fromPrototype(this.value() - other.value());
    }
    
    public E mul(double d);
    public E div(double d);
    
    public E fromPrototype(double value);
    public double value();
    public boolean checkInstance(Object obj);
    
    default public E abs() {
        return this.fromPrototype(Math.abs(this.value()));
    }
    
    default public E signum() {
        return this.fromPrototype(Math.signum(this.value()));
    }
    
    @Override
    public String toString();
}
