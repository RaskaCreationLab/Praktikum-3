/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.admin_value.classes;

import simulation.adt.admin_value.interfaces.Name;
import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.adt.admin_value.interfaces.UniqueId;

/**
 *
 * @author Ralf
 */
public class AdminValues {
    private AdminValues() {
        
    }
    
    public static final StowageLocation NULL_LOCATION = nullLocation();
    
    //<editor-fold desc="Name">
    public static Name name(String name) {
        return NameImpl.valueOf(name);
    }
    //</editor-fold>
    //<editor-fold desc="UniqueId">
    public static UniqueId uniqueID() {
        return UniqueIdImpl.valueOf();
    }
    //</editor-fold>
    //<editor-fold desc="StowageLocation - bay, row, tier">
    public static StowageLocation stowageLocation(int bay, int row, int tier) {
        return StowageLocationImpl.valueOf(bay, row, tier);
    }
    public static StowageLocation nullLocation() {
        return NullLocationImpl.valueOf();
    }
    //</editor-fold>
}
