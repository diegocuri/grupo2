
package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.Revision;
import java.util.*;
public interface IRevision {
    public int insertar(Revision revision) throws Exception;
    public Revision obtener(int codigo) throws Exception;    
    public List<Revision> obtener() throws Exception;    
}
