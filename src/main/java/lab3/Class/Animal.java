package lab3.Class;

/**
 * class Animal for Lab1 subject Java programming technologies
 * <p>
 * @author hrrcnnmdlr
 * @version 2.0.0
 */
public class Animal{
    /**
     * Internal attribute: name is name of animal
     * <p>
     * Internal attribute: sex is sex of animal
     * <p>
     * Internal attribute: age is age of animal
     * <p>
     * Internal attribute: parents is parents of animal
     */
    protected String name;
    protected String sex;
    protected int age;
    /**
     * Getter method
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter method
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Getter method
     * @return age
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\nAnimal: \n"
                + "    Name: " + name + '\n'
                + "    Sex: " + sex + '\n'
                + "    Age: " + age + " y.o\n";
    }
    /**
     * equals is override method for class Object
     * <p>
     * @param o is object that is compared to the current object
     * @return true if animals is equals or false if animals isn't equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;

        Animal animal = (Animal) o;

        if (getAge() != animal.getAge()) {
            return false;
        } else if (!getSex().equals(animal.getSex())) {
            return false;
        } else return getName().equals(animal.getName());
    }
    /**
     * hashCode is override method for class Object
     * <p>
     * @return hashCode that is defined from length of name multiply by age
     */
    @Override
    public int hashCode() {
        return name.length() * age;
    }
    public static class Builder {
        private final Animal newAnimal;

        public Builder() {
            newAnimal = new Animal();
        }

        public Builder withName(String name){
            newAnimal.name = name;
            return this;
        }
        public Builder withSex(String sex){
            newAnimal.sex = sex;
            return this;
        }
        public Builder withAge(int age){
            newAnimal.age = age;
            return this;
        }
        public Animal build(){
            return newAnimal;
        }
    }
    /**
     * Setter method
     * @param name is name of animal
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
     * @param sex is sex of animal
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     * eat is method which print line that animal eat food
     * @param food is food which animal eat
     */
    public void eat(String food) {
        System.out.print(name);
        System.out.print(" eats ");
        System.out.println(food);
    }
    /**
     * sleep is method which print line that animal sleep
     */
    public void sleep() {
        System.out.print(name);
        System.out.println(" sleeps");
    }
    /**
     * run is method which print line that animal runs
     */
    public void run() {
        System.out.print(name);
        System.out.println(" runs");
    }

    public static void main(String... strings) {
        Animal animal1 = new Animal.Builder()
                .withName("Donald")
                .withSex("Male")
                .withAge(6)
                .build();
        Animal animal2 = new Animal.Builder()
                .withName("Donald")
                .withSex("Male")
                .withAge(6)
                .build();
        Animal animal3 = new Animal.Builder()
                .withName("Virginia")
                .withSex("Female")
                .withAge(2)
                .build();
        System.out.println("Is animal2 equals animal1? " + animal1.equals(animal2));
        System.out.println(animal1);
        System.out.println(animal2);
        animal2.addAge();
        System.out.println("Is animal2 equals animal1? " + animal1.equals(animal2));
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println("Is animal3 equals animal1? " + animal1.equals(animal3));
        System.out.println(animal1);
        System.out.println(animal3);
        animal3.setSex("Male");
        System.out.println(animal3);
        animal1.eat("apple");
        animal2.run();
        animal2.setName("Mario");
        animal2.eat("apple");
        animal3.sleep();
    }
}


