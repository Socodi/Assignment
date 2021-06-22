public class ReadJson {
    private int id;
    private String first_name, last_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString(){
        return "Emp{" +
                "id = " + id +
                " First name = " + first_name +
                " last name = " + last_name +
                "}";
    }
}