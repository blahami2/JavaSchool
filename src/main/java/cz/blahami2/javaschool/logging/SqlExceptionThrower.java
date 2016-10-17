/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.blahami2.javaschool.logging;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Michael Blaha {@literal <michael.blaha@gmail.com>}
 */
public class SqlExceptionThrower implements ExceptionThrower {

    @Override
    public void thrower() throws IOException {
        try {
            creator();
        } catch ( SQLException ex ) {
            throw new IOException( ex );
        }

    }

    private void creator() throws SQLException {
    //    throw new SQLException( "SQL exception" );
    }
}
