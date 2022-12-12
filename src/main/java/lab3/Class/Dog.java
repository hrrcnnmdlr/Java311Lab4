package lab3.Class;


import java.util.*;

/**
 * class Dog for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 2.0.0
 */
public class Dog extends Wolf implements Comparable<Wolf>{
    /**
     * Internal attribute: isMongrel is a variable that indicates whether the dog is a mongrel
     * <p>
     * Internal attribute: parents is parents of dog
     */
    protected boolean isMongrel;
    protected List<Dog> parents;
    /**
     * Getter method
     * @return isMongrel
     */
    public Boolean isMongrel() {
        return isMongrel;
    }
    public List<Dog> getDogParents() {return parents; }
    @Override
    public String toString() {
        return "\nDog: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n"
                + "    Color: " + color + '\n'
                + "    Dog is a mongrel: " + isMongrel + '\n'
                + "    Parents: " + parents + '\n';
    }
    /**
     * equals is override method for class Wolf
     * <p>
     * @param o is object that is compared to the current object
     * @return true if dogs is equals or false if dogs isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Dog animal = (Dog) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else if (!getColor().equals(animal.getColor())) {
            return false;
        } else if (!isMongrel().equals(animal.isMongrel())) {
            return false;
        } else if (!getDogParents().equals(animal.getDogParents())) {
            return false;
        } else return getName().equals(animal.getName());
    }

    public int compareTo(Dog o) {
        return (this.name).compareTo(o.name);
    }

    public void sortDogParentsByName() {
        Collections.sort(parents);
    }

    public void sortDogParentsByAge() {
        parents.sort(new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.getAge() < o2.getAge())
                    return -1;
                else if (o1.getAge() == o2.getAge())
                    return 0;
                return 1;
            }
        });
    }

    public void sortDogParentsByAgeComparator() {
        parents.sort(Comparator.comparing(Dog::getAge));
    }


    public static class Builder {
        private final Dog newDog;

        public Builder() {
            newDog = new Dog();
        }


        public Dog.Builder withName(String name){
            newDog.name = name;
            return this;
        }
        public Dog.Builder withSex(String sex){
            newDog.sex = sex;
            return this;
        }
        public Dog.Builder withAge(int age){
            newDog.age = age;
            return this;
        }
        public Dog.Builder withColor(String color){
            newDog.color = color;
            return this;
        }
        public Dog.Builder withParents(List<Dog> parents) {
            newDog.parents = parents;
            return this;
        }
        public Dog.Builder isMongrel(Boolean isMongrel){
            newDog.isMongrel = isMongrel;
            return this;
        }
        public Dog build(){
            return newDog;
        }
    }
    /**
     * Setter method
     * @param isMongrel is a variable that indicates whether the dog is a mongrel
     */
    public void changeMongrel(Boolean isMongrel) {
        this.isMongrel = isMongrel;
    }
    public void eraseDogParent(Dog parent) {
        this.parents.remove(parent);
    }
    public void setDogParents(List<Dog> parents) {
        this.parents.addAll(parents);
    }
    public void setDogParent(Dog parent) {
        this.parents.add(parent);
    }

    public List<Dog> getDogParentsByNameStream(String name) {
        return parents.stream().filter(dog -> Objects.equals(dog.getName(), name)).toList();
    }
    public List<Dog> getDogParentsByName(String name) {
        List<Dog> result = new ArrayList<>();
        for (Dog parent : parents) {
            if (parent.getName().equals(name)) {
                result.add(parent);
            }
        }
        return result;
    }
    public List<Dog> getDogParentsByAgeStream(int age) {
        return parents.stream().filter(dog -> Objects.equals(dog.getAge(), age)).toList();
    }
    public List<Dog> getDogParentsByAge(int age) {
        List<Dog> result = new ArrayList<>();
        for (Dog parent : parents) {
            if (parent.getAge() == age) {
                result.add(parent);
            }
        }
        return result;
    }

    /**
     * voice is override method which print line that dog howls and barks
     */
    @Override
    public void voice() {
        super.voice();
        System.out.print(name);
        System.out.println(" barks");
    }

    public static void main(String... strings) {
        Dog animal1 = new Dog.Builder()
                .withName("Virginia")
                .withSex("Female")
                .withAge(6)
                .withColor("grey")
                .isMongrel(false)
                .build();
        System.out.println(animal1);
        animal1.changeMongrel(true);
        System.out.println(animal1);
        animal1.eat("apple");
        animal1.run();
        animal1.setName("Laura");
        animal1.voice();
    }
}
