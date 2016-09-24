package org.com.unitech.config.hibernate;

import org.com.unitech.exceptions.DataSourceException;
import org.com.unitech.exceptions.SessionFactoryLoadingException;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class HibernateConfigurationTest {

    @Mock
    private static Environment environment;
    @Mock
    private DataSource dataSource;

    @InjectMocks
    HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void initialize() {
        when(environment.getRequiredProperty("jdbc.driverClassName")).thenReturn("com.mysql.jdbc.Driver");
        when(environment.getRequiredProperty("jdbc.url")).thenReturn("jdbc:mysql://localhost:3306/Reports");
        when(environment.getRequiredProperty("jdbc.username")).thenReturn("someUserName");
        when(environment.getRequiredProperty("jdbc.password")).thenReturn("somePassWord");
        when(environment.getRequiredProperty("hibernate.dialect")).thenReturn("org.hibernate.dialect.MySQLDialect");
        when(environment.getRequiredProperty("hibernate.show_sql")).thenReturn("true");
        when(environment.getRequiredProperty("hibernate.format_sql")).thenReturn("true");
    }

    @Test
    public void dataSourceMethodShouldReturnDataSourceObject() throws Exception {

        DataSource dataSource = hibernateConfiguration.dataSource();
        Assert.assertNotNull(dataSource);

    }

    @Test
    public void dataSourceMethodShouldThrowException() throws Exception {
        when(environment.getRequiredProperty("jdbc.driverClassName")).thenReturn(null);
        exception.expect(DataSourceException.class);
        exception.expectMessage(contains("Problem in Loading DataSource"));
        DataSource dataSource = hibernateConfiguration.dataSource();
        Connection connection = dataSource.getConnection();
    }

    @Test
    public void sessionFactoryShouldReturnSessionFactoryObject() throws Exception {
          LocalSessionFactoryBean localSessionFactoryBean = hibernateConfiguration.sessionFactory();
        Assert.assertNotNull(localSessionFactoryBean);
    }

    @Test
    public void sessionFactoryShouldThrowException() throws Exception {
        when(environment.getRequiredProperty("hibernate.dialect")).thenReturn(null);
        exception.expect(SessionFactoryLoadingException.class);
        exception.expectMessage(contains("Problem in Loading Session Factory"));
        LocalSessionFactoryBean localSessionFactoryBean = hibernateConfiguration.sessionFactory();
        Assert.assertNotNull(localSessionFactoryBean);
    }
}
