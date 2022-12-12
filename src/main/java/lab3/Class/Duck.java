package lab3.Class;

import java.util.*;

/**
 * class Duck for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 2.0.0
 */
public class Duck extends Animal implements Comparable<Duck>{
    /**
     * Internal attribute: color is color of duck
     * <p>
     * Internal attribute: parents is parents of duck
     */
    protected String color;
    protected List<Duck> parents;

    /**
     * Getter method
     * @return color
     */
    private String getColor() {
        return color;
    }
    private List<Duck> getParents() {return parents; }

    @Override
    public String toString() {
        return "\nDuck: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n"
                + "    Color: " + color + '\n'
                + "    Parents: " + parents + '\n';
    }
    /**
     * equals is override method for class Animals
     * <p>
     * @param o is object that is compared to the current object
     * @return true if ducks is equals or false if ducks isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Duck animal = (Duck) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else if (!getColor().equals(animal.getColor())) {
            return false;
        } else if (!getParents().equals(animal.getParents())) {
            return false;
        } else return getName().equals(animal.getName());
    }

    @Override
    public int compareTo(Duck o) {
        return (this.name).compareTo(o.name);
    }

    public void sortParentsByName() {
        Collections.sort(parents);
    }

    public void sortParentsByAge() {
        parents.sort(new Comparator<>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                if (o1.getAge() < o2.getAge())
                    return -1;
                else if (o1.getAge() == o2.getAge())
                    return 0;
                return 1;
            }
        });
    }

    public void sortParentsByAgeComparator() {
        parents.sort(Comparator.comparing(Duck::getAge));
    }


    public static class Builder {
        private final Duck newDuck;

        public Builder() {
            newDuck = new Duck();
        }

        public Duck.Builder withName(String name) {
            newDuck.name = name;
            return this;
        }

        public Duck.Builder withSex(String sex) {
            newDuck.sex = sex;
            return this;
        }

        public Duck.Builder withAge(int age) {
            newDuck.age = age;
            return this;
        }

        public Duck.Builder withColor(String color) {
            newDuck.color = color;
            return this;
        }

        public Duck.Builder withParents(List<Duck> parents) {
            newDuck.parents = parents;
            return this;
        }
        public Duck build() {
            return newDuck;
        }
    }
    /**
     * Setter method
     * @param color is color of duck
     */
    public void setColor(String color) {
        this.color = color;
    }
    public void eraseParent(Duck parent) {
        this.parents.remove(parent);
    }
    public void setParents(List<Duck> parents) {
        this.parents.addAll(parents);
    }
    public void setParent(Duck parent) {
        this.parents.add(parent);
    }

    public List<Duck> getParentsByNameStream(String name) {
        return parents.stream().filter(duck -> Objects.equals(duck.getName(), name)).toList();
    }
    public List<Duck> getParentsByName(String name) {
        List<Duck> result = new ArrayList<>();
        for (Duck parent : parents) {
            if (parent.getName().equals(name)) {
                result.add(parent);
            }
        }
        return result;
    }
    public List<Duck> getParentsByAgeStream(int age) {
        return parents.stream().filter(duck -> Objects.equals(duck.getAge(), age)).toList();
    }
    public List<Duck> getParentsByAge(int age) {
        List<Duck> result = new ArrayList<>();
        for (Duck parent : parents) {
            if (parent.getAge() == age) {
                result.add(parent);
            }
        }
        return result;
    }
    /**
     * voice is method which print line that duck croaks
     */
    public void voice() {
        System.out.print(name);
        System.out.println(" croaks");
    }

    public static void main(String... strings) {
        Duck animal1 = new Duck.Builder()
                .withName("Donald")
                .withSex("Male")
                .withAge(6)
                .withColor("grey")
                .build();
        System.out.println(animal1);
        animal1.setColor("brown");
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Mario");
        animal1.voice();
    }
}
