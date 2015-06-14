/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.stowage.classes;

import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.Pallet;
import simulation.stowage.interfaces.Stowage;

/**
 *
 * @author Ralf
 */
public class NullPallet implements Pallet {
    
    UniqueId id;
    
    static NullPallet pallet = null;
    
    private NullPallet() {
        id = AdminValues.uniqueID();
    }
    
    public static NullPallet valueOf() {
        if(pallet == null)
            pallet = new NullPallet();
        return pallet;
    }
    
    public Mass mass() {
        return Values.ZERO_MASS;
    }

    @Override
    public UniqueId id() {
        return id;
    }
    
    public BoundingBox boundingBox() {
        return Values.NULL_BOUNDING_BOX;
    }

    @Override
    public StowageLocation loc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocNull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLoc(Stowage<Pallet> stowage, StowageLocation loc) {
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
