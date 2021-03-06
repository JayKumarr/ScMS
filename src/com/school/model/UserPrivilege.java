package com.school.model;
// Generated Dec 9, 2014 7:01:06 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserPrivilege generated by hbm2java
 */
@Entity
@Table(name="user_privilege"
    
)
public class UserPrivilege  implements java.io.Serializable {

     private Integer id;
     private TgUser tgUser;
     private Module module;
     private Boolean isActive;
     private Boolean isAdd;
     private Boolean isDelete;
     private Boolean isUpdate;

    public UserPrivilege() {
    }

	
    public UserPrivilege(TgUser tgUser, Module module) {
        this.tgUser = tgUser;
        this.module = module;
    }
    public UserPrivilege(TgUser tgUser, Module module, Boolean isActive, Boolean isAdd, Boolean isDelete, Boolean isUpdate) {
       this.tgUser = tgUser;
       this.module = module;
       this.isActive = isActive;
       this.isAdd = isAdd;
       this.isDelete = isDelete;
       this.isUpdate = isUpdate;
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false, length=11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tg_user_id", nullable=false)
    public TgUser getTgUser() {
        return this.tgUser;
    }
    
    public void setTgUser(TgUser tgUser) {
        this.tgUser = tgUser;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id", nullable=false)
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    @Column(name="is_active")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    @Column(name="is_add")
    public Boolean getIsAdd() {
        return this.isAdd;
    }
    
    public void setIsAdd(Boolean isAdd) {
        this.isAdd = isAdd;
    }
    
    @Column(name="is_delete")
    public Boolean getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    @Column(name="is_update")
    public Boolean getIsUpdate() {
        return this.isUpdate;
    }
    
    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
    

 @Override
    public String toString() {
        return module.getName(); //To change body of generated methods, choose Tools | Templates.
    }


}


