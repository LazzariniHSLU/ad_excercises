package ch.hslu.ad.A4.exc5;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SearchTest {
    String file;

    @Before
    public void getFile(){
        String content = null;
        String path = "/Users/flaviolazzarini/Documents/HSLU/FS2018/AD/gutenberg_german.txt"; // 1 Mio 900'000
        try {
            content = new Scanner(new File(path)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        content = content.replace("\n", "");
        content = content.replace("\r", "");
        file = content;
    }

    @Test
    public void quickSearch() {
        String pattern = "entzauberter";
        long start = System.currentTimeMillis();
        int index = -1;
        for(int i = 0; i< 10000; i++) {
            index = Search.quickSearch(file, pattern);
        }
        long end = System.currentTimeMillis();
        System.out.println("QuickSearch dauerte " + (end - start) + " ms");
        assertEquals(1079145, index);
    }


    @Test
    public void quickSearchNotFound() {
        String pattern = "zzzzzzzz";
        assertEquals(-1, Search.quickSearch(file, pattern));
    }

    @Test
    public void optimalMismatch() {
        String pattern = "entzauberter";
        long start = System.currentTimeMillis();
        int index = -1;
        for(int i = 0; i< 10000; i++) {
            index = Search.optimalMismatch(file, pattern);
        }
        long end = System.currentTimeMillis();
        System.out.println("Optimal Mismatch dauerte " + (end - start) + " ms");
        assertEquals(1079145, index);
    }
}