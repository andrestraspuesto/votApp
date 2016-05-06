

package traspuesto.andres.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import traspuesto.andres.dao.ItemDao;
import traspuesto.andres.dao.VotoDao;
import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Voto;
import traspuesto.andres.exception.NullVotanteException;
import traspuesto.andres.exception.SuperaVotosException;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@Service
@Transactional
public class VotacionServiceImpl implements VotacionService{
    
    VotoDao votoDao;
    
    ItemDao itemDao;

    @Override
    public Item votar(Voto voto) throws NullVotanteException, SuperaVotosException {
        if(voto.getVotanteId() == null){
            throw new NullVotanteException();
        }
        Item item = voto.getItem();
        Integer nVotos =votoDao.countByItemIdAndVotanteId(item.getId(), voto.getVotanteId());
        if(nVotos <= item.getMaxVotosVotante()){
            item.setVotosAcum(item.getVotosAcum() + 1);
            int ptos = item.getPuntuacionAcum() + voto.getPuntuacion();
            item.setPuntuacionAcum(ptos);
            if(item.getVotoAnonimo()){
                voto.setPuntuacion(0);
            }
            itemDao.save(item);
            votoDao.save(voto);
        } else {
            throw new SuperaVotosException();
        }
        return item;
    }

}
