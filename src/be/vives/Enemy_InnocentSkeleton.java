package be.vives;

import java.util.ArrayList;

public class Enemy_InnocentSkeleton extends Enemy{
    public Enemy_InnocentSkeleton() {
        super("Innocent Skeleton", 150, 1, 100,new ArrayList<>());
        addItemToDroptable(new Item_WoodenSword());
    }
}
