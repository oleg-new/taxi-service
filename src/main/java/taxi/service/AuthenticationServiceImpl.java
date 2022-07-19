package taxi.service;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.exception.AuthenticationException;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);
    @Inject
    private DriverService driverService;

    public AuthenticationServiceImpl(DriverService driverService) {
        this.driverService = driverService;
    }
/*
    an empty constructor is required for the injector to work
*/

    public AuthenticationServiceImpl() {

    }

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        logger.info("Method 'login' was called. Parameters on call: login = {}", login);
        Optional<Driver> driver = driverService.findByLogin(login);
        if (driver.isPresent() && driver.get().getPassword().equals(password)) {
            return driver.get();
        }
        throw new AuthenticationException("Login or password was incorrect!");
    }
}
