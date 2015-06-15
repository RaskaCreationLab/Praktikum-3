
package simulation;

import java.text.*;
import jgame.*;
import jgame.platform.*;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.physics_value.interfaces.*;


public class Car implements ParticleInterface {

    //car-spezific constants
    private final Mass mass;         // [kg]
    private final Power powerPropMax; // [W] = [kg * m² / s³]
    private final Speed speedMax;     // [m/s]
    private final Force forcePropMax; // [kg*m / s²]
    private final Length curveRadiusMin; // [m]
    
    private final double ACTIVATION_LEVEL = 0.01;
    private final Speed DRIVE_MIN_SPEED = Values.speedInMS(0.01); // [m/2]
    
    //physical constants
    private static final Acc ACC_EARTH = Values.accInMS2(9.81); // [m/s²]
//    private static final double MS_IN_KMH = 3.6; 
//    private static final double KILO = 1000; // [X] * this -> [kX]
     
    //properties of car
    private double propLevel; // position of gaslevel in [%] (0.00 - 1.00)
    private double brakeLevel; // position of brakelevel in [%] (0.00 - 1.00)
    private Length posX = Values.ZERO_LENGTH; // [m] relative to start
    private Length posY = Values.ZERO_LENGTH; // [m] relative to start
    private TimeDiff time; // [s]
    private Speed speed; // [m/s]
    private double traction; // %
    private boolean abs; // on/off
    private boolean asr; // on/off
    private double steeringLevel; // +-%
    private Angle direction; // [rad]
    
    private boolean lostControl; // yes/no
    
    //<editor-fold desc="getter">
    @Override
    public double getPropLevel() {
        return propLevel;
    }
    
    @Override
    public double getBrakeLevel() {
        return brakeLevel;
    }
    
    @Override
    public double getSteeringLevel() {
        return steeringLevel;
    }
    
    @Override
    public Length getPosX() {
        return posX;
    }
    
    @Override
    public Length getPosY() {
        return posY;
    }
    
    @Override
    public Angle getDirection() {
        return direction;
    }
    
    public TimeDiff getTime() {
        return time;
    }
    
    @Override
    public Speed getSpeed() {
        return speed;
    }
    
    @Override
    public double getTraction() {
        return traction;
    }
    
    @Override
    public boolean getABS() {
        return abs;
    }
    
    @Override
    public boolean getASR() {
        return asr;
    }
    
    @Override
    public boolean getLostControl() {
        return lostControl;
    }
    
    private Acc getAccEarth() {
        return ACC_EARTH;
    }
    //</editor-fold>
    
    //<editor-fold desc="setter">
    public void setPosY(Length posY) {
        this.posY = posY;
    }
    
    public void setPosX(Length posX) {
        this.posX = posX;
    }
    
    public void setTime(TimeDiff time) {
        this.time = time;
    }
    
    @Override
    public void setPropLevel(double proplevel) {
        this.propLevel = proplevel;               
    }
    
    @Override
    public void setBrakeLevel(double brakeLevel) {
        this.brakeLevel = brakeLevel;             
    }
    
    @Override
    public void setSteeringLevel(double newSteeringLevel) {
        this.steeringLevel = newSteeringLevel;
    }
    
    public void setSpeed(Speed speed) {
        if (speed.value() <= 0.0)
            this.speed = Values.ZERO_SPEED;
        else
            this.speed = speed;
    }
    
    @Override
    public void setTraction(double newTraction) {
        this.traction = newTraction;
    }
    
    @Override
    public void setABS(boolean newAbsState) {
        this.abs = newAbsState;
    }
    
    @Override
    public void setASR(boolean newAsrState) {
        this.asr = newAsrState;
    }
    
    @Override
    public void setLostControl(boolean hasLostControl) {
        lostControl = hasLostControl;
    }
    //</editor-fold>
    
    //Constructor and Setup functions
    public Car(Mass mass_kg, Power powerPropMax_kw, Speed speedMax_kmh, Length curveRadiusMin_m) {
        //checkpre?
        this.mass = mass_kg;
        this.powerPropMax = powerPropMax_kw;
        this.speedMax = speedMax_kmh;
        this.curveRadiusMin = curveRadiusMin_m;
        this.forcePropMax = mass.mul(ACC_EARTH);
        
        this.lostControl = false;
        
        this.setPosX(Values.ZERO_LENGTH);
        this.setPosY(Values.ZERO_LENGTH);
        this.direction = Values.ZERO_ANGLE;
        reset();
    }
    
    public static Car porsche() {
        return new Car(Values.massInKG(1445.0), Values.powerInKW(365.0), Values.speedInKMH(330.0), Values.lengthInM(10.0));
    }
    
