package simulation.adt.physics_value.interfaces;

public interface Speed extends AbstractValue<Speed>{
    public Length mul(TimeDiff timediff);
    public Force forceDrag(Speed speedMax, Power powerPropMax);
}
