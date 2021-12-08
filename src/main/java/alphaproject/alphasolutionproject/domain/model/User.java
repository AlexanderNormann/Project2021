package alphaproject.alphasolutionproject.domain.model;

public class User {
private String firstName;
private String lastName;
private String email;
private String password;
private int userId;
private boolean authority;


  public User() {
  }




  public User(String firstName, String lastName, String email, String password, boolean authority) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.authority = authority;
  }

  public User(String email, String password, int id) {
    this.email = email;
    this.password = password;
    this.userId = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public boolean getAuthority() {
    return authority;
  }

  public void setAuthority(boolean authority) {
    this.authority = authority;
  }
}
