package com;

import com.entity.Invoice;
import com.entityService.InvoiceService;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InvoiceService invoiceService = new InvoiceService();

        float sum = 10000;
        float hours_amount = 176;
        float price = sum/hours_amount;
        long id_contract = 1;
        Invoice invoice = new Invoice(15,  new Date(), hours_amount, price, sum, id_contract, false);
        invoiceService.saveInvoice(invoice);
        Map beans = new HashMap();
        beans.put("invoice", invoice);
        XLSTransformer transformer = new XLSTransformer();
        try {
           transformer.transformXLS("./src/main/resources/templates/templateAct.xls", beans, "D:\\Act.xls");
           transformer.transformXLS("./src/main/resources/templates/templateInvoice.xls", beans, "D:\\Invoice.xls");
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println(invoiceService.getAllInvoices());
    }

   }
