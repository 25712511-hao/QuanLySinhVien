package Entity;

abstract class Person {
    private String name;
    private String id;
    private int birthYear;

    public Person(String name, String id, int birthYear) {
        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    abstract String getInfo();
}
