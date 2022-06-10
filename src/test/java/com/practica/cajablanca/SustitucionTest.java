package com.practica.cajablanca;

import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SustitucionTest {

    private String rutaArchivos = "txt/";
    private Editor editor;

    @BeforeEach
    private void init(){
        editor = new Editor();
    }

    @Test
    public void sustituirPalabra_vacioTest() throws IllegalArgumentException{
        editor.leerFichero(rutaArchivos + "vacio.txt");
        editor.sustituirPalabra("ordenador", "teclado");

        assertEquals(0, editor.size());
    }

    @Test
    public void sustituirPalabra_1elemTest() throws EmptyCollectionException, IllegalArgumentException{
        editor.leerFichero(rutaArchivos + "1elem.txt");
        editor.sustituirPalabra("Lorem", "piscina");

        assertEquals("[piscina]", editor.getLinea(1).toString());
    }

    @Test
    public void sustituirPalabra_2elemTest() throws EmptyCollectionException, IllegalArgumentException{
        editor.leerFichero(rutaArchivos + "2elem.txt");
        editor.sustituirPalabra("ipsum", "botella");

        assertEquals("[Lorem, botella]", editor.getLinea(1).toString());
    }

    @Test
    public void sustituirPalabra_3elemTest() throws EmptyCollectionException, IllegalArgumentException{
        editor.leerFichero(rutaArchivos + "3elem.txt");
        editor.sustituirPalabra("dolor", "felicidad");

        assertEquals("[Lorem, ipsum, felicidad]", editor.getLinea(1).toString());

    }

}
