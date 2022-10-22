/*
* EmployeesRegistry CLASS THAT ALLOWS THE MAIN CLASS TO ACCESS DATA AND METHODS IN THE
* SUBCLASSES VIA THIS CLASS. ALLOWS THE USER TO MANIPULATE DATA THROUGHOUT THE PROGRAM
* USING VARIOUS METHODS
*/

import java.util.ArrayList;

public class EmployeesRegistry {

    // DECLARATION OF PRIVATE FIELDS INCLUDING ARRAYLISTS OF DIFFERENT EMPLOYEES AND TOTAL PRODUCTS SOLD
    private ArrayList<Employee> allEmployees;
    private ArrayList<Employee> hrEmployees;
    private ArrayList<Employee> salesEmployees;
    private int totalProductsSold;

    // CONSTRUCTOR OF THE CLASS THAT SETS THE totalProductsSold TO 0 AND MAKES NEW ARRAYLISTS
    public EmployeesRegistry(){
        allEmployees = new ArrayList<>();
        hrEmployees = new ArrayList<>();
        salesEmployees = new ArrayList<>();
        totalProductsSold = 0;
    }

    // METHOD THAT RETURNS THE ARRAYLIST SIZE WITH ALL THE EMPLOYEES
    public int returnNumOfEmployees(){
        int numOfEmployees = allEmployees.size();

        return numOfEmployees;
    }

    // METHOD THAT ADDS A NEW HR EMPLOYEE TO THE SYSTEM
    public void addHrEmployee(Employee e){
        allEmployees.add(e);
        hrEmployees.add(e);
    }

    // METHOD THAT ADDS A NEW SALES EMPLOYEE TO THE SYSTEM
    public void addSalesEmployee(Employee e){
        allEmployees.add(e);
        salesEmployees.add(e);
    }

    // METHOD THAT RETURNS THE ARRAYLIST WITH ALL THE EMPLOYEES
    public ArrayList<Employee> returnAllEmployees(){
        return allEmployees;
    }

    // METHOD THAT RETURNS THE ARRAYLIST WITH ALL SALES EMPLOYEES
    public ArrayList<Employee> returnSalesEmployees(){
        return salesEmployees;
    }

    // METHOD THAT RETURNS THE ARRAYLIST WITH ALL HR EMPLOYEES
    public ArrayList<Employee> returnHrEmployees(){
        return hrEmployees;
    }

    // METHOD THAT RETURNS A STRING OF THE DESIRED EMPLOYEE'S ID AND NAME
    public String getEmployeeInfo(Employee e){
        return (e.getID()+": "+e.getName());
    }

    // METHOD THAT SELLS A PRODUCT AS A SALES EMPLOYEE
    public void sellProduct(Sales s){
        s.sellProduct();
        totalProductsSold++;
    }

    // METHOD THAT RETURNS THE TOTAL PRODUCTS SOLD IN THE BUSINESS
    public int returnTotalProductsSold(){
        return totalProductsSold;
    }

    // METHOD THAT RETURNS THE TOTAL PRODUCTS SOLD FOR A SPECIFIC SALES EMPLOYEE
    public int returnEmployeeProductsSold(Sales s){
        return s.returnProductsSold();
    }

    // METHOD THAT MEETS A CUSTOMER AS AN HR EMPLOYEE
    public void meetCustomer(Sales s){
        s.meetCustomer();
    }

    // METHOD THAT HIRES AN EMPLOYEE AS AN HR EMPLOYEE
    public void hireEmployee(HR h){
        h.hireEmployee();
    }

    // METHOD THAT FIRES AN EMPLOYEE AS AN HR EMPLOYEE
    public void fireEmployee(HR h){
        h.fireEmployee();
    }

    // METHOD THAT GIVES BENEFITS TO AN EMPLOYEE AS AN HR EMPLOYEE
    public void giveBenefits(HR h){
        h.giveBenefits();
    }

    // METHOD THAT CHANGES THE MANAGER OF THE BUSINESS
    public void changeManager(Manager m){
        m.changeManager();
    }

}