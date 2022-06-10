package com.practica.cajablanca;

import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongitudTest {

    private String rutaArchivos = "txt/";
    private Editor editor;

    @BeforeEach
    private void init(){
        editor = new Editor();
    }

    @Test
    public void mayorLongitud_archivoVacioTest() throws EmptyCollectionException {
        editor.leerFichero(rutaArchivos + "vacio.txt");
        assertEquals(null, editor.mayorLongitud());
    }

    @Test
    public void mayorLongitud_1elemTest() throws EmptyCollectionException {
        editor.leerFichero(rutaArchivos + "1elem.txt");
        assertEquals("Lorem", editor.mayorLongitud());
    }

    @Test
    public void mayorLongitud_2elemTest() throws EmptyCollectionException  {
        editor.leerFichero(rutaArchivos + "mayorLong2.txt");
        assertEquals("bbbb", editor.mayorLongitud());
    }

    @Test
    public void mayorLongitud_3elemTest() throws EmptyCollectionException  {
        editor.leerFichero(rutaArchivos + "mayorLong3.txt");
        assertEquals("cccccccc", editor.mayorLongitud());
    }

    @Test
    public void mayorLongitud_3lineasTest() throws EmptyCollectionException {
        editor.leerFichero(rutaArchivos + "3lineas.txt");
        assertEquals("consectetur", editor.mayorLongitud());
    }

    @Test public void mayorLongitud_palabrasIguales() throws EmptyCollectionException {
        editor.leerFichero(rutaArchivos + "3elem.txt");
        assertEquals("Lorem", editor.mayorLongitud());
    }


}
