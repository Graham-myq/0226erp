package com.sxt.sys.common;

import java.util.ArrayList;
import java.util.List;

public class TreenNodeBuilder {

    /**
     *把没有层级关系的集合变成有层级关系的集合
     */
    public static List<TreenNode> build(List<TreenNode> treenNodes, Integer topPid) {
        ArrayList<TreenNode> nodes = new ArrayList<>();
        for (TreenNode n1 : treenNodes) {
            if (n1.getPid() == topPid) {
                nodes.add(n1);
            }
            for (TreenNode n2 : treenNodes) {
                if (n1.getId() == n2.getPid()) {
                    n1.getChildren().add(n2);
            }
        }

    }
        return nodes;
    }
}
