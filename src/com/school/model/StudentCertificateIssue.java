package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StudentCertificateIssue generated by hbm2java
 */
@Entity
@Table(name="student_certificate_issue"
    
)
public class StudentCertificateIssue  implements java.io.Serializable {


     private Integer id;
     private Student student;
     private String certificateName;
     private Date issueDate;
     private String remarks;

    public StudentCertificateIssue() {
    }

	
    public StudentCertificateIssue(Student student) {
        this.student = student;
    }
    public StudentCertificateIssue(Student student, String certificateName, Date issueDate, String remarks) {
       this.student = student;
       this.certificateName = certificateName;
       this.issueDate = issueDate;
       this.remarks = remarks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_student_id", nullable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="certificate_name", length=100)
    public String getCertificateName() {
        return this.certificateName;
    }
    
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="issue_date", length=10)
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    @Column(name="remarks", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }




}


