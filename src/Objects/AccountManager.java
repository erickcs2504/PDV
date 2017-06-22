package Objects;
import java.sql.*;
import java.io.*;
import java.util.*;// para usar vector
import Objects.*;
import AccesoDB.*;
import Multi.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick Cordero
 */
public class AccountManager
{
    private CLPDV clpdv;
    private Account unaCuenta;
    
    public AccountManager()
    {
       // unaCuenta=null;
    }
    
    
    
    public Account validateAccount(String pCed)
    {
        Account unaCuenta =null;
        MultiAccount multiAccount = new MultiAccount();
        try {
         unaCuenta= multiAccount.buscar(pCed);
                
        }
        catch (java.lang.Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return unaCuenta;
    }
    
    public boolean getAccountForUserName(String userName)
    {
        boolean existeUsuario=true;
        Account unaCuenta=null;
        
        
        
        return existeUsuario;
    }
    
}
