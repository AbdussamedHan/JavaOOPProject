/*
 * THIS IS THE SALES CLASS WHICH IS A SUBCLASS OF THE EMPLOYEE CLASS AND INHERITS THE NAME FROM THE SUPERCLASS
 * THIS CLASS ALSO HAS UNIQUE METHODS FOR THE SALES EMPLOYEES
 * */

public class Sales extends Employee{

    // PRIVATE FIELD DECLARATION
    private int productsSold = 0;

    // CONSTRUCTOR METHOD WHICH INHERITS THE NAME FROM THE SUPERCLASS
    public Sales(String name){
        super(name);
    }

    // METHOD WHICH ALLOWS SALES EMPLOYEE TO MEET A CUSTOMER
    public void meetCustomer(){
        System.out.println("\n"+this.getName()+" met a new customer\n");
    }

    // METHOD WHICH ALLOWS SALES EMPLOYEE TO SELL A PROCUCT
    public void sellProduct(){
        System.out.println("\n"+this.getName()+" sold a product\n");
        this.productsSold++;
    }

    // METHOD WHICH RETURNS THE PRODUCTS SOLD FOR THIS SALES EMPLOYEE
    public int returnProductsSold(){
        return productsSold;
    }

}