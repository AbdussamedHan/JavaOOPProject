/*
* THIS IS THE HR CLASS WHICH IS A SUBCLASS OF THE EMPLOYEE CLASS AND INHERITS THE NAME FROM THE SUPERCLASS
* THIS CLASS ALSO HAS UNIQUE METHODS FOR THE HR EMPLOYEES
* */

public class HR extends Employee{

    // CONSTRUCTOR METHOD THAT INHERITS THE NAME FROM THE SUPERCLASS
    public HR(String name){
        super(name);
    }

    // METHOD WHICH ALLOWS HR EMPLOYEE TO HIRE AN EMPLOYEE
    public void hireEmployee(){
        System.out.println(this.getName()+" hired a new employee");
    }

    // METHOD WHICH ALLOWS HR EMPLOYEE TO FIRE AN EMPLOYEE
    public void fireEmployee(){
        System.out.println(this.getName()+" fired an employee");
    }

    // METHOD WHICH ALLOWS HR EMPLOYEE TO GIVE BENEFITS TO AN EMPLOYEE
    public void giveBenefits(){
        System.out.println(this.getName()+" gave benefits");
    }

}