public interface Api extends java.rmi.Remote {

    public String getNamebyId(int id) throws java.rmi.RemoteException;

    public Float getAverage(String name) throws java.rmi.RemoteException;

    public Float getAverage(int id) throws java.rmi.RemoteException;

    public String getGroupId(int id) throws java.rmi.RemoteException;
    public String getGroup(String id) throws java.rmi.RemoteException;

}