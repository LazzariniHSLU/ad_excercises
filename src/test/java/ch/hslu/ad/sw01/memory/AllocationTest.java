package ch.hslu.ad.sw01.memory;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.*;

public class AllocationTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    public void testEquals(){
        Allocation allocation = new Allocation(0, 16);
        Allocation allocation2 = new Allocation(0, 16);
        assertEquals(allocation.equals(allocation2), true);
    }

    @Test
    public void testEqualsTrueReference(){
        Allocation allocation = new Allocation(0, 16);
        assertEquals(allocation.equals(allocation), true);
    }

    @Test
    public void testCompareToSmaller() {
        Allocation allocation = new Allocation(10, 16);
        Allocation allocation1 = new Allocation(0, 16);
        assertEquals(1, allocation.compareTo(allocation1));
    }

    @Test
    public void testCompareToBigger() {
        Allocation allocation = new Allocation(0, 16);
        Allocation allocation1 = new Allocation(10, 16);
        assertEquals(-1, allocation.compareTo(allocation1));
    }
}