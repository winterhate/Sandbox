package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    static class Mutable {
        int state = 0;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Mutable)) return false;

            Mutable mutable = (Mutable) o;

            if (state != mutable.state) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return state;
        }

        @Override
        public String toString() {
            return "Mutable{" +
                    "state=" + state +
                    '}';
        }
    }

    public static void main(String[] args) {

        Map<Mutable, String> map = new HashMap<>();

        final Mutable mutable = new Mutable();
        map.put(mutable, "item");

//        mutable.state = 1;

        System.out.println(map.get(mutable));

        Set<Map.Entry<Mutable, String>> entries = map.entrySet();
        for(Map.Entry<Mutable, String> entry : entries) {
            final Mutable key = entry.getKey();
            final boolean found = key.equals(mutable);
            System.out.printf("%s => %s, %s\n", key, entry.getValue(), found);
        }

    }

}
