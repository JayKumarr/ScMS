/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.report.bean;

import com.school.model.Years;

/**
 *
 * @author JAY KUMAR
 */
public class CustomYear extends com.school.model.Years{
    Years y;
    public CustomYear(Years y){
        this.y = y;
        setYearId(y.getYearId());
        setYearName(y.getYearName());
        setRemarks(y.getRemarks());
        setMonthses(y.getMonthses());
        setEvents(y.getEvents());
        setStudentClassRegs(y.getStudentClassRegs());
    }
    
    public Years getYears(){
        return y;
    }
    @Override
    public String toString() {
        return getRemarks(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
