package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testOperaciones() {
        assertEquals(ValidadorRut.operaciones(138),5);
    }

    @Test
    void testSerie() {
        assertEquals(ValidadorRut.serie("87654321"),138);
    }

    @Test
    void testVoltearInt() {
        assertEquals(ValidadorRut.voltearInt(12345678),"87654321");
    }

    @Test
    void testDigito() {
        assertEquals(ValidadorRut.digito(11),"0");
    }
}