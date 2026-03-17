package com.demo.Ishita;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.Ishita.beans.Employee;

public class App{

    public static void main(String[] args) {

        ApplicationContext ac =
                new ClassPathXmlApplicationContext("springConf.xml");

        Employee emp = (Employee) ac.getBean("employee");

        System.out.println("Employee details");
        System.out.println("---------------------");

        System.out.println(emp);

       
    }
}