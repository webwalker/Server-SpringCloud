package com.xujian.thinking.guava;

import com.google.common.collect.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xujian on 2019-06-16
 */
public class GuavaBasic {

    public static void main(String[] args) throws Exception {
        //集合创建
        Map<String, Map<String, String>> map = Maps.newHashMap();
        List<List<Map<String, String>>> list1 = Lists.newArrayList();

        //集合初始化
        Set<String> set = Sets.newHashSet("one", "two", "three");
        List<String> list2 = Lists.newArrayList("one", "two", "three");

        //不可变的集合
        ImmutableSet<String> immutableSet1 = ImmutableSet.of("RED", "GREEN");
        //Builder 模式来构造一个集合
        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        ImmutableSet<String> immutableSet2 = builder.add("RED").addAll(set).build();

        //一种key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
        Multimap<String, Person> customersByType = ArrayListMultimap.create();
        customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 20));
        customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 30));
        //重复的可以会获取到一个list集合
        customersByType.get("abc");

        //把重复的元素放入集合，并且可以统计重复元素的个数
        Multiset<Integer> multiSet = HashMultiset.create();
        multiSet.add(10);
        multiSet.add(30);
        multiSet.add(30);
        multiSet.add(40);
        System.out.println(multiSet.count(30)); // 2
        System.out.println(multiSet.size());    //4

        //相当于有两个key的map
        Table<Integer, Integer, Person> personTable = HashBasedTable.create();
        personTable.put(1, 20, new Person(1, 1, "a", "46546", 1, 20));
        personTable.put(0, 30, new Person(2, 1, "ab", "46546", 0, 30));
        // 得到行集合
        Map<Integer, Person> rowMap = personTable.row(0);
        int maxAge = Collections.max(rowMap.keySet());

        //双向map
        //Map 只能保证 key 的不重复，BiMap 保证 value 也不重复，提供inverse()方法，可以通过key得到value，也可以通过value得到key
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "hello");
        biMap.put(2, "my");
        int value = biMap.inverse().get("my");

        //有时map的key并不是一种类型，他们是很多类型，你想通过映射他们得到这种类型，guava提供了ClassToInstanceMap满足了这个目的，除了继承自Map接口，
        // ClassToInstaceMap提供了方法 T getInstance(Class<T>) 和 T putInstance(Class<T>, T),消除了强制类型转换。
        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.putInstance(Person.class, new Person(1, 20, "abc", "46464", 1, 100));
        Person person = classToInstanceMap.getInstance(Person.class);

        //谓词是一个简单的接口，只有一个方法返回布尔值，但是他是一个很令人惊讶的集合方法，当你结合collections2.filter方法使用，
        // 这个筛选方法返回原来的集合中满足这个谓词接口的元素。比如要按性别筛选：　　
        /*Collections2.filter(personList, new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                return input.getSex() == 0;
            }
        });
        Lists.transform(personList, new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return input.getName();
            }
        });*/

        //超级强大的 Map 构造类，是用来构造 ConcurrentMap 的工具类
        /*ConcurrentMap<String, Object> mapAll = new MapMaker()
                .concurrencyLevel(8)
                .weakKeys()
                .weakValues()
                .expireAfterWrite(30, TimeUnit.SECONDS)
                .maximumSize(100)
                .makeComputingMap(
                        new Function<String, Object>() {
                            public Object apply(String key) {
                                return createObject(key);
                            }});
        */

        //非常灵活的排序类，大家知道用Comparator 作为比较器来对集合排序，但是对于多关键字排序 Ordering class 可以简化很多的代码
        /*Lists.newArrayList(30, 20, 60, 80, 10);
        Ordering.natural().sortedCopy(numbers); //10,20,30,60,80
        Ordering.natural().reverse().sortedCopy(numbers); //80,60,30,20,10
        Ordering.natural().min(numbers); //10
        Ordering.natural().max(numbers); //80
        Lists.newArrayList(30, 20, 60, 80, null, 10);
        Ordering.natural().nullsLast().sortedCopy(numbers); //10, 20,30,60,80,null
        Ordering.natural().nullsFirst().sortedCopy(numbers); //null,10,20,30,60,80

        List<Person> personList = Lists.newArrayList(
                new Person(3, 1, "abc", "46546", 0, 25),
                new Person(2, 1, "ab", "46546", 0, 30),
                new Person(5, 1, "ade", "46546", 0, 27)
        );
        Ordering<Person> byAge = new Ordering<Person>() {
            @Override
            public int compare(Person left, Person right) {
                return right.getAge() - left.getAge();
            }
        };
        for (Person p : byAge.immutableSortedCopy(personList)) {
            System.out.println(p);
        }*/

        // 使用ComparisonChain比较多字段
    }

    public static class Person {
        public Person(int i, int i1, String a, String s, int i2, int i3) {
        }
    }
}
