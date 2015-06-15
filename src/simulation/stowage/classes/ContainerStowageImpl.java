package simulation.stowage.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import simulation.adt.admin_value.classes.StowageLocationImpl;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.ContainerStowage;

public class ContainerStowageImpl implements ContainerStowage{
    
    Bounded3DimStackImpl stowage;
    BoundingBox boundingBox;
    
    private ContainerStowageImpl(int bays, int rows, int tiers, BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
        stowage = Bounded3DimStackImpl.valueOf(Container.class, bays, rows, tiers);
    }
    
    public static ContainerStowage valueOf(int bays, int rows, int tiers, BoundingBox boundingBox) {
        return new ContainerStowageImpl(bays, rows, tiers, boundingBox);
    }
       
    @Override
    public Mass emptyMass() {
        return Values.massInKG(2280.0);
    }

    @Override
    public Mass maxMass() {
        return Values.massInKG(24000.0);
    }
    
    public Mass mass() {
        Mass mass = emptyMass();
        for(Container c : getAll()) {
            mass = mass.add(c.mass());
        }
        return mass;
    }

    @Override
    public boolean isEmpty() {
        return stowage.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stowage.isFull();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void load(int bayNo, int rowNo, Container elem) {
        stowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Container elem) {
        stowage.load(elem);
    }

    @Override
    public void loadAll(Collection<? extends Container> coll) {
        stowage.loadAll(coll);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return stowage.tierIsFull(bay, row);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return stowage.tierIsEmpty(bay, row);
    }

    @Override
    public boolean contains(Object elem) {
        return stowage.contains(elem);
    }

    @Override
    public boolean containsAll(Collection<? extends Container> coll) {
        return stowage.containsAll(coll);
    }

    @Override
    public Container get(StowageLocation loc) {
        return (Container)stowage.get(loc);
    }

    @Override
    public Set<Container> getAll() {
        return stowage.getAll();
    }

    @Override
    public StowageLocation locationOf(Container elem) {
        return elem.loc();
    }   
    
    @Override
    public BoundingBox boundingBox() {
        return boundingBox;
    }
}
