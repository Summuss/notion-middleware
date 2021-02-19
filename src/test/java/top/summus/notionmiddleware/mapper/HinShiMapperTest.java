package top.summus.notionmiddleware.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HinShiMapperTest {
    @Autowired private DataSource dataSource;

    @Test
    void test() throws SQLException {
        dataSource.getConnection();
    }

}