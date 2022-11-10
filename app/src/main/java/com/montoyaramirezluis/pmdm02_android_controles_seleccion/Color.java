package com.montoyaramirezluis.pmdm02_android_controles_seleccion;

import androidx.annotation.NonNull;

public class Color {
    private String nombre; // Nombre del color
    private String rgb; // Código RGB del color

    /**
     * Constructor de la clase Color
     * @param nombre Nombre del color
     * @param rgb Código RGB del color
     */
    public Color(String nombre, String rgb) {
        this.nombre = nombre;
        this.rgb = rgb;
    }

    /**
     * Devuelve el nombre del color
     * @return Nombre del color
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Guarda el nombre del color.
     * @param nombre Nombre del color
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Guarda el código RGB del color
     * @return Código RGB del color
     */
    public String getRgb() {
        return rgb;
    }

    /**
     * Devuelve el código RGB del color
     * @param rgb Código RGB del color
     */
    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    /**
     * Devuelve el nombre y código RGB del color.
     * Será usado por el adaptador para mostrar los colores en el spinner
     * @return Nombre del color
     */
    @NonNull
    public String toString() {
        return this.getNombre() + " - " + this.getRgb();
    }

}
