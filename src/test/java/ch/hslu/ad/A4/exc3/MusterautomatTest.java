package ch.hslu.ad.A4.exc3;

import org.junit.Test;

import static org.junit.Assert.*;

public class MusterautomatTest {
    @Test
    public void kmpSearchAtBeginning() {
        String testString = "ANANASAAANSSAANNANASNANSANANASSSSANd";
        assertEquals(0,  Musterautomat.kmpSearch(testString, "ANANAS"));
    }

    @Test
    public void kmpSearch(){
        String testString = "NNNSSSAAANSBSAANNANASNANSANANASSSSANd";
        assertEquals(24, Musterautomat.kmpSearch(testString, "ANANAS"));
    }

    @Test
    public void kmpSearcTest(){
        String testString = "NANANAANAS";
        assertEquals(-1, Musterautomat.kmpSearch(testString, "ANANAS"));
    }
}