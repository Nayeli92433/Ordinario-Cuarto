package Util;

import java.util.ArrayList;

public class UtilCombo {
    public static ArrayList<String> tipoCargo() {
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Administrador");
        tipo.add("Repartidor");
        return tipo;
    }
    public static ArrayList<String> tipoDepartamento() {
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Abarrotes");
        tipo.add("Línea blanca");
        tipo.add("Embutidos");
        tipo.add("Lácteos");
        tipo.add("Artículos de limpieza");

        return tipo;
    }
}
