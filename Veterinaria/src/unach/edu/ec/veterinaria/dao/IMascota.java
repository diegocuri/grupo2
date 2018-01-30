
package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.Mascota;
import java.util.*;
public interface IMascota {
    public int insertar(Mascota mascota) throws Exception;
    public Mascota obtener(int codigo) throws Exception;
    public List<Mascota> obtener() throws Exception;    
}
