package com.example.encryption;

public class SecureRandom {
    public void nextBytes(byte[] bytes) {
        /*   bytes = new byte[]{32, 34, 55, 54, 23, 56, 86, 84, 75, 33, 85, 32, 42, 14, 65, 75};*/
        bytes[0] = 32;
        bytes[1] = 34;
        bytes[2] = 55;
        bytes[3] = 54;
        bytes[4] = 23;
        bytes[5] = 56;
        bytes[6] = 86;
        bytes[7] = 84;
        bytes[8] = 75;
        bytes[9] = 33;
        bytes[10] = 85;
        bytes[11] = 32;
        bytes[12] = 42;
        bytes[13] = 14;
        bytes[14] = 65;
        bytes[15] = 75;
        // bytes = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