    @Override
    public void set(TimeDiff time, Length posX, Length posY, Speed speed, double propLevel, double brakeLevel) {
        setTime(time);
        setPosX(posX);
        setPosY(posY);
        setSpeed(speed);
        setPropLevel(propLevel);
        setBrakeLevel(brakeLevel);
    }
    
    public final void reset() {
        set(Values.ZERO_TIMEDIFF, Values.ZERO_LENGTH, Values.ZERO_LENGTH, Values.ZERO_SPEED, 0.0, 0.0);
    }
    
    //Dynamik
    public Power powerProp() {
        return powerPropMax.mul(propLevel);  // [W] = [kg * m² / s³]
    }
    
    public Force forcePropMax(boolean withTraction) {
        if(withTraction)
            return forcePropMax.mul(getTraction());
        else
            return forcePropMax;
    }
    
    public Force forcePropAbs() {
        if (speed.value() <= DRIVE_MIN_SPEED.value())
            return forcePropMax(getASR());                                  // [kg*m / s²]
        else if (speed.value() >= DRIVE_MIN_SPEED.value())
            return Values.forceInN(Math.min(forcePropMax(getASR()).value(), (powerProp().div(speed)).value())); // [kg*m / s²]
        else
            return Values.ZERO_FORCE;
    }
    
    public Force forceProp() {
        return forcePropAbs().mul(Math.signum(propLevel)); //[kg*m / s²]
    }
    
    public Force forceDrag() {
        return getSpeed().forceDrag(speedMax, powerPropMax); // [kg*
    }
    
    public Force forceBrake() {
        //System.out.println(getBreakLevel());
        return forcePropMax(getABS()).mul(Math.signum(-getSpeed().value()) * brakeLevel);
    }
    
    public Force force() {
        return forceProp().add(forceDrag().add(forceBrake())); // [kg*m / s²]
    }
    
    //Kinematik
    public Acc acc() {
        return force().div(mass); // [kg / s²]
    }
    
    public Acc maxAcc() {
        return getAccEarth().mul(getTraction());
    }
    
    public Acc curveAcc() {
        if(getSteeringLevel() < -ACTIVATION_LEVEL || getSteeringLevel() > ACTIVATION_LEVEL)
            return Values.curveAcc(speed, currentCurveRadius());
        else
            return Values.ZERO_ACC;
    }
    
    public Length currentCurveRadius() {
        if(getSteeringLevel() < -ACTIVATION_LEVEL || getSteeringLevel() > ACTIVATION_LEVEL)
            return curveRadiusMin.div(getSteeringLevel());
        else
            return Values.lengthInM(99999999999.9);
    }
    
    public Angle deltaDirection(TimeDiff deltaTime) {
        if(acc().value() > 0.1)
            return Values.angleInRad((curveAcc().value() / acc().value()) * deltaTime.div(1000.0).value()); // [rad]
        else
            return Values.ZERO_ANGLE;
    }
    
    public Length deltaPos(TimeDiff deltaTime) {
        return speed.mul(deltaTime); // [m]
    }
    
    public Length deltaPosX(TimeDiff deltaTime) {
        return deltaPos(deltaTime).mul(Math.sin(direction.value())); // [m]
    }
    
    public Length deltaPosY(TimeDiff deltaTime) {
        return deltaPos(deltaTime).mul(Math.cos(direction.value())); // [m]
    }
    
    //Methods
    @Override
    public void step(TimeDiff deltaTime) {
        setPosX(posX.add(deltaPosX(deltaTime)));
        setPosY(posY.add(deltaPosY(deltaTime)));
        setSpeed(speed.add(acc().mul(deltaTime)));
        setTime(time.add(deltaTime));
        
        direction = Values.angle((direction.value() + deltaDirection(deltaTime).value()) % (2*Math.PI));
        
        if(forcePropAbs().value() >= forcePropMax(true).value() || 
          (forcePropMax(getABS()).value() * getBrakeLevel()) >= forcePropMax(true).value())
        //if(Math.abs(acc()) + curveAcc() > maxAcc())
            setLostControl(true);  
        else
            setLostControl(false);
    }
    
    @Override
    public String toString() {
        return to_String_EU();
    }
    
    public String to_String_EU() {
        DecimalFormat f = new DecimalFormat("#0.00");
        String text =   "Positon: " +  f.format(getPosX()) + "m" +
                        " Speed: " + f.format(speed) + " Km/h" +
                        " Time: " + f.format(time) + "s" +
                        " Gas Level: " + f.format(propLevel) + " %" +
                        " Brake Level: " + f.format(brakeLevel) + " %";
        return text;
    }
}
