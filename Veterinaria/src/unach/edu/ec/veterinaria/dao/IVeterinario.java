
package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.Veterinario;
import java.util.*;
public interface IVeterinario {
    public int insertar(Veterinario veterinario) throws Exception;
    public Veterinario obtener(int codigo) throws Exception;
    public List<Veterinario> obtener() throws Exception;    
}
