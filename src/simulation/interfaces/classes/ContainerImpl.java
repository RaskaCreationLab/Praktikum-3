/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.interfaces.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import simulation.adt.admin_value.classes.StowageLocationImpl;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.interfaces.Container;
import simulation.interfaces.Pallet;

/**
 *
 * @author Zujiry
 */
public class ContainerImpl implements Container{
        
    StowageLocation loc;
    ArrayList<ArrayList<ArrayList<Pallet>>> stack;
    final int groesseLaenge;
    final int groesseBreite;
    final int groesseHoehe;
    
    private ContainerImpl(StowageLocation loc, int laenge, int breite, int hoehe) {
        this.loc = loc;
        
        this.groesseLaenge  = laenge;
        this.groesseBreite  = breite;
        this.groesseHoehe = hoehe;
        
        this.stack = new ArrayList<>();
        
        for(int i = 0; i != groesseLaenge; i++) {
            this.stack.add(new ArrayList<>());
                for(int j = 0; j != groesseBreite; j++) {
                    this.stack.get(i).add(new ArrayList<>());
                        for(int k = 0; k != groesseHoehe; k++) {
                            this.stack.get(i).get(j).add(new NullPallet());
                        }
                }
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /////////////////
    @Override
    public void load(int bayNo, int rowNo, Pallet elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(Pallet elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadAll(Collection<? extends Pallet> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tierIsFull(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tierIsEmpty(int bay, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<? extends Pallet> coll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Pallet get(StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Pallet> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StowageLocation locationOf(Pallet elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ////////////////////////////
    
    @Override
    public StowageLocation loc() {
            return loc;
    }

    @Override
    public void setLocNull() {
        this.setLoc(kram,StowageLocationImpl.valueOf(0,0,0,true));
    }

    @Override
    public void setLoc(Object stowage, StowageLocation location) {
        this.loc = location;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Container t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
