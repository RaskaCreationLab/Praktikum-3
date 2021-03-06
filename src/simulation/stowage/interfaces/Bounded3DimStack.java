package simulation.stowage.interfaces;

import java.util.Collection;
import java.util.Set;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.marker.interfaces.Mutable;

public interface Bounded3DimStack<E> extends Mutable{
    void load(int bayNo, int rowNo, E elem);
    void load(E elem);
    void loadAll(Collection<? extends E> coll);
    boolean isEmpty();
    boolean isFull();
    boolean tierIsFull(int bay,int row);
    boolean tierIsEmpty(int bay, int row);
    boolean contains(Object elem);
    boolean containsAll(Collection<? extends E> coll);
    E get(StowageLocation loc);
    Set<E> getAll();
    StowageLocation locationOf(E elem);
    
}
