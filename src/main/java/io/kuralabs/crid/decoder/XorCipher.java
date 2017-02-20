package io.kuralabs.crid.decoder;

/**
 * Created by KuraLabs S.R.L on 2/19/17.
 */

public class XorCipher {

    public static byte[] applyXor(byte[] key, byte[] input) {
        byte[] output = new byte[input.length];

        for(int msg_idx = 0, key_idx = 0;
                msg_idx < input.length;
                msg_idx++, key_idx++
            ) {

            if(key_idx >= key.length) {
                key_idx = 0;
            }
            output[msg_idx] = (byte) (key[key_idx] ^ input[msg_idx]);
        }

        return output;
    }


    public static byte[] encrypt(byte[] key, byte[] message) {
        byte[] ciphertext = XorCipher.applyXor(key, message);
        return ciphertext;
    }

    public static byte[] decrypt(byte[] key, byte[] ciphertext) {
        byte[] message = XorCipher.applyXor(key, ciphertext);
        return message;
    }
}
