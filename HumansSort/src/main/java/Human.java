class Human implements Comparable{

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        Human compHuman = (Human) o;
        int age2 =  compHuman.getAge();
        if (age < age2){
            return -1;
        }else if (age == age2) {
            return 0;
        }else return 1;
    }
}