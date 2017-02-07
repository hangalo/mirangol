/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ao.mirangol.dao;

import java.util.List;
import org.ao.mirangol.modelo.Projeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author informatica
 */
public class ProjetoDAOTest {
    
    public ProjetoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class ProjetoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Projeto projeto = null;
        ProjetoDAO instance = new ProjetoDAO();
        instance.save(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ProjetoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Projeto projeto = null;
        ProjetoDAO instance = new ProjetoDAO();
        instance.update(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ProjetoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Projeto projeto = null;
        ProjetoDAO instance = new ProjetoDAO();
        instance.delete(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class ProjetoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        ProjetoDAO instance = new ProjetoDAO();
        Projeto expResult = null;
        Projeto result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ProjetoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ProjetoDAO instance = new ProjetoDAO();
        List<Projeto> expResult = null;
        List<Projeto> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
