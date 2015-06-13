/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.interfaces.classes;

import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.interfaces.Pallet;

/**
 *
 * @author Ralf
 */
public class NullPallet implements Pallet {
    
    StowageLocation loc;
    UniqueId id;
    
    private NullPallet(StowageLocation loc) {
        id = Values.uniqueID();
    }
    
    public Mass mass() {
        return Values.ZERO_MASS;
    }

    @Override
    public UniqueId getId() {
        return id;
    }

    @Override
    public StowageLocation loc() {
        return loc;
    }

    @Override
    public void setLocNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoc(Object stowage, StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public int compareTo(Pallet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
