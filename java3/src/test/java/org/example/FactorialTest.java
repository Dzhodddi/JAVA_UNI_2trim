package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    Factorial factorial;
    Factorial factorial3;
    Factorial factorial4;
    @BeforeEach
     void setUp() {
        factorial= new Factorial(0);
        factorial3= new Factorial(5);
        factorial4= new Factorial(10);
    }

    @Test
    void TestFactorial() {
        assertSame(BigInteger.ONE, factorial.factorial());
        assertEquals(new BigInteger("120"), factorial3.factorial());
        assertEquals(new BigInteger("3628800"), factorial4.factorial());
        assertNotEquals(BigInteger.TWO, factorial.factorial());
    }
}