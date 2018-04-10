package ch.hslu.ad.sw05.exc1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void executeTransfers() {

        Bank bank = new Bank(4, 2000000);
        bank.executeTransfers(1500000);
        System.out.println(bank.toString());
    }
}