import java.rmi.*;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Client {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Buscando Objeto ");
            Api api = (Api) Naming.lookup("rmi://" +
                    args[0] + "/" + "MiApi");
            while (true) {

                System.out.println("1. Buscar nombre por id");
                System.out.println("2. Obtener promedio por nombre");
                System.out.println("3. Obtener promedio por id");
                System.out.println("4. Buscar idgrupo por id ");
                System.out.println("5. Buscar integrantes por grupo");
                System.out.print(">");
                int input = sc.nextInt();

                switch (input) {
                    case 1:
                        System.out.print("ID:");
                        System.out.println("RTA:" + api.getNamebyId(sc.nextInt()));
                        break;
                    case 2:
                        System.out.print("NOMBRE:");
                        System.out.println("RTA:" + api.getAverage(sc.next()));
                        break;
                    case 3:
                        System.out.print("ID:");
                        System.out.println("RTA:" + api.getAverage(sc.nextInt()));
                        break;
                    case 4:
                        System.out.print("ID:");
                        System.out.println("RTA:" + api.getGroupId(sc.nextInt()));
                        break;
                    case 5:
                        System.out.print("GROUPID:");
                        System.out.println(api.getGroup(sc.next()));
                        break;
                    default:
                        System.out.println("Opcion no disponible");
                }

            }
        } catch (Exception e) {
            System.err.println(" System exception");
            sc.close();
        }
        sc.close();
        System.exit(0);
    }
}
