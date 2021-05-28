package AllTime;

import java.math.BigInteger;
import java.util.*;

public class LineWithMostPoints {

    private static class Line {
        private static class Rational {
            public Integer numerator;
            public Integer denominator;

            public Rational(Integer numerator, Integer denominator) {
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }

        public static Rational getCanonicalFractional(int a, int b) {
            int gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
            a /= gcd;
            b /= gcd;
            return b < 0 ? new Rational(-a, -b) : new Rational(a, b);
        }

        private Rational slope;
        private Rational intercept;

        Line(Point a, Point b) {

            if (a.x != b.x) {
                slope = getCanonicalFractional(b.y - a.y, b.x - a.x);
            } else {
                slope = new Rational(1, 0);
            }
            if (a.x != b.x) {
                intercept = getCanonicalFractional(b.x * a.y - a.x * b.y, b.x - a.x);
            } else {
                intercept = new Rational(a.x, 1);
            }
        }

        public int hashCode() {
            return Objects.hashCode(slope.numerator + slope.denominator +
                    intercept.numerator + intercept.denominator);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Line)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Line that = (Line) obj;
            return slope.equals(that.slope) && intercept.equals(that.intercept);


        }

        public static Line findLineWithMostPoints(List<Point> P) {
// Adds all possible lines into hash table.
            Map<Line, Set<Point>> table = new HashMap<>();
            for (int i = 0; i < P.size(); ++i) {
                for (int j = i + 1; j < P.size(); ++j) {
                    Line l = new Line(P.get(i), P.get(j));
                    Set<Point> si = table.get(l);
                    if (si == null) {
                        si = new HashSet<>();
                        table.put(l, si);
                    }
                    si.add(P.get(i));
                    Set<Point> s2 = table.get(l);
                    if (s2 == null) {
                        s2 = new HashSet<>();
                        table.put(l, s2);
                    }
                    s2.add(P.get(j));
                }
            }
            return Collections
                    .max(table.entrySet(),
                            new Comparator<Map.Entry<Line, Set<Point>>>() {
                                @Override
                                public int compare(Map.Entry<Line, Set<Point>> el, Map.Entry<Line, Set<Point>> e2) {
                                    if (el != null && e2 != null) {
                                        return Integer.compare(el.getValue().size(),
                                                e2.getValue().size());
                                    }
                                    return (el != null ? 1 : -1);
                                }
                            })
                    .getKey();
        }

    }
}