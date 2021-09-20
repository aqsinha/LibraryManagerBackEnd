package com.sinhajee.librarymanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(updatable=false, nullable=false)
   private Long id;
   
   private String title;
   private String author;
   private String year_written;
   private String edition;
   private String price;

   @Column(updatable=false, nullable = false)
   private String serialNumber;
   
   public Book() {}


   public Book(String title, String author, String year_written, String edition, String price, String serialNumber) {
    this.title = title;
    this.author = author;
    this.year_written = year_written;
    this.edition = edition;
    this.price = price;
    this.serialNumber = serialNumber;
   }

   public Long getId() {
    return id;
   }

   public void setId(Long id) {
    this.id = id;
   }

   public String getTitle() {
    return title; 
   }

   public void setTitle(String title) {
    this.title = title;
   }

   public String getAuthor() {
    return author;
   }

   public void setAuthor(String author) {
    this.author = author;
   }
   
   public String getYear_Written() {
    return year_written;
   }

   public void setYear_Written(String year_written) {
    this.year_written = year_written;
   }

   public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
   }
   
   public String getSerialNumber() {
    return serialNumber;
   }

   public String getPrice() {
    return price;
   }


   public void setPrice(String price) {
    this.price = price;
   }


   public String getEdition() {
    return edition;
   }


   public void setEdition(String edition) {
    this.edition = edition;
   }

}
