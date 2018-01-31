
package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.*;
import java.util.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public interface IMascota {
    public int insertar(Mascota mascota) throws Exception;
    public int modificar(Mascota mascota) throws Exception;
    public int eliminar(Mascota mascota) throws Exception;
    public Mascota obtener(int codigo) throws Exception;
    public List<Mascota> obtener() throws Exception;    
}
