package com.entityService;

import com.HibernateUtil;
import com.entity.Invoice;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class InvoiceService {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Invoice> getAllInvoices() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Invoice.class);
        List list = criteria.list();
        session.getTransaction().commit();
        session.close();

        return list;
    }

    public void saveInvoice(Invoice invoice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(invoice);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteInvoice(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Invoice invoice = (Invoice)session.load(Invoice.class, new Long(id));
        session.delete(invoice);
        session.getTransaction().commit();
        session.close();
    }

    public Invoice getInvoiceById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Invoice invoice = (Invoice)session.load(Invoice.class, new Long(id));
        session.getTransaction().commit();
        session.close();
        return invoice;
    }

    public void updateInvoice(Invoice invoice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(invoice);
        session.getTransaction().commit();
        session.close();
    }
  }
