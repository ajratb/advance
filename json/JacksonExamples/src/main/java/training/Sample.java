package training;

public class Sample {

    String[] accessGroups;
    String[] toGroups;
    String[] exceptGroups;

    public Sample() {
    }

    public Sample(String[] accessGroups, String[] toGroups, String[] exceptGroups) {
        this.accessGroups = accessGroups;
        this.toGroups = toGroups;
        this.exceptGroups = exceptGroups;
    }

    public String[] getAccessGroups() {
        return accessGroups;
    }

    public void setAccessGroups(String[] accessGroups) {
        this.accessGroups = accessGroups;
    }

    public String[] getToGroups() {
        return toGroups;
    }

    public void setToGroups(String[] toGroups) {
        this.toGroups = toGroups;
    }

    public String[] getExceptGroups() {
        return exceptGroups;
    }

    public void setExceptGroups(String[] exceptGroups) {
        this.exceptGroups = exceptGroups;
    }
}
