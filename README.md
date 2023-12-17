# JDBC Quickstart
In this repository, we are going to create a project with JDBC step by step for learning to connect to the database in Java with JDBC.
Working with JDBC in Java is a fundamental skill for interacting with databases. Starting from establishing a connection, performing queries, and updating data, there's a lot to learn. 📚

## What is JDBC?
JDBC is indeed the Java Database Connectivity, which provides exactly! JDBC (Java Database Connectivity) is indeed a Java API that provides a standard interface for accessing relational databases. It allows Java programs to connect to and interact with a wide range of databases using SQL. Through JDBC, developers can execute SQL statements, retrieve results, and update data in a database. JDBC provides a set of classes and interfaces for database operations, making it easier to work with databases in Java applications.

## Dependencies
We use Maven to manage dependencies in our project. For this tutorial, we need PostgreSQL JDBC Driver because we want to connect a database on PostgreSQL
and we have to add the following dependency to your pom.xml.
``` XML
<!-- Add the following dependency to your pom.xml, -->
<!-- replacing LATEST with specific version as required -->

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>LATEST</version>
</dependency>
```

### What is Maven?
Maven is a software project management and comprehension tool mainly used for Java-based projects.
It can help you build, publish, and deploy your projects, as well as manage their dependencies and documentation.

### What is PostgreSQL JDBC Driver?
PostgreSQL JDBC Driver (PgJDBC for short) allows Java programs to connect to a PostgreSQL database using standard,
database-independent Java code. It is an open-source JDBC driver written in Pure Java (Type 4)
and communicates in the PostgreSQL native network protocol.

## Connect to PostgreSQL
For connection to the database we create the class DatabaseConnectionManager with methode getConnection
that return Connection type. the DatabaseConnectionManager has two fields URL (string) and properties(Properties) that we initialize in its constructor.

```java
public class DatabaseConnectionManager {
    private final String url;
    private final Properties properties;

    public DatabaseConnectionManager(String host, String database, String username, String password){
        this.url = "jdbc:postgresql://"+ host + ":5432/" + database;
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.properties);
    }
}
```
In methode main, we create an instance from DatabaseConnectionManager and call the getConnection method
in this repository we use a shop database you can create and insert data in your PC [this](https://www.w3schools.com/postgresql/postgresql_create_demodatabase.php) link.
