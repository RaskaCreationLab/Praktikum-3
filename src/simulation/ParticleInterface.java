/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import simulation.adt.physics_value.interfaces.*;

public interface ParticleInterface {
    Length getPosX();
    Length getPosY();
    double getPropLevel();
    double getBrakeLevel();
    double getSteeringLevel();
    Speed getSpeed();
    double getTraction();
    boolean getABS();
    boolean getASR();
    boolean getLostControl();
    
    void setTraction(double newTraction);
    void setABS(boolean newAbsState);
    void setASR(boolean newAsrState);
    void setPropLevel(double newPropLevel);
    void setBrakeLevel(double newBrakeLevel);
    void setSteeringLevel(double newSteeringLevel);
    void set(TimeDiff newTime, Length newPosX, Length newPosY, Speed newSpeed, double newPropLevel, double newBrakeLevel);
    void setLostControl(boolean hasLostControl);
    
    void step(TimeDiff aDeltaTime);
    
    public Angle getDirection();
}
