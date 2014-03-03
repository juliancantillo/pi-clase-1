/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package punto2;

import java.util.ArrayList;

/**
 * Universidad del Valle
 * @author Julian Andres Cantillo // cod: 1431263 - 3743
 */
public class Student {
    
    private String code;
    private String name;
    private String career;
    private ArrayList<Asignament> asignaments;

    Student(String name, String code, String career) {
        this.code = code;
        this.name = name;
        this.career = career;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public ArrayList<Asignament> getAsignaments() {
        return asignaments;
    }

    public void setAsignaments(ArrayList<Asignament> asignaments) {
        this.asignaments = asignaments;
    }
 
    
}