
import com.entityService.InvoiceService;
import com.entity.Invoice;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/save")
public class ServletService extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InvoiceService invoiceService = new InvoiceService();
         if(request.getParameter("add")!=null){
            float sum = 10000;
            float hours_amount = 176;
            float price = sum/hours_amount;
            long id_contract = 1;
            Invoice invoice = new Invoice(Integer.parseInt(request.getParameter("number")), new Date(), hours_amount, price, sum, id_contract, false);
            invoiceService.saveInvoice(invoice);
            request.setAttribute("list",invoiceService.getAllInvoices());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request,response);
        }
        if(request.getParameter("showAll")!=null){
            request.setAttribute("list",invoiceService.getAllInvoices());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request,response);
        }
         String action=request.getParameter("action");
        if(action.equalsIgnoreCase("update")){
          request.setAttribute("hero",invoiceService.getInvoiceById(Integer.parseInt(request.getParameter("id"))));
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("update.jsp");
            requestDispatcher.forward(request,response);
        }
        if(action.equalsIgnoreCase("delete")){
            invoiceService.deleteInvoice(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("list",invoiceService.getAllInvoices());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request,response);
        }
        if(action.equalsIgnoreCase("print")){
            Map beans = new HashMap();
            beans.put("invoice", invoiceService.getInvoiceById(Integer.parseInt(request.getParameter("id"))));
            XLSTransformer transformer = new XLSTransformer();
            try {
                transformer.transformXLS("templates/templateAct.xls", beans, "D:\\Act.xls");
                transformer.transformXLS("templates/templateInvoice.xls", beans, "D:\\Invoice.xls");
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }


            request.setAttribute("list",invoiceService.getAllInvoices());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoiceService invoiceService = new InvoiceService();
        if (request.getParameter("update") != null) {
            Invoice updatedInvoice = invoiceService.getInvoiceById(Integer.parseInt(request.getParameter("id")));
            invoiceService.updateInvoice(updatedInvoice);
            request.setAttribute("list", invoiceService.getAllInvoices());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
