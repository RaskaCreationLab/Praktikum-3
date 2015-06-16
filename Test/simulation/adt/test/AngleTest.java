package simulation.adt.test;

import org.junit.Test;
import static org.junit.Assert.*;
import simulation.adt.physics_value.interfaces.Angle;
import simulation.adt.physics_value.classes.Values;

public class AngleTest {
    Angle angle = Values.angleInRad(0.0);
    Angle angle1 = Values.angleInRad(1.0);
    Angle angle2 = Values.angleInRad(2.0);
    Angle angle3 = Values.angleInRad(-1.0);
    Angle angle4 = Values.angleInRad(10.0);
    Angle angle5 = Values.angleInRad(20.0);
    
    String string = "20.0rad";
    
    @Test
    public void testAdd() {
        assertEquals(angle,angle.add(angle));
        assertEquals(angle,angle3.add(angle1));
    }
    
    @Test 
    public void testSub() {
        assertEquals(angle4,angle5.sub(angle4));
        assertEquals(angle1,angle2.sub(angle1));
    }
    
    @Test 
    public void testMul() {
        assertEquals(angle,angle.mul(2.0));
        assertEquals(angle5,angle5.mul(1.0));
    }
    
    @Test
    public void testDiv() {
        assertEquals(angle1, angle4.div(10.0));
        assertEquals(angle3, angle1.div(-1.0));
        assertEquals(angle4, angle5.div(2.0));
    }
    
    @Test 
    public void testAbs() {
        assertEquals(angle1, angle3.abs());
    }
    
    @Test
    public void testSignum() {
        assertEquals(angle1,angle5.signum());
    }
        
    @Test
    public void testToString() {
        assertEquals(string,angle5.toString());
    }
}
