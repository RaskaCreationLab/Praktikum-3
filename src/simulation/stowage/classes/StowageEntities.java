/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.stowage.classes;

import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value.interfaces.Mass;
import simulation.stowage.interfaces.Bounded3DimStack;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.ContainerStowage;
import simulation.stowage.interfaces.Pallet;

/**
 *
 * @author Ralf
 */
public class StowageEntities {
    
    private StowageEntities(){
        
    }
    
    public static final Container NULL_CONTAINER = nullContainer();
    public static final Container NON_CONTAINER = nonContainer();
    public static final Pallet NULL_PALLET = nullPallet();
    
    //<editor-fold desc="Container">
    public static Container nullContainer() {
        return NullContainer.valueOf();
    }
    public static Container container20Ft(StowageLocation loc) {
        return ContainerImpl.valueOf();
    }
    public static Container nonContainer() {
        return NonContainer.valueOf();
    }
    //</editor-fold>
    //<editor-fold desc="Container">
    public static Pallet nullPallet() {
        return NullPallet.valueOf();
    }
    public static Pallet pallet1000X1200(Mass mass) {
        return PalletImpl.valueOf(mass);
    }
    //</editor-fold>
    public static ContainerStowage containerStowage(int bays, int rows, int tiers, BoundingBox bounds) {
        return ContainerStowageImpl.valueOf(bays, rows, tiers, bounds);
    }
}
