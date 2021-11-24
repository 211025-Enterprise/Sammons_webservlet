package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import persistence.Dao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class testerclass {

    public testerclass(){}

    public testerclass(String name, int age, boolean alive){

        this.name= name;
        this.age = age;
        this.alive = alive;
    }




    String name;
    int age;
    boolean alive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


    @Override
    public String toString() {
        return "testerclass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                '}';
    }
}

