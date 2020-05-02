/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dal.QuestionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Question;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author quanh
 */
public class test_QuestionDAO {

    public test_QuestionDAO() {
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

    @Test
    public void test_get_new_id() {
        QuestionDAO qdao = new QuestionDAO();
        int a = qdao.getNewId();
        int b = 5;
        assertEquals(b, a);
    }
    
    @Test
    public void test_insert() throws SQLException{
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        Question q = new Question(5, "Cities in Viet Name : ", "Ha Noi", "Ho Chi Minh", "Bac Kinh", "New Zelean", list);
        QuestionDAO qdao = new QuestionDAO();
        String x = qdao.insertQuestion(q);
        String rs = "success";
        assertEquals(x, rs);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
