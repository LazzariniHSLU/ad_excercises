package ch.hslu.ad.A4;

import ch.hslu.ad.A4.exc2.AnanasAutomat;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnanasAutomatTest {

    @Test
    public void stateSearchBeginning() {
        String testString = "ANANASAAANSSAANNANASNANSANANASSSSANd";
        assertEquals(0, AnanasAutomat.stateSearch(testString));
    }

    @Test
    public void stateSearch() {
        String testString = "NNNSSSAAANSSAANNANASNANSANANASSSSANd";
        assertEquals(24, AnanasAutomat.stateSearch(testString));
    }

    @Test
    public void stateSearchNotFound() {
        String testString = "ANSANANAANSSSSANNNNNNANNNANNNSNNNNSSSAAAASSSSAAANNNNN";
        assertEquals(-1, AnanasAutomat.stateSearch(testString));
    }

}