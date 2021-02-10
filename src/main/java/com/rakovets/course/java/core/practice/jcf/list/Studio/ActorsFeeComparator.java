package com.rakovets.course.java.core.practice.jcf.list.Studio;

import java.util.Comparator;

public class ActorsFeeComparator implements Comparator<Actor> {

    @Override
    public int compare(Actor o1, Actor o2) {
        return Double.compare(o1.getFee(), o2.getFee());
    }
}
