package com.xcn.springboottest.bsi.kouzhan;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author: xupeng.guo
 * @date: 2019/10/14
 * @description
 */
@Intercepts(value = {
//        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
//        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
//        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class}),
       // @Signature(type = ResultSetHandler.class, method = "query", args = {MappedStatement.class}),
       // @Signature(type = ParametorHandler.class, method = "query", args = {MappedStatement.class}),
})
public class MyInteceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
