package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.IDAO;
import com.solvd.navigator.dao.IDriverLicenseDAO;
import com.solvd.navigator.model.DriverLicense;

import java.util.List;

public class DriverLicenseDAO extends MyBatisDAO implements IDriverLicenseDAO {

    @Override
    public DriverLicense getById(long id) {
        return executeWithSession(session -> {
            IDriverLicenseDAO driverLicenseMapper = session.getMapper(IDriverLicenseDAO.class);
            return driverLicenseMapper.getById(id);
        });
    }

    @Override
    public List<DriverLicense> getAll() {
        return executeWithSession(session -> {
            IDriverLicenseDAO driverLicenseMapper = session.getMapper(IDriverLicenseDAO.class);
            return driverLicenseMapper.getAll();
        });
    }

    @Override
    public void insert(DriverLicense driverLicense) {
        executeWithSession(session -> {
            IDriverLicenseDAO driverLicenseMapper = session.getMapper(IDriverLicenseDAO.class);
            driverLicenseMapper.insert(driverLicense);
            return null;
        });
    }

    @Override
    public void update(DriverLicense driverLicense) {
        executeWithSession(session -> {
            IDriverLicenseDAO driverLicenseMapper = session.getMapper(IDriverLicenseDAO.class);
            driverLicenseMapper.update(driverLicense);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            IDriverLicenseDAO driverLicenseMapper = session.getMapper(IDriverLicenseDAO.class);
            driverLicenseMapper.delete(id);
            return null;
        });
    }
}
