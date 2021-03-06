package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FeesDiscount generated by hbm2java
 */
@Entity
@Table(name="fees_discount"
)
public class FeesDiscount  implements java.io.Serializable {


     private Integer feesDiscountId;
     private Student student;
     private Integer isFixed;
     private Integer fixedAmount;
     private Integer discountAmount;
     private String remarks;

    public FeesDiscount() {
    }

	
    public FeesDiscount(Student student) {
        this.student = student;
    }
    public FeesDiscount(Student student, Integer isFixed, Integer fixedAmount, Integer discountAmount, String remarks) {
       this.student = student;
       this.isFixed = isFixed;
       this.fixedAmount = fixedAmount;
       this.discountAmount = discountAmount;
       this.remarks = remarks;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="fees_discount_id", unique=true, nullable=false)
    public Integer getFeesDiscountId() {
        return this.feesDiscountId;
    }
    
    public void setFeesDiscountId(Integer feesDiscountId) {
        this.feesDiscountId = feesDiscountId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Column(name="is_fixed")
    public Integer getIsFixed() {
        return this.isFixed;
    }
    
    public void setIsFixed(Integer isFixed) {
        this.isFixed = isFixed;
    }
    
    @Column(name="fixed_amount")
    public Integer getFixedAmount() {
        return this.fixedAmount;
    }
    
    public void setFixedAmount(Integer fixedAmount) {
        this.fixedAmount = fixedAmount;
    }
    
    @Column(name="discount_amount")
    public Integer getDiscountAmount() {
        return this.discountAmount;
    }
    
    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    @Column(name="remarks", length=100)
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}


