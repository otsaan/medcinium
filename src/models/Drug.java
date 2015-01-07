/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author otsaan
 */
public class Drug {

    
    int drugId;
    String drugName;
    String drugDescription;
    
    
   

    public int getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getDrugDescription() {
        return drugDescription;
    }

  

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setDrugDescription(String drugDescription) {
        this.drugDescription = drugDescription;
    }

   

    @Override
    public String toString() {
        return "Drug{" + "drugId=" + drugId + ", drugName=" + drugName + ", drugDescription=" + drugDescription +  '}';
    }
   
   
   
    

}
