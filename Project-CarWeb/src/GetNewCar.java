import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lmanuelcb on 10/25/2014.
 */
public class GetNewCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarClass car = new CarClass();

        String reg = request.getParameter("reg");
        car.setReg(reg);
        String make = request.getParameter("make");
        car.setMake(make);
        String model = request.getParameter("model");
        car.setModel(model);
        String year = request.getParameter("year");
        car.setYear(Integer.parseInt(year));
        String price = request.getParameter("price");
        car.setPrice(Integer.parseInt(price));
        String status = request.getParameter("status");
        car.setStatus(status);

        request.setAttribute("car", car);

        System.out.println(car.toString());


        String view="ServerReplyCar.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
