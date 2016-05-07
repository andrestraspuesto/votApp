/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package traspuesto.andres.service;

import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import traspuesto.andres.TestApplicationContext;
import traspuesto.andres.domain.Item;
import traspuesto.andres.domain.Voto;
import traspuesto.andres.exception.SuperaVotosException;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationContext.class)
@ActiveProfiles("test")
@Transactional
public class VotacionServiceImplTest {
    
    @Autowired
    VotacionService votacionService;

    public VotacionServiceImplTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of votar method, of class VotacionServiceImpl.
     */
    @Test
    @Sql(executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            scripts="classpath:insert-h2.sql")
    public void testVotarUsuarioAutorizado() throws Exception {
        Voto voto = new Voto();
        voto.setItemId(1L);
        voto.setVotanteId(4L);
        voto.setPuntuacion(9);
        Item item = votacionService.votar(voto);
        Integer esperado = 32;
        Assert.assertEquals(esperado, item.getPuntuacionAcum());
    }
    /**
     * Test of votar method, of class VotacionServiceImpl.
     */
    @Test(expected = SuperaVotosException.class)  
    @Sql(executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            scripts="classpath:insert-h2.sql")
    public void testVotarUsuarioExcedeMaxVotos() throws Exception {
        Voto voto = new Voto();
        voto.setItemId(1L);
        voto.setVotanteId(1L);
        voto.setPuntuacion(9);
        Item item = votacionService.votar(voto);
        
    }

}