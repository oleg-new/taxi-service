package taxi.controller.car;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.lib.Injector;
import taxi.service.CarService;

public class DeleteCarController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(DeleteCarController.class);
    private static final Injector injector = Injector.getInstance("taxi");
    private final CarService carService = (CarService) injector.getInstance(CarService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        carService.delete(Long.parseLong(req.getParameter("id")));
        logger.info("Car removed. Params: id = {}",
                req.getParameter("id"));
        resp.sendRedirect(req.getContextPath() + "/cars");
    }
}
