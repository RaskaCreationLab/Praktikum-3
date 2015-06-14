/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.stowage.classes;

import simulation.adt.admin_value.classes.AdminValues;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.Pallet;
import simulation.stowage.interfaces.Stowage;

/**
 *
 * @author Ralf
 */
public class PalletImpl implements Pallet {
    
    StowageLocation loc;
    Stowage stowage;
    UniqueId id;
    Mass mass;
    
    private PalletImpl(Mass mass) {
        id = AdminValues.uniqueID();
        this.mass = mass;
        loc = AdminValues.NULL_LOCATION;
    }
    
    public static PalletImpl valueOf(Mass mass) {
        return new PalletImpl(mass);
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
        loc = AdminValues.NULL_LOCATION;
    }

    @Override
    public void setLoc(Stowage<Pallet> stowage, StowageLocation loc) {
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
    public int compareTo(Pallet t) {
        return this.mass().compareTo(t.mass());
    }

    @Override
    public UniqueId id() {
        return id;
    }
    
    public BoundingBox boundingBox() {
        return Values.PALLET_BOUNDING_BOX;
    }
    
}
