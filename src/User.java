public abstract class User {
    protected String name;
    protected int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public abstract void displayRole();
}