package AllTime;

/*
Write a program that takes lines segments as input, and outputs the view from above
for these segments. You can assume no two segments whose intervals overlap have
the same height. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class LineSegment {
    int left, right, color, height;

    LineSegment(int left, int right, int color, int height) {
        this.left = left;
        this.right = right;
        this.color = color;
        this.height = height;
    }
}

public class Endpoint implements Comparable<Endpoint> {
    boolean isLeft;
    LineSegment line;

    public Endpoint(boolean isleft, LineSegment linesegment) {
        this.isLeft = isLeft;
        this.line = linesegment;
    }

    public int value() {
        return isLeft ? line.left : line.right;
    }

    @Override
    public int compareTo(Endpoint e) {
        return Integer.compare(value(), e.value());
    }

    public List<LineSegment> calculateViewFromAbove(List<LineSegment> A) {
        java.util.List<Endpoint> sortedEndpoints = new ArrayList<>();
        for (LineSegment a : A) {
            sortedEndpoints.add(new Endpoint(true, a));
            sortedEndpoints.add(new Endpoint(false, a));
        }
        Collections.sort(sortedEndpoints);
        List<LineSegment> result = new ArrayList<>();
        int prevXAxis = sortedEndpoints.get(0).value();
        LineSegment prev = null;
        TreeMap<Integer, LineSegment> activeLineSegments = new TreeMap<>();
        for (Endpoint endpoint : sortedEndpoints) {
            if (!activeLineSegments.isEmpty() && prevXAxis != endpoint.value()) {
                if (prev == null) {
                    prev = new LineSegment(prevXAxis, endpoint.value(), activeLineSegments.lastEntry().getValue().color, activeLineSegments.lastEntry().getValue().height);
                } else {
                    if (prev.height == activeLineSegments.lastEntry().getValue().height &&
                            prev.color == activeLineSegments.lastEntry().getValue().color &&
                            prevXAxis == prev.right) {
                        prev.right = endpoint.value();
                    } else {
                        result.add(prev);
                        prev = new LineSegment(prevXAxis, endpoint.value(),
                                activeLineSegments.lastEntry().getValue().color,
                                activeLineSegments.lastEntry().getValue().height);
                    }
                }
            }
            prevXAxis = endpoint.value();
            if (endpoint.isLeft) {
                activeLineSegments.put(endpoint.line.height, endpoint.line);
            } else {
                activeLineSegments.remove(endpoint.line.height);
            }
        }
        if (prev != null) {
            result.add(prev);
        }
        return result;
    }
}