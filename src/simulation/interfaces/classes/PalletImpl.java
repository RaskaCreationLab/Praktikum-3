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
public class PalletImpl implements Pallet {
    
    StowageLocation loc;
    UniqueId id;
    Mass mass;
    
    private PalletImpl(StowageLocation loc, Mass mass) {
        this.loc = loc;
        id = Values.uniqueID();
        this.mass = mass;
    }
    
    public Mass mass() {
        return mass;
    }
    
    @Override
    public StowageLocation loc() {
        return loc;
    }

    @Override
    public void setLocNull() {
        //loc = nullLoc; 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoc(Object stowage, StowageLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int compareTo(Pallet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UniqueId getId() {
        return id;
    }
    
}
