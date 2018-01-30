
package unach.edu.ec.veterinaria.Entidades;

public class Revision {
    private String codigo;
    private Mascota mascota;
    private Veterinario veterinario;
    private String descripcion;

    public Revision() {
    }

    public Revision(String codigo, Mascota mascota, Veterinario veterinario, String descripcion) {
        this.codigo = codigo;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
