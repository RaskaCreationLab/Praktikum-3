/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.stowage.classes;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.stowage.interfaces.Bounded3DimStack;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.Pallet;
import simulation.stowage.interfaces.WithForm;

/**
 * @param <E> kind of Objects stored in this Stack
 */
public class Bounded3DimStackImpl<E extends WithForm> implements Bounded3DimStack<E> {

    ArrayList<ArrayList<ArrayList<E>>> stack;
    final int rows;
    final int bays;
    final int tiers;
    
    private Bounded3DimStackImpl(Class<E> kindOfObjects, int rows, int bays, int tiers) {
        this.rows = rows;
        this.bays  = bays;
        this.tiers = tiers;
        try { 
            initialize(kindOfObjects);
        } catch(InvalidClassException e){
            
        }
    }
    
    public static Bounded3DimStackImpl valueOf(Class kindOfObjects, int bays, int rows, int tiers) {
        return new Bounded3DimStackImpl(kindOfObjects, bays, rows, tiers);
    }
    
    private void initialize(Class<E> kindOfObjects) throws InvalidClassException {
        this.stack = new ArrayList<>();
        
        for(int i = 0; i != rows; i++) {
            this.stack.add(new ArrayList<>());
                for(int j = 0; j != bays; j++) {
                    this.stack.get(i).add(new ArrayList<>());
                        for(int k = 0; k != tiers; k++) {
                            this.stack.get(i).get(j).add(getNullObject(kindOfObjects));
                        }
                }
        }
    }
    
    private E getNullObject(Class<E> kindOfObjects) throws InvalidClassException {
        if (kindOfObjects.equals(Container.class) ||
            kindOfObjects.isInstance(Container.class))
            return (E)StowageEntities.NULL_CONTAINER;
        else if (kindOfObjects.equals(Pallet.class) ||
            kindOfObjects.isInstance(Pallet.class))
            return (E)StowageEntities.NULL_PALLET;
        throw new InvalidClassException("Unknown Type!");
    }
   
    @Override
    public boolean isEmpty() {
        for(int b = 0; b < bays; b++) {
            for(int r = 0; r < rows; r++) {
                if(!tierIsEmpty(b, r)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isFull() {
        for(int b = 0; b < bays; b++) {
            for(int r = 0; r < rows; r++) {
                if(!tierIsFull(b, r)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        ArrayList <E> tierList = stack.get(bay).get(row);
        Collections.reverse(tierList);
        for(E elem : tierList) {
            if(elem.isFree())
                return false;
        }
        return true;
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        ArrayList <E> tierList = stack.get(bay).get(row);
        for(E elem : tierList) {
            if(elem.isOccupied())
                return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object elem) {
        for(ArrayList<ArrayList<E>> rowList : stack) {
            for(ArrayList<E> tierList : rowList) {
                tierList.contains(elem);
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> coll) {
        for(Object elem : coll) {
            if(!contains(elem)) 
                return false;
        }
        return true;
    }

    @Override
    public E get(StowageLocation loc) {
        return stack.get(loc.bay()).get(loc.row()).get(loc.tier());
    }

    @Override
    public Set<E> getAll() {
        HashSet<E> result = new HashSet<>();
        for(ArrayList<ArrayList<E>> rowList : stack) {
            for(ArrayList<E> tierList : rowList) {
                for(E elem : tierList) {
                    result.add(elem);
                }
            }
        }
        return result;
    }

    @Override
    public StowageLocation locationOf(E elem) {
        for(int b = 0; b < bays; b++){
            for(int r = 0; r < rows; r++) {
                for(int t = 0; t < tiers; t++) {
                    if (stack.get(b).get(r).get(t) == elem)
                        return AdminValues.stowageLocation(b, r, t);
                }
            }
        }
        return AdminValues.NULL_LOCATION;
    }
    
    @Override
    public void load(int bayNo, int rowNo, E elem) {
        ArrayList<E> tierList = stack.get(bayNo).get(rowNo);
        for (int t = 0; t < tiers; t++) {
            if(tierList.get(t).isFree()){
                tierList.set(t, elem);
                return;
            }
        }
        throw new IllegalArgumentException("Tier is full! Object could not be loaded.");
    }

    @Override
    public void load(E elem) {
        for(ArrayList<ArrayList<E>> rowList : stack) {
            for(ArrayList<E> tierList : rowList) {
                for(int t = 0; t < tiers; t++) {
                    if(tierList.get(t).isFree()) {
                        tierList.set(t, elem);
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Stowage is full! Object could not be loaded.");
    }

    @Override
    public void loadAll(Collection<? extends E> coll) {
        for(E elem : coll) {
            try {
                load(elem);
            } catch(IllegalArgumentException e) {
                throw new IllegalArgumentException("Stowage is full! Some objects could not be loaded.");
            }
        }
    }

    
}
