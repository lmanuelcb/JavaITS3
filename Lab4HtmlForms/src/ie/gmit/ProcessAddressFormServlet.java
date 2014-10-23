package ie.gmit;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessAddressFormServlet
 */
@WebServlet("/ProcessAddressFormServlet")
public class ProcessAddressFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAddressFormServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		
		String firstName = request.getParameter("firstname");
		contact.setFirstName(firstName);
		String addressOne = request.getParameter("address1");
		contact.setAddressone(addressOne);
		String addressTwo = request.getParameter("address2");
		contact.setAddresstwo(addressTwo);
		String age = request.getParameter("age");
		contact.setAge(Integer.parseInt(age));
	    String startDate = request.getParameter("dob");
	    try {
	    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			contact.setDateOfBirth(df.parse(startDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    request.setAttribute("contact", contact);
		
		System.out.println(contact.toString());
		
		
		String view="ProcessAddressFormView.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
