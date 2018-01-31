
package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.*;
import java.util.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public interface IVeterinario {
    public int insertar(Veterinario veterinario) throws Exception;
    public int modificar(Veterinario veterinario) throws Exception;
    public int eliminar(Veterinario veterinario) throws Exception;
    public Veterinario obtener(int codigo) throws Exception;
    public List<Veterinario> obtener() throws Exception;    
}