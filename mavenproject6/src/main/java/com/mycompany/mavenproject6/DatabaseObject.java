/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christianmarzian
 */
public class DatabaseObject {
    
    private String dataBase;
    private String usr;
    private String pw;    
    private String port;
    private String host;
    private String dbKind;
    
    public String getDBkind(){
        return this.dbKind;
    }
    
    public void setDBkind(String dbKind){
        this.dbKind = dbKind;
    }
    
    public String getHost(){
        return this.host;
    }
    
    public void setHost(String host){
        this.host = host;
    }
        
    public String getPort(){
        return this.port;
    }
    
    public void setPort(String port){
        this.port = port;
    }
    
    public String getPW(){
        return pw;
    }
    
    public void setPW(String pw){
        this.pw = pw;
    }
    
    
    public String getUsr(){
        return this.usr;
    };
    
    public void setUsr(String usr){
        this.usr = usr;
    };
    
    
    public String getDataBase(){
        return this.dataBase;
    }
    public void setDataBase(String dataBase){
        this.dataBase = dataBase;
    }
    
    public Connection getCon(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:" + this.dbKind + "://" + this.host + ":" + this.port +"/" + this.dataBase,this.usr,this.pw);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public Statement getStatement(Connection con){
        Statement stmt = null; 
        try{
            stmt = con.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return stmt;     
    }
    
    public int connect(){ 
        Statement stmt;
        int retVal = 0;
        try {			
                Connection con = getCon();
                stmt = getStatement(con);
                ResultSet rs=stmt.executeQuery("select * from testTable");
                
                /* while(rs.next()){
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                }    */            
                        con.close();
                        retVal = 1;
        } catch (SQLException e) {
                e.printStackTrace();
        }  
        return retVal;
    }
}
