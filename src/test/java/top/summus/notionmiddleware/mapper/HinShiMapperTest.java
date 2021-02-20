package top.summus.notionmiddleware.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.summus.notionmiddleware.model.HinShi;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HinShiMapperTest {
    @Autowired private DataSource dataSource;
    @Autowired private HinShiMapper hinShiMapper;

    @Test
    void test() throws SQLException {
        HinShi hinShi = new HinShi();
        hinShi.setAccent(1);
        hinShi.setSpell("abc");
        hinShi.setMeaning("sdfsdfsdf");
        int id = hinShiMapper.insert(hinShi);
        System.out.println(id);
    }

}