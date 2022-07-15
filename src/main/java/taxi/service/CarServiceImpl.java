package taxi.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.CarDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    @Inject
    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    public CarServiceImpl(){

    }

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        logger.info("Method 'addDriverToCar' was called. "
                + "Parameters on call: driver = {} car ={}", driver, car);
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        logger.info("Method 'removeDriverFromCar' was called. "
                + "Parameters on call: driver = {} car ={}", driver, car);
        car.getDrivers().remove(driver);
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        logger.info("Method 'getAllByDriver' was called. "
                + "Parameters on call: driverId = {}", driverId);
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        logger.info("Method 'create' was called. "
                + "Parameters on call: car = {}", car);
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        logger.info("Method 'get' was called. "
                + "Parameters on call: id = {}", id);
        return carDao.get(id).get();
    }

    @Override
    public List<Car> getAll() {
        logger.info("Method 'getAll' was called. ");
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        logger.info("Method 'update' was called. "
                + "Parameters on call: car = {}", car);
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Method 'delete' was called. "
                + "Parameters on call: id = {}", id);
        return carDao.delete(id);
    }
}
