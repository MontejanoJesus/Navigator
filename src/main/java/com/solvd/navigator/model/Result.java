package com.solvd.navigator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Result")
public class Result {

    @XmlElement(name="Route")
    private List<Route> routeList;

    public Result(){
        this.routeList = new ArrayList<>();
    };

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public int total(){
        return 0;
    }

    @Override
    public String toString() {
        return "Result{" +
                "routeList=" + routeList +
                '}';
    }
}
