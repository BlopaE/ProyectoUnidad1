
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
/**
 *
 * @author Pablo Erick Ramírez Cruz
 */
public class Trabajador implements Serializable {
    
    public static final String DIA = "DIA", SEMANA = "SEMANA", QUINCENA = "QUINCENA";
    
    private String nombre,apellido;
    private LocalDateTime fechaRegistro;
    private float salario, salarioFinal;
    private int retardos, faltas;
    private String tipo;
    private float descuentoPorFalta;
    
    public Trabajador(String nombre, String apellido, float salario, String tipo) {
        
        if (!tipo.equals(Trabajador.DIA) && !tipo.equals(Trabajador.SEMANA) && !tipo.equals(Trabajador.QUINCENA)){
            throw new IllegalArgumentException();
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaRegistro = LocalDateTime.now();
        this.tipo=tipo;
        this.salario = salario;
        
        switch (tipo) {
            case Trabajador.DIA:
                descuentoPorFalta = salario;
                break;
            case Trabajador.SEMANA:
                descuentoPorFalta = salario/7;
                break; 
            case Trabajador.QUINCENA:
                descuentoPorFalta = salario/15;
                break;
            default:
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getRetardos() {
        return retardos;
    }

    public void setRetardos(int retardos) {
        this.retardos = retardos;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDescuentoPorFalta() {
        return descuentoPorFalta;
    }

    public void setDescuentoPorFalta(float descuentoPorFalta) {
        this.descuentoPorFalta = descuentoPorFalta;
    }    

    public void setSalarioFinal(float salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public float getSalarioFinal() {
        return salario - (descuentoPorFalta*faltas) - (descuentoPorFalta*(retardos/3));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trabajador other = (Trabajador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        return true;
    }
}
