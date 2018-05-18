package ch.hslu.ad.A3;

import org.junit.Test;

import static org.junit.Assert.*;

public class DEATest {

    @Test
    public void isWordLanguage() {
        assertTrue(DEA.isWordLanguage("010"));
        assertTrue(DEA.isWordLanguage("01110"));
        assertTrue(DEA.isWordLanguage("0101010"));
    }

    @Test
    public void isWordLanguageWrong(){
        assertFalse(DEA.isWordLanguage("11"));
        assertFalse(DEA.isWordLanguage("01011"));
    }
}