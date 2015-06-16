/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.adt.physics_value.classes;

import simulation.adt.physics_value.interfaces.*;
import simulation.adt.phsyics_value3d.interfaces.BoundingBox;
import simulation.adt.physics_value3d.classes.BoundingBoxImpl;
import simulation.adt.units.MassUnit;

public final class Values {
    static final double KILO = 1000.0;
    static final double MILLI = 0.001;
    static final double MIN_IN_SEC = 60.0;
    static final double MS_IN_KMH = 3.6;
    static final double KG_IN_G = 1000.0;
    static final double KG_IN_T = 0.001;
    static final double RAD_IN_DEG = 180.0 / Math.PI;
    static final double FEET_IN_M = 0.3048;
    
    public static final Length ZERO_LENGTH = length(0.0);
    public static final Mass ZERO_MASS = mass(0.0);
    public static final TimeDiff ZERO_TIMEDIFF = timeDiff(0.0);
    public static final Speed ZERO_SPEED = speed(0.0);
    public static final Force ZERO_FORCE = force(0.0);
    public static final Power ZERO_POWER = power(0.0);
    public static final Acc ZERO_ACC = acc(0.0);
    public static final Work ZERO_WORK = work(0.0);
    public static final Angle ZERO_ANGLE = angle(0.0);
    
    public static final BoundingBox PALLET_BOUNDING_BOX = palletBoundingBox();
    public static final BoundingBox CONTAINER20FT_BOUNDING_BOX = containerBoundingBox();
    public static final BoundingBox NULL_BOUNDING_BOX = nullBoundingBox();
    public static final Mass MASS_EMPTY_CONTAINER = mass(2280.0);
    public static final Mass MASS_MAX_CONTAINER = mass(24000.0);
    
    private Values() {}
    
    //<editor-fold desc="specific calculations / special cases">
  
    
    public static Acc curveAcc(Speed speed, Length currentCurveRadius) {
        return acc((speed.value() * speed.value()) / (currentCurveRadius.value()));
    }
    //</editor-fold>
    
    // <editor-fold desc="Length">
    public static Length length(double value) {
        return lengthInM(value);
    }
    
    public static Length lengthInM(double value) {
        return LengthImpl.valueOf(value);
    }
    
    public static Length lengthInKM(double value) {
        return LengthImpl.valueOf(value * KILO);
    }
    
    public static Length lengthInFt(double value) {
        return LengthImpl.valueOf(value * FEET_IN_M);
    }
    //</editor-fold>
    // <editor-fold desc="TimeDiff">
    public static TimeDiff timeDiff(double value) {
        return timeDiffInSec(value);
    }
    
    public static TimeDiff timeDiffInSec(double value) {
        return TimeDiffImpl.valueOf(value);
    }
    
    public static TimeDiff timeDiffInMin(double value) {
        return TimeDiffImpl.valueOf(value * MIN_IN_SEC);
    }
    
    public static TimeDiff timeDiffInMilli(double value) {
        return TimeDiffImpl.valueOf(value * MILLI);
    }
    //</editor-fold>
    // <editor-fold desc="Mass">
    public static Mass mass(double value) {
        return massInKG(value);
    }
    
    public static Mass massInG(double value) {
        return mass(value, MassUnit.G);
    }
    
    public static Mass massInKG(double value) {
        return mass(value, MassUnit.KG);
    }
    
    public static Mass massInT(double value) {
        return mass(value, MassUnit.T);
    }
    
    public static Mass mass(double value, MassUnit unit) {
        return MassImpl.valueOf(value * unit.factor());
    }
    //</editor-fold>
    //<editor-fold desc="Speed, Length / Time">
    public static Speed speed(double value) {
        return speedInMS(value);
    }
    
    public static Speed speedInMS(double value) {
        return SpeedImpl.valueOf(value);
    }
    
    public static Speed speedInKMH(double value) {
        return SpeedImpl.valueOf(value / MS_IN_KMH);
    }
    //</editor-fold>
    //<editor-fold desc="Acceleration, Speed / Time">
    public static Acc acc(double value) {
        return accInMS2(value);
    }
    
    public static Acc accInMS2(double value) {
        return AccImpl.valueOf(value);
    }
    //</editor-fold>
    //<editor-fold desc="Force, Mass * Acc">
    public static Force force(double value) {
        return forceInN(value);
    }
    
    public static Force forceInN(double value) {
        return ForceImpl.valueOf(value);
    }
    
    public static Force forceInKN(double value) {
        return ForceImpl.valueOf(value * KILO);
    }
    //</editor-fold>
    //<editor-fold desc="Work, Force * Length">
    public static Work work(double value) {
        return workInJ(value);
    }
    
    public static Work workInJ(double value) {
        return WorkImpl.valueOf(value);
    }
    
    public static Work workInKJ(double value) {
        return WorkImpl.valueOf(value * KILO);
    }
    //</editor-fold>
    //<editor-fold desc="Power, Work / Time">
    public static Power power(double value) {
        return powerInW(value);
    }
    
    public static Power powerInW(double value) {
        return PowerImpl.valueOf(value);
    }
    
    public static Power powerInKW(double value) {
        return PowerImpl.valueOf(value * KILO);
    }
    //</editor-fold>
    
    // <editor-fold desc="Angle">
    public static Angle angle(double value) {
        return angleInRad(value);
    }
    
    public static Angle angleInDeg(double value) {
        return AngleImpl.valueOf(value * RAD_IN_DEG);
    }
    
    public static Angle angleInRad(double value) {
        return AngleImpl.valueOf(value);
    }
    //</editor-fold>
    //<editor-fold desc="BoundingBox - length, width, height">
    public static BoundingBox boundingBox(Length length, Length width, Length height) {
        return BoundingBoxImpl.valueOf(length, width, height);
    }
    
    public static BoundingBox palletBoundingBox() {
        return boundingBox(length(1.0), length(1.2), length(1.0));
    }
    
    public static BoundingBox containerBoundingBox() {
        return boundingBox(lengthInFt(20.0), lengthInFt(8.0), lengthInFt(8.0));
    }
    
    public static BoundingBox nullBoundingBox() {
        return boundingBox(length(0.0), length(0.0), length(0.0));
    }
    //</editor-fold>
}
