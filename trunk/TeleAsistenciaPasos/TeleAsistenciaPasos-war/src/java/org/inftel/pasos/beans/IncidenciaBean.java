/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inftel.pasos.beans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import org.inftel.pasos.entity.TipoIncidencia;
import org.inftel.pasos.entity.Usuario;

/**
 *
 * @author Manuel Valls
 */
public class IncidenciaBean {
     private String nombre;
     private String apellido1;
     private String apellido2;
     /*private String nombreEmpleado;
     private String apellido1Empleado;*/
     private String tipoIncidencia;
     private String fecha;
     private String hora;
     private Double temperatura;
     private BigInteger nivelBateria;
    
    public IncidenciaBean(){}

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

   /* public String getApellido1Empleado() {
        return apellido1Empleado;
    }

    public void setApellido1Empleado(String apellido1Empleado) {
        this.apellido1Empleado = apellido1Empleado;
    }*/

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public BigInteger getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(BigInteger nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /* public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }*/

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }
    
    }