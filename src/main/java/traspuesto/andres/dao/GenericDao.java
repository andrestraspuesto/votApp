package traspuesto.andres.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * @author andrestraspuesto@gmail.com
 * @param <E> Clase de dominio asociada
 * @param <ID> Clase del identificador de la clase de dominio
 */
@NoRepositoryBean
public interface GenericDao<E, ID extends Serializable> extends Repository<E,ID>{
    
    /**
     * Borra el elemento
     * @param elemento
     */
    void delete(E elemento);
 
    /**
     * Devuelve todos los elementos
     * @return 
     */
    List<E> findAll();
     
    /**
     * Devuelve el elemento cuyo id coincida
     * @param id
     * @return 
     */
    E findOne(ID id);
 
    /**
     * Guarda el elemento
     * @param persisted
     * @return 
     */
    E save(E persisted);
}
