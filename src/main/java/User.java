public class User {
    private final String first;
    private final String last;
    private boolean admin;

    public User(String first, String last, boolean isAdmin) {
        this.first = first;
        this.last = last;
        admin = isAdmin;
    }

    public String getFullName() {
        return first + " " + last;
    }

    public boolean isAdmin() {
        return admin;
    }
}
