package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Campus generated by hbm2java
 */
@Entity
@Table(name="campus")
public class Campus  implements java.io.Serializable {


     private Integer campusId;
     private String name;
     private String location;
     private String remarks;
     private Set<EmpAccounts> empAccountses = new HashSet<EmpAccounts>(0);
     private Set<FeesStructure> feesStructures = new HashSet<FeesStructure>(0);
     private Set<StudentClassReg> studentClassRegs = new HashSet<StudentClassReg>(0);

    public Campus() {
    }

	
    public Campus(String name) {
        this.name = name;
    }
    public Campus(String name, String location, String remarks, Set empAccountses, Set feesStructures, Set studentClassRegs) {
       this.name = name;
       this.location = location;
       this.remarks = remarks;
       this.empAccountses = empAccountses;
       this.feesStructures = feesStructures;
       this.studentClassRegs = studentClassRegs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="campus_id", unique=true, nullable=false)
    public Integer getCampusId() {
        return this.campusId;
    }
    
    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }
    
    @Column(name="name", nullable=false, length=200)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="location", length=500)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    @Column(name="remarks", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="campus")
    public Set<EmpAccounts> getEmpAccountses() {
        return this.empAccountses;
    }
    
    public void setEmpAccountses(Set empAccountses) {
        this.empAccountses = empAccountses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="campus")
    public Set<FeesStructure> getFeesStructures() {
        return this.feesStructures;
    }
    
    public void setFeesStructures(Set feesStructures) {
        this.feesStructures = feesStructures;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="campus")
    public Set<StudentClassReg> getStudentClassRegs() {
        return this.studentClassRegs;
    }
    
    public void setStudentClassRegs(Set studentClassRegs) {
        this.studentClassRegs = studentClassRegs;
    }


    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }


}


