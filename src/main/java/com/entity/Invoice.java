package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "invoice", schema = "entrepreneurship")
@Setter
@Getter
@ToString
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NUMBER")
    private long number;

    @Column(name = "NAME")
    private String name;

   @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date date; //дата создания

    @Column(name = "HOURS_AMOUNT")
    private float hours_amount;       //количество отработанных часов

    @Column(name = "PRICE")
    private float price;       //стоимость часа

    @Column(name = "SUM")
    private float sum;      //сумма

    @Column(name = "ID_Contract")
    private long id_contract;      //идентификатор договора


    @Column(name = "PAID")
    private boolean paid;      //оплачено

    public Invoice(long number, Date date, float hours_amount, float price, float sum, long id_contgract, boolean paid){
         this.number = number;
         this.date = date;
         this.name = new StringBuilder("Invoice №").append(number).append(" from ").append(formatDate(date)).toString();
         this.hours_amount = hours_amount;
         this.price = price;
         this.sum = sum;
         this.id_contract = id_contract;
         this.paid = paid;
    }

    public Invoice(){

    }

    public String getDate(){
        return formatDate(this.date);
    }

    public Invoice getInvoiceById(long id){
        return this;
    }

    public static String formatDate(Date dateNow){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        return formatForDateNow.format(dateNow);
    }

}
