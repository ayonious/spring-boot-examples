package bdd.utils;

import static java.lang.String.format;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

import bdd.config.WithContext;
import cucumber.api.java8.En;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DBUtils {

  @Autowired
  private DataSource dataSource;

  public long addEmptyRow(String table) {
    try (Connection conn = dataSource.getConnection()) {

      val result = conn
          .prepareStatement("INSERT INTO " + table + " () VALUES ()", RETURN_GENERATED_KEYS);
      if (result.executeUpdate() == 1) {
        ResultSet rs = result.getGeneratedKeys();
        if (rs.next()) {
          return rs.getLong(1);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(format("Problem with adding row in %s", table), e);
    }
    throw new RuntimeException(format("Problem with adding row in %s", table));
  }
}
