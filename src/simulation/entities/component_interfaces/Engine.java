/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.entities.component_interfaces;

import simulation.entities.aspect_interfaces.Mutable;
import simulation.entities.aspect_interfaces.WithPower;
import simulation.entities.aspect_interfaces.WithUniqueId;

/**
 *
 * @author Ralf
 * @param <E>
 */
public interface Engine<E extends Engine> extends Mutable, Body, WithUniqueId, WithPower, Comparable<E> {
    
}
