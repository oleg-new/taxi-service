package taxi.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger logger = LogManager.getLogger(DriverServiceImpl.class);
    @Inject
    private ManufacturerDao manufacturerDao;

    public ManufacturerServiceImpl(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    public ManufacturerServiceImpl(){

    }

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        logger.info("Method 'create' was called. "
                + "Parameters on call: manufacturer = {}", manufacturer);
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        logger.info("Method 'get' was called. "
                + "Parameters on call: id = {}", id);
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        logger.info("Method 'getAll' was called. ");
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        logger.info("Method 'update' was called. "
                + "Parameters on call: manufacturer = {}", manufacturer);
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("Method 'delete' was called. "
                + "Parameters on call: id = {}", id);
        return manufacturerDao.delete(id);
    }
}
