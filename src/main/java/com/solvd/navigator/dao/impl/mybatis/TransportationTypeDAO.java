package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.ITransportationTypeDAO;
import com.solvd.navigator.model.TransportationType;

import java.util.List;

public class TransportationTypeDAO extends MyBatisDAO implements ITransportationTypeDAO {
    @Override
    public TransportationType getById(long id) {
        return executeWithSession(session -> {
            ITransportationTypeDAO transportationTypeMapper = session.getMapper(ITransportationTypeDAO.class);
            return transportationTypeMapper.getById(id);
        });
    }

    @Override
    public List<TransportationType> getAll() {
        return executeWithSession(session -> {
            ITransportationTypeDAO transportationTypeMapper = session.getMapper(ITransportationTypeDAO.class);
            return transportationTypeMapper.getAll();
        });
    }

    @Override
    public void insert(TransportationType transportationType) {
        executeWithSession(session -> {
            ITransportationTypeDAO transportationTypeMapper = session.getMapper(ITransportationTypeDAO.class);
            transportationTypeMapper.insert(transportationType);
            return null;
        });
    }

    @Override
    public void update(TransportationType transportationType) {
        executeWithSession(session -> {
            ITransportationTypeDAO transportationTypeMapper = session.getMapper(ITransportationTypeDAO.class);
            transportationTypeMapper.update(transportationType);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            ITransportationTypeDAO transportationTypeMapper = session.getMapper(ITransportationTypeDAO.class);
            transportationTypeMapper.delete(id);
            return null;
        });
    }
}
