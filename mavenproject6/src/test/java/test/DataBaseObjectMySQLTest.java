package test;

import com.mycompany.mavenproject6.DatabaseObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author christianmarzian
 */
public class DataBaseObjectMySQLTest {
           
    @Test
    public void TestConnection(){
		DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("8889");
                x.setHost("localhost");
                x.setDBkind("mysql");
        assertTrue(x.connect()==1);   
    }
        
    @Test
    public void TestSetDataBase(){
        String dataBase = "testDB";
        DatabaseObject x = new DatabaseObject();
                x.setDataBase(dataBase);
                assertTrue(x.getDataBase() == dataBase);
    }
    
    @Test
    public void TestSetUsr(){
        String usr = "root";
        DatabaseObject x = new DatabaseObject();
                x.setUsr(usr);
                assertTrue(x.getUsr() == usr);
    }
    
    @Test
    public void TestSetPW(){
        String pw = "root";
        DatabaseObject x = new DatabaseObject();
                x.setPW(pw);
                assertTrue(x.getPW() == pw);
    }
    
    @Test
    public void TestSetPort(){
        String port = "8";
        DatabaseObject x = new DatabaseObject();
                x.setPort(port);
                assertTrue(x.getPort() == port);
    }
    
    @Test
    public void TestSetHost(){
        String host = "localhost";
        DatabaseObject x = new DatabaseObject();
                x.setHost(host);
                assertTrue(x.getHost() == host);
    }
    
    @Test
    public void TestSetDBKind(){
        String dbKind = "mysql";
        DatabaseObject x = new DatabaseObject();
        x.setDBkind(dbKind);
        assertTrue(x.getDBkind() == dbKind);
    }
    
    @Test
    public void TestGetCon_ReturnNull(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("8889");
                x.setHost("localhost");
                x.setDBkind("msql");
        assertTrue(x.getCon() == null);   
    }
    
    @Test
    public void TestGetCon_ReturnValidConnection(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("8889");
                x.setHost("localhost");
                x.setDBkind("mysql");
        assertTrue(x.getCon() != null);   
    }
    
    @Test
    public void TestGetStatement_ReturnStatement(){
        DatabaseObject x = new DatabaseObject();
                x.setDataBase("testDB");
                x.setUsr("root");
                x.setPW("root");
                x.setPort("8889");
                x.setHost("localhost");
                x.setDBkind("mysql");
        assertTrue(x.getStatement(x.getCon()) != null);   
    }
}