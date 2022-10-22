/*
 * THIS IS THE MANAGER CLASS WHICH IS A SUBCLASS OF THE EMPLOYEE CLASS AND INHERITS THE NAME FROM THE SUPERCLASS
 * THIS CLASS ALSO HAS A UNIQUE METHOD FOR THE MANAGER EMPLOYEE
 * */

public class Manager extends Employee{

    // CONSTRUCTOR METHOD WHICH INHERITS THE NAME FROM THE SUPERCLASS
    public Manager(String name){
        super(name);
    }

    // METHOD WHICH CHANGES THE MANAGER OF THE BUSINESS
    public void changeManager(){
        System.out.println("The new manager is "+this.getName());
    }
}