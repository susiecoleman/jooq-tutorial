import static org.jooq.codegen.maven.example.Tables.AUTHOR;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Main {
  public static void main(String[] args) {
    final var username = "postgres";
    final var password = "test";
    final var url = "jdbc:postgresql://localhost:5430/library";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
      DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
      Result<Record> result = create.select().from(AUTHOR).fetch();
      for (Record record : result) {
        Integer id = record.getValue(AUTHOR.ID);
        String firstName = record.getValue(AUTHOR.FIRST_NAME);
        String lastName = record.getValue(AUTHOR.LAST_NAME);

        System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
      }
    }

    // For the sake of this tutorial, let's keep exception handling simple
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
