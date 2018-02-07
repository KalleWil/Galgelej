package galgeleg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.xml.ws.Endpoint;

public class GalgeServer 
{
    public static void main(String[] args) throws RemoteException, MalformedURLException 
    {
        java.rmi.registry.LocateRegistry.createRegistry(1450);//(1099);
        
        GalgeInterface g = new Galgelogik();
        // Naming.rebind("rmi://ubuntu4.saluton.dk:9919/GalgeServer", g);    // rmi
        //Endpoint.publish("http://ubuntu4.saluton.dk:9919/kontotjeneste", g); // soap
	Endpoint.publish("http://ubuntu4.saluton.dk:9919/GalgeServer", g); // soap. Serveren udgiver sig som "GalgeServer"
		
        System.out.println("Galgeserver opstartet");
        
    }
}
