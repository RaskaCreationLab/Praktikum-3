/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.admin_value.classes;

import simulation.adt.admin_value.interfaces.UniqueId;

/**
 *
 * @author Zujiry
 */
public class UniqueIdImpl implements UniqueId{
    long idNumber;
    
    private UniqueIdImpl(long idNumber) {
        this.idNumber = idNumber;
    }
    
    public static UniqueIdImpl valueOf(long idNumber) {
        return new UniqueIdImpl(idNumber);
    }
    
    @Override
    public long idNumber() {
        return idNumber;
    }
}
