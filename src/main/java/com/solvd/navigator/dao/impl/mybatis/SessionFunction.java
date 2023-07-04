package com.solvd.navigator.dao.impl.mybatis;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

@FunctionalInterface
public interface SessionFunction<T> {
    T apply(SqlSession session) throws SQLException;
}
