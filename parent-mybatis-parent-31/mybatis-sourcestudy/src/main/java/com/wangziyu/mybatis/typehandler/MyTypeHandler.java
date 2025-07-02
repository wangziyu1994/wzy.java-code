package com.wangziyu.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

/*@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Integer.class)*/
public class MyTypeHandler extends BaseTypeHandler<Integer> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("入参，调用自定义类型转换器");
        ps.setString(i,String.valueOf(parameter));
    }

    @Override
    public Integer getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println(columnName+"返回结果,调用自定义类型转换器");
        return Integer.valueOf(rs.getString(columnName));
    }

    @Override
    public Integer getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Integer.valueOf(rs.getString(columnIndex));
    }

    @Override
    public Integer getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Integer.valueOf(cs.getString(columnIndex));
    }
}
