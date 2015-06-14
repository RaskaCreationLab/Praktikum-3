/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.admin_value.classes;

import simulation.adt.admin_value.interfaces.StowageLocation;

/**
 *
 * @author Zujiry
 */
public class NullLocationImpl implements StowageLocation{
    
    private static StowageLocation instance = null;
    
    public static StowageLocation valueOf() {
        if (instance == null)
            instance = new NullLocationImpl();
        
        return instance;
    }
    
    private NullLocationImpl() {
    }
    
    
    @Override
    public int bay() {
        throw new UnsupportedOperationException("nullLocation has no Position."); 
    }

    @Override
    public int row() {
        throw new UnsupportedOperationException("nullLocation has no Position.");
    }

    @Override
    public int tier() {
        throw new UnsupportedOperationException("nullLocation has no Position."); 
    }

    @Override
    public boolean isNull() {
        return true;
    }
    
}
