package taxi.service;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Logger logger = LogManager.getLogger(DriverServiceImpl.class);

    @Inject
    private DriverDao driverDao;

    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    public DriverServiceImpl(){

    }

    @Override
    public Driver create(Driver driver) {
        logger.info("Method 'create' was called. "
                + "Parameters on call: driver = {}", driver);
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        logger.info("Method 'get' was called. "
                + "Parameters on call: id = {}", id);
        return driverDao.get(id).get();
    }

    @Override
    public List<Driver> getAll() {
        logger.info("Method 'getAll' was called. ");
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        logger.info("Method 'update' was called. "
                + "Parameters on call: driver = {}", driver);
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Method 'delete' was called. "
                + "Parameters on call: id = {}", id);
        return driverDao.delete(id);
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        logger.info("Method 'findByLogin' was called. "
                + "Parameters on call: login = {}", login);
        return driverDao.findByLogin(login);
    }
}
