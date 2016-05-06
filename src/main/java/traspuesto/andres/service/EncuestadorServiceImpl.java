

package traspuesto.andres.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traspuesto.andres.dao.EncuestadorDao;
import traspuesto.andres.dao.ItemDao;
import traspuesto.andres.dao.VotanteDao;
import traspuesto.andres.domain.Encuestador;
import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Votante;

/**
 * @author andrestraspuesto@gmail.com
 */
@Service
@Transactional
public class EncuestadorServiceImpl implements EncuestadorService{

    @Autowired
    EncuestadorDao encuestadorDao;
    
    @Autowired
    VotanteDao votanteDao;
    
    @Autowired
    ItemDao itemDao;
            
    @Override
    public Encuestador guardaEncuestador(Encuestador encuestador) {
        encuestadorDao.save(encuestador);
        return encuestador;
    }

    @Override
    public Votante guardaVotante(Votante votante) {
        votanteDao.save(votante);
        return votante;
    }

    @Override
    public Item guardaItem(Item item) {
        itemDao.save(item);
        return item;
    }

}
