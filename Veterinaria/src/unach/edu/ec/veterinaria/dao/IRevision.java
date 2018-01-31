

package unach.edu.ec.veterinaria.dao;

import unach.edu.ec.veterinaria.Entidades.*;
import java.util.*;
/**
 *
 * @author FABRICIO CONSTANTE
 */
public interface IRevision {
    public int insertar(Revision revision) throws Exception;
    public int modificar(Revision revision) throws Exception;
    public int eliminar(Revision revision) throws Exception;
    public Revision obtener(int codigo) throws Exception;
    public List<Revision> obtener() throws Exception;    
}