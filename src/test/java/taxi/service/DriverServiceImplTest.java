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
import taxi.dao.DriverDao;
import taxi.model.Driver;

class DriverServiceImplTest {
    private static final Driver ANOTHER_DRIVER = new Driver();
    private DriverService driverService;
    private DriverDao driverDao;
    private Driver driver;
    private List<Driver> driversList;

    @BeforeEach
    void setUp() {
        driverDao = Mockito.mock(DriverDao.class);
        driverService = new DriverServiceImpl(driverDao);
        driver = new Driver();
        driver.setId(5L);
        driver.setName("drive");
        driver.setLogin("drive");
        driver.setPassword("passwd");
        driversList = new ArrayList<>(java.util.List.of(driver));
    }

    @Test
    void create_Ok() {
        Mockito.when(driverDao.create(driver)).thenReturn(driver);
        Driver actual = driverDao.create(driver);
        assertNotNull(actual);
        assertEquals(driver, actual);
    }

    @Test
    void create_Error_Not_() {
        Mockito.when(driverDao.create(driver)).thenReturn(driver);
        Driver actual = driverDao.create(driver);
        assertNotNull(actual);
        assertNotEquals(ANOTHER_DRIVER, actual);
    }

    @Test
    void get_Ok() {
        Mockito.when(driverDao.get(driver.getId())).thenReturn(Optional.of(driver));
        Driver actual = driverService.get(driver.getId());
        assertNotNull(actual);
        assertEquals(driver, actual);
    }

    @Test
    void get_Error_Wrong_Driver_Not_Ok() {
        Mockito.when(driverDao.get(driver.getId())).thenReturn(Optional.of(driver));
        Driver actual = driverService.get(driver.getId());
        assertNotNull(actual);
        assertEquals(driver, actual);
    }

    @Test
    void getAll_Ok() {
        Mockito.when(driverDao.getAll()).thenReturn(driversList);
        List actual = driverService.getAll();
        assertNotNull(actual);
        assertEquals(driversList, actual);
    }

    @Test
    void update_Ok() {
        Mockito.when(driverDao.update(driver)).thenReturn(driver);
        Driver actual = driverDao.update(driver);
        assertNotNull(actual);
        assertEquals(driver, actual);
    }

    @Test
    void update_Error_Wrong_Driver_Not_Ok() {
        Mockito.when(driverDao.update(driver)).thenReturn(driver);
        Driver actual = driverDao.update(driver);
        assertNotNull(actual);
        assertNotEquals(ANOTHER_DRIVER, actual);
    }

    @Test
    void delete_Ok() {
        Mockito.when(driverDao.delete(driver.getId())).thenReturn(true);
        boolean actual = driverDao.delete(driver.getId());
        assertTrue(actual);
    }

    @Test
    void delete_Error_Not_Ok() {
        Mockito.when(driverDao.delete(driver.getId())).thenReturn(false);
        boolean actual = driverDao.delete(driver.getId());
        assertFalse(actual);
    }

    @Test
    void findByLogin_Ok() {
        Mockito.when(driverDao.findByLogin(driver.getLogin())).thenReturn(Optional.of(driver));
        Optional<Driver> actual = driverDao.findByLogin(driver.getLogin());
        assertNotNull(actual);
        assertEquals(driver, actual.get());
    }

    @Test
    void findByLogin_Wrong_Driver_Not_Ok() {
        Mockito.when(driverDao.findByLogin(driver.getLogin())).thenReturn(Optional.of(driver));
        Optional<Driver> actual = driverDao.findByLogin(driver.getLogin());
        assertNotNull(actual);
        assertNotEquals(ANOTHER_DRIVER, actual.get());
    }
}
