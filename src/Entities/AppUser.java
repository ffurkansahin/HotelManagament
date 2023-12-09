package Entities;

public class AppUser {

    private String Username;
    private String Password;
    private String Name;
    private String Surname;

    public AppUser( String username, String password, String name, String surname) {
        Username = username;
        Password = password;
        Name = name;
        Surname = surname;
    }

    public AppUser(String username, String password) {
        this( username, password, "def", "def");
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
