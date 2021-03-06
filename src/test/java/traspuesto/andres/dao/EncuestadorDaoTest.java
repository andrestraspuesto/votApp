/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package traspuesto.andres.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import traspuesto.andres.TestApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import traspuesto.andres.domain.Encuestador;

/**
 *
 * @author andrestraspuesto@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplicationContext.class)
@ActiveProfiles("test")
@Transactional
public class EncuestadorDaoTest {
    
    @Autowired
    EncuestadorDao encuestadorDao;

    public EncuestadorDaoTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    @Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:insert-h2.sql")
    public void testSave() {
        Encuestador app = new Encuestador();
        app.setEmail("andrestraspuesto@gmail.com");
        encuestadorDao.save(app);
        Assert.assertTrue(app.getId() != null);
        
    }
    
    @Test
    @Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:insert-h2.sql")
    public void testFindById(){
        Encuestador app = encuestadorDao.findOne(1L);
        Assert.assertEquals("mockActiva@test.com", app.getEmail());
    }
    
    @Test
    @Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:insert-h2.sql")
    public void testFindAll(){
        List<Encuestador> appList = encuestadorDao.findAll();
        Assert.assertEquals(2, appList.size());
    }
    
    @Test
    @Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:insert-h2.sql")
    public void testDelete(){
        Encuestador app = encuestadorDao.findOne(1L);
        encuestadorDao.delete(app);
        app = null;
        List<Encuestador> appList = encuestadorDao.findAll();
        Assert.assertEquals(1, appList.size());
        Assert.assertEquals("mockInactiva@test.com", appList.get(0).getEmail());
    }

}