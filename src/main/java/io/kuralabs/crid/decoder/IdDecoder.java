package io.kuralabs.crid.decoder;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

/**
 * Created by KuraLabs S.R.L on 2/19/17.
 */

public class IdDecoder {

    private byte[] key;
    private String encoding = "ISO-8859-1";

    public IdDecoder(byte[] key) {
        this.key = key;
    }

    public IdDecoder(byte[] key, String encoding) {
        this.key = key;
        this.encoding = encoding;
    }

    public Person decode(byte[] encrypted) throws UnsupportedEncodingException, ParseException {
        byte[] decrypted = XorCipher.decrypt(this.key, encrypted);
        String decoded = new String(decrypted, this.encoding);
        return IdParser.parse(decoded);
    }
}
