/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet;

/**
 *
 * @author Ethan Leiva
 */
public class Cliente {
    private String _id;
    private String rut;
    private char dv;
    private String nombre;
    private String ape1;
    private String ape2;

    public Cliente() {
    }
    
    public Cliente(String rut, char dv, String nombre, String ape1, String ape2) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public Cliente(String _id,String rut, char dv, String nombre, String ape1, String ape2) {
        this._id = _id;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }
    
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    @Override
    public String toString() {
        return "Cliente{" + "_id=" + _id + ", rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + '}';
    }
    
}
