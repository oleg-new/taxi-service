package taxi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import taxi.dao.ManufacturerDao;
import taxi.model.Manufacturer;

class ManufacturerServiceImplTest {
    private ManufacturerService manufacturerService;
    private ManufacturerDao manufacturerDao;
    private Manufacturer manufacturer;
    private List<Manufacturer> manufacturersList;

    @BeforeEach
    void setUp() {
        manufacturerDao = Mockito.mock(ManufacturerDao.class);
        manufacturerService = new ManufacturerServiceImpl(manufacturerDao);
        manufacturer = new Manufacturer();
        manufacturer.setId(2L);
        manufacturer.setName("name");
        manufacturer.setCountry("GB");
        manufacturersList = new ArrayList<>(List.of(manufacturer));
    }

    @Test
    void create_Ok() {
        Mockito.when(manufacturerDao.create(manufacturer)).thenReturn(manufacturer);
        Manufacturer actual = manufacturerService.create(manufacturer);
        assertNotNull(actual);
        assertEquals(manufacturer, actual);
    }

    @Test
    void get_Ok() {
        Mockito.when(manufacturerDao.get(manufacturer.getId()))
                .thenReturn(Optional.of(manufacturer));
        Manufacturer actual = manufacturerService.get(manufacturer.getId());
        assertNotNull(actual);
        assertEquals(manufacturer, actual);
    }

    @Test
    void getAll_Ok() {
        Mockito.when(manufacturerDao.getAll()).thenReturn(manufacturersList);
        List actual = manufacturerService.getAll();
        assertNotNull(actual);
        assertEquals(manufacturersList, actual);
    }

    @Test
    void update_Ok() {
        Mockito.when(manufacturerDao.update(manufacturer)).thenReturn(manufacturer);
        Manufacturer actual = manufacturerDao.update(manufacturer);
        assertNotNull(actual);
        assertEquals(manufacturer, actual);
    }

    @Test
    void delete_Ok() {
        Mockito.when(manufacturerDao.delete(manufacturer.getId())).thenReturn(true);
        boolean actual = manufacturerDao.delete(manufacturer.getId());
        assertTrue(actual);
    }

    @Test
    void delete_Return_False_Not_Ok() {
        Mockito.when(manufacturerDao.delete(manufacturer.getId())).thenReturn(false);
        boolean actual = manufacturerDao.delete(manufacturer.getId());
        assertFalse(actual);
    }
}
