package alphaproject.alphasolutionproject.repositories;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

    @Test
    public void testDBManagerConnection(){
        Connection connection = DBManager.getConnection();
        assertNotNull(connection);
    }
}