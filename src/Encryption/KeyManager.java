package Encryption;

import java.security.KeyPair;
import javax.crypto.SecretKey;

public class KeyManager {
    private SecretKey aesKey;
    private KeyPair rsaKeyPair;

    public KeyManager() throws Exception {
        this.aesKey = SymmetricEncryption.generateAESKey();
        this.rsaKeyPair = AsymmetricEncryption.generateRSAKeyPair();
    }

    public SecretKey getAesKey() {
        return aesKey;
    }

    public KeyPair getRsaKeyPair() {
        return rsaKeyPair;
    }
}

