package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.IReviewDAO;
import com.solvd.navigator.model.Review;

import java.util.List;

public class ReviewDAO extends MyBatisDAO implements IReviewDAO {
    @Override
    public Review getById(long id) {
        return executeWithSession(session -> {
            IReviewDAO reviewMapper = session.getMapper(IReviewDAO.class);
            return reviewMapper.getById(id);
        });
    }

    @Override
    public List<Review> getAll() {
        return executeWithSession(session -> {
            IReviewDAO reviewMapper = session.getMapper(IReviewDAO.class);
            return reviewMapper.getAll();
        });
    }

    @Override
    public void insert(Review review) {
        executeWithSession(session -> {
            IReviewDAO reviewMapper = session.getMapper(IReviewDAO.class);
            reviewMapper.insert(review);
            return null;
        });
    }

    @Override
    public void update(Review review) {
        executeWithSession(session -> {
            IReviewDAO reviewMapper = session.getMapper(IReviewDAO.class);
            reviewMapper.update(review);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            IReviewDAO reviewMapper = session.getMapper(IReviewDAO.class);
            reviewMapper.delete(id);
            return null;
        });
    }
}
