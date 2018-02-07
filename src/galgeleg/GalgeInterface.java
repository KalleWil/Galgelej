package galgeleg; // skal stå øverst

import java.rmi.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Julian
 */
@WebService // til soap
public interface GalgeInterface extends Remote
{
    @WebMethod void nulstil()              throws java.rmi.RemoteException;
    @WebMethod void logStatus()            throws java.rmi.RemoteException;
    @WebMethod void gætBogstav(String bogstav)  throws java.rmi.RemoteException;
    @WebMethod boolean erSpilletSlut()     throws java.rmi.RemoteException;
    @WebMethod String outputTilKlient()    throws java.rmi.RemoteException;
  
}
