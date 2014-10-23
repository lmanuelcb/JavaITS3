

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Car car = new Car();
		
		String make = request.getParameter("make");
		car.setMake(make);
		String model = request.getParameter("model");
		car.setModel(model);
		String year = request.getParameter("year");
		car.setYear(Integer.parseInt(year));
		String engineSize = request.getParameter("enginesize");
		car.setEnginesize(Integer.parseInt(engineSize));
		String fuel = request.getParameter("fuel");
		car.setFuel(fuel);
		String price = request.getParameter("price");
		car.setPrice(Integer.parseInt(price));
		String otherInfo = request.getParameter("otherinfo");
		car.setOtherInfo(otherInfo);
		
		request.setAttribute("car", car);
		
		System.out.println(car.toString());
		
		
		String view="ServerReplyCar.jsp";
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
