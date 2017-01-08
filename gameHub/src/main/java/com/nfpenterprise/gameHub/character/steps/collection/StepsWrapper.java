package com.nfpenterprise.gameHub.character.steps.collection;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nfpenterprise.gameHub.character.steps.dto.StepsDto;

@XmlRootElement(name = "steps")
public class StepsWrapper {

    private List<StepsDto> steps;

    @XmlElement(name = "step")
    public List<StepsDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepsDto> steps) {
        this.steps = steps;
    }
}
