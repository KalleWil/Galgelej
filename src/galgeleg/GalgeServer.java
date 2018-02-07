package galgeleg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.xml.ws.Endpoint;

public class GalgeServer 
{
    public static void main(String[] args) throws RemoteException, MalformedURLException, Exception 
    {
        java.rmi.registry.LocateRegistry.createRegistry(1450);//(1099);
        
        GalgeInterface g = new Galgelogik();
         //Naming.rebind("rmi://localhost:9919/GalgeServer", g);    // rmi - localhost
        Endpoint.publish("http://localhost:9919/GalgeServer", g); // soap - localhost
	//Endpoint.publish("http://ubuntu4.saluton.dk:9919/GalgeServer", g); // soap. Serveren udgiver sig som "GalgeServer"
		
        System.out.println("Galgeserver opstartet");
        
    }
}
