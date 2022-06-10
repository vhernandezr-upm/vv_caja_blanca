package com.practica.cajablanca;

import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContarPalabrasTest {

    private String rutaArchivos = "txt/";
    private Editor editor;

    @BeforeEach
    private void init(){
        editor = new Editor();
    }

    @Test
    public void numPalabras_argumentosNoValidos1Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "2elem.txt");
        assertThrows(IllegalArgumentException.class, ()-> editor.numPalabras(-1, 0, "prueba"));
    }

    @Test
    public void numPalabras_argumentosNoValidos2Test() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, ()-> editor.numPalabras(0, 8, "prueba"));
    }

    @Test
    public void numPalabras_argumentosNoValidos3Test() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, ()-> editor.numPalabras(2, 1, "prueba"));
    }

    @Test
    public void numPalabras_argumentosNoValidos4Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "3lineas.txt");
        assertThrows(IllegalArgumentException.class, ()-> editor.numPalabras(2, 1, "prueba"));
    }

    @Test
    public void numPalabras_buscarEnTextoVacioTest() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "vacio.txt");
        assertEquals(0, editor.numPalabras(1, 0, "vacio"));
    }

    @Test
    public void numPalabras_buscarPalabras1Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(2, editor.numPalabras(1 ,1, "cinco"));
    }

    @Test
    public void numPalabras_buscarPalabras2Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(3, editor.numPalabras(1 ,2, "cinco"));
    }

    @Test
    public void numPalabras_buscarPalabras3Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(5, editor.numPalabras(1 ,5, "cinco"));
    }

    @Test
    public void numPalabras_buscarPalabras4Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(4, editor.numPalabras(1 ,5, "cuatro"));
    }

    @Test
    public void numPalabras_buscarPalabras5Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(2, editor.numPalabras(1 ,5, "dos"));
    }

    @Test
    public void numPalabrasCase7() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(1, editor.numPalabras(1, 5, "uno"));
    }

    @Test
    public void numPalabras_buscarPalabras6Test() throws IllegalArgumentException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(1, editor.numPalabras(3 ,4, "uno"));
    }

    @Test
    public void numPalabras_contarTodasTest() throws EmptyCollectionException {
        editor.leerFichero(rutaArchivos + "repetidas.txt");
        assertEquals(15, editor.numPalabras());
    }


}
