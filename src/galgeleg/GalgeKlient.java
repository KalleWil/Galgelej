/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Julian
 * FEJL:
 * Tror umiddelbart ikke, at der oprettes et wsdl dokument når serveren oprettes.
 */
public class GalgeKlient 
{
      public static void main(String[] args) throws Exception 
    {
        
        //GalgeInterface spil = (GalgeInterface) Naming.lookup("rmi://localhost:1099/GalgeServer");
        //Galgelogik spil = new Galgelogik(); // ændr således at logik udføres fra server
        
        
        URL url = new URL("http://localhost:9919/GalgeServer?wsdl"); // soap - Forbinder til det navn serveren udgiver sig på "GalgeServer"
        QName qname = new QName("http://galgeleg/", "GalgelogikService");
        
        Service service = Service.create(url, qname);
        GalgeInterface spil = service.getPort(GalgeInterface.class);
        
        
        boolean aktiv = true;
        String gæt;
        Scanner tastatur = new Scanner(System.in);
        
       
        
        while (aktiv)
        {
            System.out.println("Indtast bogstav");
            gæt = tastatur.next();
            spil.gætBogstav(gæt);   
            System.out.println(spil.outputTilKlient());
            if (spil.erSpilletSlut()) aktiv = false; // forbereder næste trin i spillet
            spil.logStatus();       
            System.out.println(spil.outputTilKlient());    
           }
      
        System.out.println("Spillet afsluttes/Forbindelse til server lukkes");
       
    }
}
