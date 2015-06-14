/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.stowage.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.admin_value.classes.StowageLocationImpl;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.Bounded3DimStack;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.Pallet;
import simulation.stowage.interfaces.Stowage;

/**
 *
 * @author Zujiry
 */
public class ContainerImpl implements Container{
    
    UniqueId id;
    StowageLocation loc;
    Bounded3DimStack stowage;
    final Bounded3DimStack<Pallet> palletStowage;
    
    private ContainerImpl() {
        this.id = AdminValues.uniqueID();
        this.loc = AdminValues.NULL_LOCATION;
        this.stowage = null;
        this.palletStowage = Bounded3DimStackImpl.valueOf(Pallet.class, 2, 5, 2);
    }
    
    public static Container valueOf() {
        return new ContainerImpl();
    }

    @Override
    public Mass emptyMass() {
        return Values.massInKG(2280.0);
    }

    @Override
    public Mass maxMass() {
        return Values.massInKG(24000.0);
    }

    @Override
    public boolean isEmpty() {
        return palletStowage.isEmpty();
    }

    @Override
    public boolean isFull() {
        return palletStowage.isFull();
    }

    @Override
    public void load(int bayNo, int rowNo, Pallet elem) {
        palletStowage.load(bayNo, rowNo, elem);
    }

    @Override
    public void load(Pallet elem) {
        palletStowage.load(elem);
    }

    @Override
    public void loadAll(Collection<? extends Pallet> coll) {
        palletStowage.loadAll(coll);
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        return palletStowage.tierIsFull(bay, row);
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        return palletStowage.tierIsEmpty(bay, row);
    }

    @Override
    public boolean contains(Object elem) {
        return palletStowage.contains(elem);
    }

    @Override
    public boolean containsAll(Collection<? extends Pallet> coll) {
        return palletStowage.contains(coll);
    }
    
    @Override
    public Pallet get(StowageLocation loc) {
        return palletStowage.get(loc);
    }

    @Override
    public Set<Pallet> getAll() {
        return palletStowage.getAll();
    }

    @Override
    public StowageLocation locationOf(Pallet elem) {
        return palletStowage.locationOf(elem);
    }
    
    @Override
    public StowageLocation loc() {
            return loc;
    }

    @Override
    public void setLocNull() {
        this.loc = AdminValues.NULL_LOCATION;
    }
    
    @Override
    public void setLoc(Stowage stowage, StowageLocation loc) {
        this.loc = loc;
        this.stowage = stowage;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    public int compareTo(Container t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
