import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiImplementation extends UnicastRemoteObject implements Api {

    private List<Student> data;

    public ApiImplementation(String name) throws RemoteException {
        super();
        try {
            data = this.readFile();
            System.out.println("Rebind Object " + name);
            Naming.rebind(name, this);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ArrayList<Student> readFile() {
        ArrayList<Student> s = new ArrayList<Student>();
        File file = new File("file.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] regex = sc.nextLine().split(" ");
                String idGroup = regex[0];
                int id = Integer.parseInt(regex[1]);
                String lastName = regex[2].split(",")[0];
                String name = regex[2].split(",")[1];
                List<Float> grades = new ArrayList<Float>();
                grades.add(Float.parseFloat(regex[3]));
                grades.add(Float.parseFloat(regex[4]));
                s.add(new Student(name, lastName, grades, id, idGroup));

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return s;

    }

    public String getNamebyId(int id) throws RemoteException {
        for (Student c : this.data) {
            if (c.getId() == id) {
                return c.getName();
            }
        }
        return null;
    }

    public Float getAverage(String name) throws RemoteException {
        for (Student c : this.data) {
            if (c.getName().equals(name)) {
                return (c.getGrades().get(0) + c.getGrades().get(1)) / 2;
            }
        }
        return null;

    }

    public Float getAverage(int id) throws RemoteException {
        for (Student c : this.data) {
            if (c.getId() == id) {
                return (c.getGrades().get(0) + c.getGrades().get(1)) / 2;
            }
        }
        return null;

    };

    public String getGroupId(int id) throws RemoteException {
        for (Student c : this.data) {
            if (c.getId() == id) {
                return c.getIdGroup();
            }
        }
        return null;
    }

    public String getGroup(String id) throws RemoteException {
        String rt = "Integrantes:\n";
        for (Student c : this.data) {
            if (c.getIdGroup().equals(id)) {
                rt += c.getName()+ "\n";
            }
        }
        return rt;
    }

}