/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet;

import java.util.Date;

/**
 *
 * @author Vicente Oyarzún 004D 19/11/2023
 */
public class Mascota {
    private int codigo;
    private String nombre; //limitar de 20 caracteres
    private Date fec_nac;
    private char sexo;
    private boolean vigente;
    private Tipo_Mascota tipo;
    private Cliente rut_cliente;

    public Mascota() {
    }

    public Mascota(int codigo, String nombre, Date fec_nac, char sexo, boolean vigente, Tipo_Mascota tipo, Cliente rut_cliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fec_nac = fec_nac;
        this.sexo = sexo;
        this.vigente = vigente;
        this.tipo = tipo;
        this.rut_cliente = rut_cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Cliente getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(Cliente rut_cliente) {
        this.rut_cliente = rut_cliente;
    }
}
