/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbConnectivity;

import java.io.Serializable;

/**
 *
 * @author LS5028230
 */
public class Emp implements Serializable{
      int ID;
      String name;
      double salary;

      public Emp(int ID, String name, double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
      }

    @Override
    public String toString() {
        return "Emp{" + "ID=" + ID + ", name=" + name + ", salary=" + salary + '}';
    }
      
  }
