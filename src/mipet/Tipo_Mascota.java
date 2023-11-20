package mipet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */
public class Tipo_Mascota {
    private String _id;
    private String descripcion;

    public Tipo_Mascota() {
    }
    
    public Tipo_Mascota(String _id, String descripcion) {
        this._id = _id;
        this.descripcion = descripcion;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
