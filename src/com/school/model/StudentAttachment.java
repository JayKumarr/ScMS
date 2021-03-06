package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StudentAttachment generated by hbm2java
 */
@Entity
@Table(name="student_attachment"
    
)
public class StudentAttachment  implements java.io.Serializable {

private int studentId;
     private Student student;
     private String attachementName;
     private byte[] attachment;
     private String remarks;

    public StudentAttachment() {
    }

	
    public StudentAttachment(int studentId, Student student) {
        this.studentId = studentId;
        this.student = student;
    }
    public StudentAttachment(int studentId, Student student, String attachementName, byte[] attachment, String remarks) {
       this.studentId = studentId;
       this.student = student;
       this.attachementName = attachementName;
       this.attachment = attachment;
       this.remarks = remarks;
    }
   
     @Id 
    
    @Column(name="student_id", unique=true, nullable=false)
    public int getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", unique=true, nullable=false, insertable=false, updatable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="attachement_name", length=100)
    public String getAttachementName() {
        return this.attachementName;
    }
    
    public void setAttachementName(String attachementName) {
        this.attachementName = attachementName;
    }
    
    
    @Column(name="attachment",length=65535)
    public byte[] getAttachment() {
        return this.attachment;
    }
    
    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
    
    @Column(name="remarks", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}


