package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
public class CustomerController {

    private ArrayList<Customer> customers;

    public CustomerController(){
        customers = new ArrayList<Customer>();
        customers.add(new Customer("1010", "John", true, 25));
        customers.add(new Customer("1018", "Peter", true, 24));
        customers.add(new Customer("1019", "Sara", false, 23));
        customers.add(new Customer("1110", "Rose", false, 23));
        customers.add(new Customer("1001", "Emma", false, 30));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    @RequestMapping(value = "/customersbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomersByID(@PathVariable("id") String id){
        for (Customer c : customers) {
            if (c.getID().equals(id)) {
                return c;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customersbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomersByName(@PathVariable("name") String name){
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.GET)
    public boolean delCustomerByID(@PathVariable("id") String id){
        for (Customer c : customers) {
            if (c.getID().equals(id)) {
                customers.remove(c);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.GET)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for (Customer c : customers) {
            if (c.getName().equals(n)) {
                customers.remove(c);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@PathParam("id") String id, @PathParam("name") String name, @PathParam("age") int age, @PathParam("sex") String sex){
        boolean sex_con;
        if (sex.equals("male")){
            sex_con = true;
        }else{
            sex_con = false;
        }
        customers.add(new Customer(id, name, sex_con, age));
        return true;
    }

    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@PathParam("id") String id, @PathParam("name") String name, @PathParam("age") int age, @PathParam("sex") String sex){
        boolean sex_con;
        if (sex.equals("male")){
            sex_con = true;
        }else{
            sex_con = false;
        }
        customers.add(new Customer(id, name, sex_con, age));
        return true;
    }
}
