package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class Task_1
{
    public static void main( String[] args )
    {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite::memory:";
            connection = DriverManager.getConnection(url);

            String[] queries = {
                    """
                    CREATE TABLE test_table (
                    	id INTEGER PRIMARY KEY,
                    	surname VARCHAR NOT NULL,
                    	experience INTEGER
                    );""",
                    "INSERT INTO test_table(surname, experience) VALUES('Иванов', 10);",
                    "INSERT INTO test_table(surname, experience) VALUES('Петров', 12);",
                    "INSERT INTO test_table(surname, experience) VALUES('Сидоров', 14);",
                    "INSERT INTO test_table(surname, experience) VALUES('Сидоров', 14);",
                    "INSERT INTO test_table(surname, experience) VALUES('Сидоров', 14);"
            };

            for (String sql : queries) {
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
            }
            
            String sql = """
                SELECT surname
                FROM test_table
                WHERE experience < (SELECT MAX(experience) FROM test_table)
                ORDER BY experience DESC
                LIMIT 1;""";
            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println(rs.getString("surname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
