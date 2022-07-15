package taxi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import taxi.exception.AuthenticationException;
import taxi.model.Driver;

class AuthenticationServiceImplTest {
    private AuthenticationService authenticationService;
    private DriverService driverService;
    private Driver driver;

    @BeforeEach
    void setUp() {
        driverService = Mockito.mock(DriverService.class);
        authenticationService = new AuthenticationServiceImpl(driverService);
        driver = new Driver();
        driver.setName("speedy");
        driver.setLogin("speedy");
        driver.setPassword("gonzales");
    }

    @Test
    void login_Ok()throws AuthenticationException {
        Mockito.when(driverService.findByLogin(driver.getLogin()))
                .thenReturn(Optional.ofNullable(driver));
        Driver actual = authenticationService.login(driver.getLogin(), driver.getPassword());
        assertNotNull(actual);
        assertEquals(driver,actual);
    }

    @Test
    void password_Error_Not_Ok()throws AuthenticationException {
        Mockito.when(driverService.findByLogin(driver.getLogin()))
                .thenReturn(Optional.ofNullable(driver));
        assertThrows(AuthenticationException.class,
                () -> authenticationService
                        .login(driver.getLogin(), "password"));
    }

}
