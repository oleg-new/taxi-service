package taxi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import taxi.dao.CarDao;
import taxi.model.Car;
import taxi.model.Driver;

class CarServiceImplTest {
    private CarService carService;
    private CarDao carDao;
    private Car car;
    private List<Car> carsList;
    private Driver driver;

    @BeforeEach
    void setUp() {
        carDao = Mockito.mock(CarDao.class);
        carService = new CarServiceImpl(carDao);
        driver = new Driver();
        driver.setId(5L);
        car = new Car();
        car.setId(2L);
        car.setDrivers(new ArrayList<>(List.of(driver)));
        carsList = new ArrayList<>(List.of(car));
    }

    @Test
    void getAllByDriver_Ok() {
        Mockito.when(carDao.getAllByDriver(driver.getId())).thenReturn(List.of(car));
        List<Car> actual = carService.getAllByDriver(driver.getId());
        assertNotNull(actual);
        assertEquals(carsList, actual);
    }

    @Test
    void getAllByDriver_Error_Id_Not_Ok() {
        List<Car> carList = new ArrayList<>(List.of(car));
        Mockito.when(carDao.getAllByDriver(driver.getId())).thenReturn(List.of(car));
        List<Car> actual = carService.getAllByDriver(2L);
        assertNotNull(actual);
        assertNotEquals(carList, actual);
    }

    @Test
    void create_Ok() {
        Mockito.when(carDao.create(car)).thenReturn(car);
        Car actual = carService.create(car);
        assertNotNull(actual);
        assertEquals(car,actual);
    }

    @Test
    void get_Ok() {
        Mockito.when(carDao.get(car.getId())).thenReturn(Optional.of(car));
        Car actual = carService.get(2L);
        assertNotNull(actual);
        assertEquals(car, actual);
    }

    @Test
    void getAll_Ok() {
        Mockito.when(carDao.getAll()).thenReturn(carsList);
        List actual = carService.getAll();
        assertNotNull(actual);
        assertEquals(carsList, actual);
    }

    @Test
    void update_Ok() {
        Mockito.when(carDao.update(car)).thenReturn(car);
        Car actual = carDao.update(car);
        assertNotNull(actual);
        assertEquals(car, actual);
    }

    @Test
    void delete_Ok() {
        Mockito.when(carDao.delete(car.getId())).thenReturn(true);
        boolean actual = carDao.delete(car.getId());
        assertTrue(actual);
    }

    @Test
    void delete_Return_False_Not_Ok() {
        Mockito.when(carDao.delete(car.getId())).thenReturn(false);
        boolean actual = carDao.delete(car.getId());
        assertFalse(actual);
    }
}
