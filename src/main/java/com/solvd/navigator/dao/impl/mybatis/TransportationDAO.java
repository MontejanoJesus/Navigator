package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.ITransportationDAO;
import com.solvd.navigator.model.Transportation;

import java.util.List;

public class TransportationDAO extends MyBatisDAO implements ITransportationDAO {
    @Override
    public Transportation getById(long id) {
        return executeWithSession(session -> {
            ITransportationDAO transportationMapper = session.getMapper(ITransportationDAO.class);
            return transportationMapper.getById(id);
        });
    }

    @Override
    public List<Transportation> getAll() {
        return executeWithSession(session -> {
            ITransportationDAO transportationMapper = session.getMapper(ITransportationDAO.class);
            return transportationMapper.getAll();
        });
    }

    @Override
    public void insert(Transportation transportation) {
        executeWithSession(session -> {
            ITransportationDAO transportationMapper = session.getMapper(ITransportationDAO.class);
            transportationMapper.insert(transportation);
            return null;
        });
    }

    @Override
    public void update(Transportation transportation) {
        executeWithSession(session -> {
            ITransportationDAO transportationMapper = session.getMapper(ITransportationDAO.class);
            transportationMapper.update(transportation);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            ITransportationDAO transportationMapper = session.getMapper(ITransportationDAO.class);
            transportationMapper.delete(id);
            return null;
        });
    }
}
