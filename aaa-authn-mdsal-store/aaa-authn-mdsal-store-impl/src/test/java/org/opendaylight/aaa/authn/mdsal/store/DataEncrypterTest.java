package org.opendaylight.aaa.authn.mdsal.store;

import static org.junit.Assert.*;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class DataEncrypterTest {

    @Test
    public void testEncrypt() {
        DataEncrypter dataEncry = new DataEncrypter("foo_key_test");
        String token = "foo_token_test";
        String eToken = dataEncry.encrypt(token);
        //check for decryption result
        String returnToken = dataEncry.decrypt(eToken);
        String tokenBase64 = DatatypeConverter.printBase64Binary(token.getBytes());
        assertEquals(tokenBase64, returnToken);
    }

    @Test
    public void testDecrypt() {
        DataEncrypter dataEncry = new DataEncrypter("foo_key_test");
        String eToken = "foo_etoken_test";
        assertEquals(dataEncry.decrypt(""), null);
        //check for encryption Tag
        assertEquals(eToken, dataEncry.decrypt(eToken));
    }

}