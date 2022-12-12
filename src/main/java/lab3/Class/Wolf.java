package lab3.Class;

import java.util.*;

/**
 * class Wolf for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 2.0.0
 */
public class Wolf extends Animal implements Comparable<Wolf>{
    /**
     * Internal attribute: color is color of wolf
     * <p>
     * Internal attribute: parents is parents of wolf
     */
    protected String color;
    protected List<Wolf> parents;

    /**
     * Getter method
     * @return color
     */
    public String getColor() {
        return color;
    }
    public List<Wolf> getParents() {return parents; }

    @Override
    public String toString() {
        return "\nWolf: \n"
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
     * @return true if wolves is equals or false if wolves isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Wolf animal = (Wolf) o;

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
    public int compareTo(Wolf o) {
        return (this.name).compareTo(o.name);
    }
    public void sortParentsByName() {
        Collections.sort(parents);
    }

    public void sortParentsByAge() {
        parents.sort(new Comparator<>() {
            @Override
            public int compare(Wolf o1, Wolf o2) {
                if (o1.getAge() < o2.getAge())
                    return -1;
                else if (o1.getAge() == o2.getAge())
                    return 0;
                return 1;
            }
        });
    }

    public void sortParentsByAgeComparator() {
        parents.sort(Comparator.comparing(Wolf::getAge));
    }


    public static class Builder {
        private final Wolf newWolf;

        public Builder() {
            newWolf = new Wolf();
        }

        public Builder withName(String name){
            newWolf.name = name;
            return this;
        }
        public Builder withSex(String sex){
            newWolf.sex = sex;
            return this;
        }
        public Builder withAge(int age){
            newWolf.age = age;
            return this;
        }
        public Builder withColor(String color){
            newWolf.color = color;
            return this;
        }
        public Builder withParents(List<Wolf> parents) {
            newWolf.parents = parents;
            return this;
        }
        public Wolf build(){
            return newWolf;
        }
    }
    /**
     * Setter method
     * @param name is name of wolf
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * addAge is method that increases age by one
     */
    public void addAge() {
        age = this.age + 1;
    }
    /**
     * Setter method
     * @param sex is sex of wolf
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * Setter method
     * @param color is color of wolf
     */
    public void setColor(String color) {
        this.color = color;
    }
    public void eraseParent(Wolf parent) {
        this.parents.remove(parent);
    }
    public void setParents(List<Wolf> parents) {
        this.parents.addAll(parents);
    }
    public void setParent(Wolf parent) {
        this.parents.add(parent);
    }

    public List<Wolf> getParentsByNameStream(String name) {
        return parents.stream().filter(wolf -> Objects.equals(wolf.getName(), name)).toList();
    }
    public List<Wolf> getParentsByName(String name) {
        List<Wolf> result = new ArrayList<>();
        for (Wolf parent : parents) {
            if (parent.getName().equals(name)) {
                result.add(parent);
            }
        }
        return result;
    }
    public List<Wolf> getParentsByAgeStream(int age) {
        return parents.stream().filter(wolf -> Objects.equals(wolf.getAge(), age)).toList();
    }
    public List<Wolf> getParentsByAge(int age) {
        List<Wolf> result = new ArrayList<>();
        for (Wolf parent : parents) {
            if (parent.getAge() == age) {
                result.add(parent);
            }
        }
        return result;
    }
    /**
     * voice is method which print line that wolf howls
     */
    public void voice() {
        System.out.print(name);
        System.out.println(" howls");
    }

    public static void main(String... strings) {
        Wolf animal1 = new Wolf.Builder()
                .withName("Virginia")
                .withSex("Female")
                .withAge(6)
                .withColor("grey")
                .build();
        System.out.println(animal1);
        animal1.setColor("brown");
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Laura");
        animal1.voice();
    }
}