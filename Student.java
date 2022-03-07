import java.util.List;

public class Student {

    private String name;
    private String lastName;
    private String idGroup;
    private int id;
    private List<Float> grades;
    @Override
    public String toString(){
        return "Nombre:" + name + "\n" + "Apellido:" +lastName+"\n";
    }
    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdGroup() {
        return this.idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Float> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Float> grades) {
        this.grades = grades;
    }

    public Student(String name,String lastNa, List<Float> grades, int id, String idGroup) {
        this.grades = grades;
        this.name = name;
        this.id = id;
        this.idGroup = idGroup;
    }


    public static void main(String[] args) {

    }

}