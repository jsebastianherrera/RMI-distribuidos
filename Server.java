

public class Server {
    public static void main(String[] args) {
        try {
            ApiImplementation api=new ApiImplementation("rmi://localhost:1099" + "/MiApi");
        } catch (Exception e) {
            System.out.println("Some server error ..." + e);
        }
    }
}