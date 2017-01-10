package com.nfpenterprise.gameHub.characterClass.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.characterClass.dto.ClassDto;

@XmlRootElement(name = "classes") 
public class ClassesWrapper {

    private List<ClassDto> classes;

    @XmlElement(name = "class")
    public List<ClassDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDto> classes) {
        this.classes = classes;
    }

}
