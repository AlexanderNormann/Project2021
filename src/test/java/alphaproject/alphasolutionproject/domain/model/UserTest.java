package alphaproject.alphasolutionproject.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//alle tests er lavet af Jonathan
class UserTest {
    private User user;

    //AAA Arange, act, assert
    @Test
    public void setAuthorityTest(){
      user = new User(); //Arange
      user.setAuthority(true); //act
      assertEquals(true, user.getAuthority()); //Assert

    }

    @Test
    public void getAuthorityTest(){
      user = new User();
      user.setAuthority(true);
      boolean hasAuthority = user.getAuthority();
      assertEquals(true, hasAuthority);
    }

    @Test
    public void setEmail(){
      user = new User();
      String Email = "jona.nielsen@hotmail.com";
      user.setEmail(Email);
      assertEquals(Email, user.getEmail());
    }

    @Test
    public void setFirstnameTest(){
      user = new User();
      String Firstname = "J-boy";
      user.setFirstName(Firstname);
      assertEquals(Firstname, user.getFirstName());
    }
  }
