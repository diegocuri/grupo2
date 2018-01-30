
package unach.edu.ec.veterinaria.Entidades;

public class Mascota {
    private int codigo;
    private String nombre;
    private String sexo;
    private String raza;
    
    public Mascota() {
    }

    public Mascota(int codigo, String nombre, String sexo, String raza) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.raza = raza;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
}