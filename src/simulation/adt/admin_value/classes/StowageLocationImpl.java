/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.admin_value.classes;

import simulation.adt.admin_value.interfaces.StowageLocation;
import simulation.marker.interfaces.AdminValue;

/**
 *
 * @author Zujiry
 */
public class StowageLocationImpl implements StowageLocation{
    final int bay;
    final int row;
    final int tier;
    
    private StowageLocationImpl(int bay, int row, int tier){
        this.bay = bay;
        this.row = row;
        this.tier = tier;
    }
    
    public static StowageLocation valueOf(int bay, int row, int tier) {
        return new StowageLocationImpl(bay, row, tier);
    }
    
    @Override
    public int bay(){
        return bay;
    }
    
    @Override
    public int row() {
        return row;
    }
    
    @Override
    public int tier(){
        return tier;
    }
    
    @Override
    public boolean isNull() {
        return true;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StowageLocationImpl other = (StowageLocationImpl) obj;
        if (this.bay != other.bay) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.tier != other.tier) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.bay;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.tier;
        return hash;
    }

}
