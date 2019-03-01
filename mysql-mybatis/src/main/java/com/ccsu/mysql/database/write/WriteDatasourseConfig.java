package com.ccsu.mysql.database.write;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author wenzhenyu
 * @description 数据源
 * @date 2018/12/29
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = WriteDatasourseConfig.PACKAGE, sqlSessionFactoryRef = "writeSqlSessionFactory")
public class WriteDatasourseConfig {



//    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.ccsu.mysql.dao.write";
    static final String MAPPER_LOCATION = "classpath:mapper/write/*.xml";
//
    @Value("${spring.writer.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.writer.datasource.username}")
    private String username;
    @Value("${spring.writer.datasource.password}")
    private String password;
    @Value("${spring.writer.datasource.driverClassName}")
    private String driverClass;
//    @Primary
    @Bean(name = "writeDataSource")
    public DataSource getMysqlDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean(name = "writeSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("writeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "writeTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("writeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "writeSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("writeSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


//    @Bean(name = "writeDataSource")
//    //下面这个注解控制哪个实例优先被注入，我们放在第一个数据源上面
////    @Primary
////    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.spring")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(jdbcUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
////        return new DruidDataSource();
//
//    }

//    @Bean(name = "writeSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory readSqlSessionFactory(@Qualifier("writeDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
//        return bean.getObject();
//    }











}
