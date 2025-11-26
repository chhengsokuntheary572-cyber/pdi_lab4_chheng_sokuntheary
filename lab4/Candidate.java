package lab4;

public class Candidate {
    private String name;
    private String gender;
    private String group;
    private double math;
    private double physics;
    private double chemistry;

    public Candidate(String name, String gender, String group, double math, double physics, double chemistry) {
        this.name = name;
        this.gender = gender;
        this.group = group;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getGroup() { return group; }
    public double getMath() { return math; }
    public double getPhysics() { return physics; }
    public double getChemistry() { return chemistry; }

    public double getAverage() {
        return (math + physics + chemistry) / 3.0;
    }
}
