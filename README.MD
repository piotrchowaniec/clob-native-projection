#Requirements

1. Java 8 JDK
1. Oracle Database 12c (json support required)


#How to run

1. Create schema in Oracle database executing:  
```
    -- drop table PERSON;
    
    create table PERSON
    (
        ID          NUMBER(19) not null
        primary key,
        DESCRIPTION CLOB,
    --     DESCRIPTION VARCHAR2(600 char),
        FIRST_NAME  VARCHAR2(255 char),
        LAST_NAME   VARCHAR2(255 char)
    );
    
    -- ALTER TABLE PERSON ADD CONSTRAINT ensure_json CHECK (DESCRIPTION IS JSON );
    
    INSERT INTO PERSON (id, description, first_name, last_name)
      VALUES(10, '
    {"color": "black",
    "rgb": [0,0,0],
    "hex": "#000000"}', 'Bilbo', 'Baggins' );
```

2. Update `src/main/resources/application.properties` file and change spring.datasource.url, username and password properties.
3. Run application: `./gradlew bootRun`
4. Try to get data: `curl http://localhost:8080/people?lastName=Baggins`