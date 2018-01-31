
package unach.edu.ec.veterinaria.Entidades;

public class Revision {
    private int codigo;
    private Mascota mascota;
    private Veterinario veterinario;
    private String descripcion;

    public Revision() {
    }

    public Revision(int codigo, Mascota mascota, Veterinario veterinario, String descripcion) {
        this.codigo = codigo;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
