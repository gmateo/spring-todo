package com.davidsalter.todo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="items")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] priorityString = {"", "Low", "Normal", "High"};
	private Long id;
    private String description;
    private Date dueDate;
    private int priority;
    
	@Id
	@GeneratedValue
    public Long getId() {
    	return id;
    }

	public void setId(Long id) {
    	this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    public Date getDueDate() {
    	return dueDate;
    }
    
    public void setDueDate(Date dueDate) {
    	this.dueDate = dueDate;
    }
    
    public int getPriority() {
    	return priority;
    }
    
    public void setPriority(int priority) {
    	this.priority = priority;
    }
    
    public void setPriorityString() {
    	
    }
    
    @Transient
    public String getPriorityString() {
    	return priorityString[priority];
    }
    
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id: " + id);
        buffer.append("Description: " + description + ";");
        return buffer.toString();
    }
}
