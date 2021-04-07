/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import atividade.pkg1.frames.pkg1.pkg2021.concetion.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Categoria;

/**
 *
 * @author davia
 */
public class CategoriaDAO {
    
    private Connection con = null;

    public CategoriaDAO() {
        
        con = ConnectionFactory.getConnection();
    }
    
    public boolean save(Categoria categoria){
        
        String sql = "INSERT INTO CATEGORIA (descricao) VALUES (?)";
                
        PreparedStatement stmt = null;
        
        try { 
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro; " + ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;

       
        
    }
    
    
    
}
