package com.min.test.java8.lambda.datahandle;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * DataHandlerDemo
 *
 * @author zhangsl
 * @date 2018/8/29 13:51
 */
public class DataHandlerDemo {

    @Test
    public void test01() {
        List<String> stringList = Arrays.asList("a2", "a1", "b1", "b2", "c2", "c2");

        //Filter
        stringList
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        //Sorted
        stringList
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        //Map
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        //Match
        boolean anyStartsWithA = stringList
                .stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        boolean alllStartsWithA = stringList
                .stream()
                .allMatch(s -> s.startsWith("a"));
        System.out.println(alllStartsWithA);

        boolean noneStartsWithZ = stringList
                .stream()
                .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);

        //Count
        long startsWithB = stringList
                .stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);

        //Reduce
        Optional<String> reduce = stringList
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduce.ifPresent(System.out::println);

        //Parallel Streams
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        long t2 = System.nanoTime();
        long count1 = values.parallelStream().sorted().count();
        System.out.println(count1);
        long t3 = System.nanoTime();

        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis1));

        //以下开始非lambda
        //Map
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
             map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);
        System.out.println(map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);
        System.out.println(map.get(9));

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);
        System.out.println(map.get(23));

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);
        System.out.println(map.get(3));

        map.remove(3, "val3");
        map.get(3);

        map.remove(3, "val33");
        map.get(3);

        map.getOrDefault(42, "not found");

        //map实例拼接
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);

        //时间api
        //Clock
        Clock clock = Clock.systemDefaultZone();
        long millis2 = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        //Timezones
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //LocalTime
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));

        //.....
    }
}
