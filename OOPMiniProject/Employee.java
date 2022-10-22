/*
* Employee CLASS THAT HOLDS DATA ON ALL TYPES OF EMPLOYEES
* AND HAS GETTER METHODS FOR ALL THE FIELDS OF THE CLASS
*/

public class Employee {

    // PRIVATE METHODS OF THIS CLASS
    private String name;
    private int id;
    private static int IDCounter = 0;

    // CONSTRUCTOR THAT ASSIGNS UNIQUE ID AND NAME TO EMPLOYEE OBJECT
    public Employee(String name){
        this.id = IDCounter++;
        this.name = name;
    }

    // GETTER METHOD TO RETRIEVE THE ID OF THE EMPLOYEE
    public int getID(){
        return this.id;
    }

    // GETTER METHOD TO RETRIEVE THE NAME OF THE EMPLOYEE
    public String getName(){
        return this.name;
    }

}