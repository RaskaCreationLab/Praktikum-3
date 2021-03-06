/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.admin_value.classes;

import simulation.adt.admin_value.interfaces.Name;

public class NameImpl implements Name{
    final String name;
    
    private NameImpl(String name) {
        this.name = name;
    }
    
    public static Name valueOf(String name) {
        return new NameImpl(name);
    }
    
    @Override
    public String nameString() {
        return name;
    }
}
