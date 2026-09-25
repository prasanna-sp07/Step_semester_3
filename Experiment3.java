final class Experiment3 {
    private final String firstName;
    private final String lastNameInitial;

    public Experiment3(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = parts[1].substring(0, 1);
    }

    public String getNickname() {
        return this.firstName + " " + this.lastNameInitial + ".";
    }

    public static void main(String[] args) {
        Experiment3 tag = new Experiment3("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}