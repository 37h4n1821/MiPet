/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Modelo;

import java.util.Date;

/**
 *
 * @author Vicente Oyarzún 004D 19/11/2023
 */
public class Mascota {
    private String _id;
    private String nombre; //limitar de 20 caracteres
    private Date fec_nac;
    private char sexo;
    private boolean vigente;
    private Tipo_Mascota tipo;
    private Cliente cliente;

    public Mascota() {
    }

    public Mascota(String _id, String nombre, Date fec_nac, char sexo, boolean vigente, Tipo_Mascota tipo, Cliente cliente) {
        this._id = _id;
        this.nombre = nombre;
        this.fec_nac = fec_nac;
        this.sexo = sexo;
        this.vigente = vigente;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Tipo_Mascota getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_Mascota tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Mascota{" + "_id=" + _id + ", nombre=" + nombre + ", fec_nac=" + fec_nac + ", sexo=" + sexo + ", vigente=" + vigente + ", tipo=" + tipo + ", cliente=" + cliente + '}';
    }
    
}
