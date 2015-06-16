package simulation.stowage.test;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import simulation.adt.physics_value.classes.Values;
import simulation.adt.admin_value.classes.AdminValues;
import simulation.stowage.classes.StowageEntities;
import simulation.stowage.interfaces.Container;
import simulation.stowage.interfaces.Pallet;

public class ContainerTest {
    
    @Test
    public void massTests() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        assertEquals(Values.MASS_EMPTY_CONTAINER, c1.emptyMass());
        assertEquals(Values.MASS_EMPTY_CONTAINER, c1.mass());
        assertEquals(Values.MASS_MAX_CONTAINER, c1.maxMass());
        c1.load(p1);
        assertEquals(Values.MASS_EMPTY_CONTAINER, c1.emptyMass());
        assertEquals(Values.MASS_EMPTY_CONTAINER.add(p1.mass()), c1.mass());
        assertEquals(Values.MASS_MAX_CONTAINER, c1.maxMass());
    }
    
    @Test
    public void testIsEmpty() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        assertEquals(true, c1.isEmpty());
        c1.load(1, 1, p1);
        assertEquals(false, c1.isEmpty());
    }
    @Test
    public void testIsFull() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        HashSet<Pallet> h = new HashSet<>(); 
        for(int i = 0; i < 19; i++) {
            h.add(StowageEntities.pallet1000X1200(Values.mass(1000.0)));
        }
        assertEquals(19, h.size());
        assertEquals(false, c1.isFull());
        c1.load(1, 1, p1);
        assertEquals(false, c1.isFull());
        c1.loadAll(h);
        assertEquals(true, c1.isFull());
    }
    
    @Test
    public void testTierIsEmpty() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        assertEquals(true, c1.tierIsEmpty(1,1));
        c1.load(1, 1, p1);
        assertEquals(false, c1.tierIsEmpty(1,1));
    }
    
    @Test
    public void testTierIsFull() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p2 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        assertEquals(false, c1.tierIsFull(1,1));
        c1.load(1, 1, p1);
        assertEquals(false, c1.tierIsFull(1,1));
        c1.load(1, 1, p2);
        assertEquals(true, c1.tierIsFull(1,1));
        assertEquals(false, c1.tierIsFull(0,1));
    }
    
    @Test
    public void loadTest() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p2 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        c1.load(1, 1, p1);
        c1.load(1, 1, p2);
    }
    @Test (expected = IllegalArgumentException.class)
    public void loadTestFail() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p2 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p3 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        c1.load(1, 1, p1);
        c1.load(1, 1, p2);
        c1.load(1, 1, p3);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void loadAllTestFail() {
        Container c1 = StowageEntities.container20Ft();
        HashSet<Pallet> h = new HashSet<>();
        for(int i = 0; i < 25; i++) {
            h.add(StowageEntities.pallet1000X1200(Values.mass(1000.0)));
        }
        c1.loadAll(h);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void load2TestFail() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        HashSet<Pallet> h = new HashSet<>();
        for(int i = 0; i < 20; i++) {
            h.add(StowageEntities.pallet1000X1200(Values.mass(1000.0)));
        }
        c1.loadAll(h);
        c1.load(p1);
    }
    
    @Test
    public void containsTest() {
        Container c1 = StowageEntities.container20Ft();
        Container c2 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p2 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        c1.load(1, 1, p1);
        assertEquals(true, c1.contains(p1));
        assertEquals(false, c1.contains(p2));
        assertEquals(false, c1.contains(c2));
        c1.load(p2);
        assertEquals(true, c1.contains(p1));
        assertEquals(true, c1.contains(p2));
        HashSet<Pallet> h = new HashSet<>();
        h.add(p1);
        h.add(p2);
        assertEquals(true, c1.containsAll(h));
    }
    
    @Test
    public void testGet() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        Pallet p2 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        c1.load(1, 1, p1);
        assertEquals(p1, c1.get(AdminValues.stowageLocation(1, 1, 0)));
        c1.load(p2);
        HashSet<Pallet> h = new HashSet<>();
        h.add(p1);
        h.add(p2);
        assertEquals(true, c1.getAll().containsAll(h));
    }
    
    @Test
    public void testLocationOf() {
        Container c1 = StowageEntities.container20Ft();
        Pallet p1 = StowageEntities.pallet1000X1200(Values.mass(1000.0));
        c1.load(1, 1, p1);
        assertEquals(AdminValues.stowageLocation(1, 1, 0), c1.locationOf(p1));
    }
}
