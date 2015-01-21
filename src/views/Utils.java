/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zianwar
 */
public class Utils {
    
   
    public static  DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    public static  int getAge(Date date) {  
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        //set up date of birth  
        Calendar calDOB = Calendar.getInstance();  
        calDOB.set(  calendar.get(Calendar.YEAR) , calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));  
        //setup calNow as today.  
        Calendar calNow = Calendar.getInstance();  
        calNow.setTime(new java.util.Date());  
        //calculate age in years.  
        int ageYr = (calNow.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR));  
        // calculate additional age in months, possibly adjust years.  
        int ageMo = (calNow.get(Calendar.MONTH) - calDOB.get(Calendar.MONTH));  
        
        if (ageMo < 0) {  
            //adjust years by subtracting one  
            ageYr--;
        }  
        
        return ageYr;  
    }

    public static String dateFormatter(Date dateToParse){
        return new SimpleDateFormat("yyyy-MM-dd").format(dateToParse);
    }
    
    public static boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {
            return false;
        }

        return true;
    }
 
    
}
