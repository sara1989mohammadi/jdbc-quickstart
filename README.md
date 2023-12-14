# JDBC Quickstart
In this repository we are going to create a project with JDBC step by step for learning connect to database in java with JDBC

## What is JDBC?
JDBC stands for Java Database Connectivity. It is a Java API that allows Java applications to connect and execute queries with various databases. 
It provides a standard abstraction for database communication, and supports different types of JDBC drivers.
JDBC also offers classes and interfaces for data access and processing in relational databases.

## Dependencies
We use Maven for manage dependencies our project. For this tutorial we need PostgreSQL JDBC Driver because we want to connect a database on PostgreSQL
and we hava to add the following dependency to your pom.xml.
```xml
<!-- Add the following dependency to your pom.xml, -->
<!-- replacing LATEST with specific version as required -->

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>LATEST</version>
</dependency>
```

### What is Maven?
Maven is a software project management and comprehension tool that is mainly used for Java-based projects.
It can help you with building, publishing, and deploying your projects, as well as managing their dependencies and documentation.

### What is PostgreSQL JDBC Driver?
PostgreSQL JDBC Driver (PgJDBC for short) allows Java programs to connect to a PostgreSQL database using standard,
database independent Java code. Is an open source JDBC driver written in Pure Java (Type 4),
and communicates in the PostgreSQL native network protocol.

## Connect to PostgreSQL
For conntect to the database we create class DatabaseConnectionManager with methode getConnection
that return Connection type. the DatabaseConnectionManager has two fields url(string) and properties(Properties) that we initializations in its constroctor.

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
In methode main we create instance from DatabaseConnectionManager and call getConnection methode
in this repository we use shop database you can create and insert data in your pc [this](https://www.w3schools.com/postgresql/postgresql_create_demodatabase.php) link.
