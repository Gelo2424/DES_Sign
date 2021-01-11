package module;

import GUI.DialogBox;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.math.BigInteger;
import java.security.MessageDigest;

public class DSA
{
    Random random = new Random();
    byte[] plainText;
    BigInteger[] sign;

    BigInteger p,q,g; // PUBLIC KEYS
    BigInteger x; // PRIVATE KEY
    BigInteger y; // PUBLIC KEY

    BigInteger k,r,s,w,u1,u2,v,pm1,km1;
    MessageDigest digest;

    public void generateKey() throws NoSuchAlgorithmException {
        // p,q,g - PUBLIC KEYS
        //keyLen (512-1024 / multiple of 64)
        //int keyLen = 512 + (random.nextInt(10)- 1) * 64;
        int keyLen = 512;
        q = BigInteger.probablePrime(160,new Random());
        BigInteger pom1, pom2;

        do {
            pom1 = BigInteger.probablePrime(keyLen,new Random());
            pom2 = pom1.subtract(BigInteger.ONE);
            pom1 = pom1.subtract(pom2.remainder(q));
        } while (!pom1.isProbablePrime(2));

        p = pom1;
        pm1 = p.subtract(BigInteger.ONE);


        BigInteger h = new BigInteger(keyLen-2,random);
        while(true) {
            if (h.modPow(pm1.divide(q), p).compareTo(BigInteger.ONE) > 0) {
                break;
            } else {
                h = new BigInteger(keyLen-2,random);
            }
        }

        g = h.modPow(pm1.divide(q),p);
        do {
            x = new BigInteger(160-2,random);
        } while (x.compareTo(BigInteger.ZERO) != 1);
        y = g.modPow(x,p);
        //HASH FUNCTION
        digest = MessageDigest.getInstance("SHA-256");
    }


    public BigInteger[] sign(byte[] tekst) {
        // random K, less than q
        k = new BigInteger(160-2,random);
        r = g.modPow(k, p).mod(q);
        km1 = k.modInverse(q);

        digest.update(tekst);
        BigInteger hash = new BigInteger(1, digest.digest());
        BigInteger pom = hash.add(x.multiply(r));
        s = km1.multiply(pom).mod(q);
        // SIGNATURE
        BigInteger signature[] = new BigInteger[2];
        signature[0] = r;
        signature[1] = s;
        return signature;
    }

    public boolean verifyBigInt(byte[] tekstJawny, BigInteger[] podpis)
    {
        digest.update(tekstJawny);
        BigInteger hash = new BigInteger(1, digest.digest());
        w = podpis[1].modInverse(q);
        u1 = hash.multiply(w).mod(q);
        u2 = podpis[0].multiply(w).mod(q);
        v = g.modPow(u1, p).multiply(y.modPow(u2, p)).mod(p).mod(q);
        if(v.compareTo(podpis[0]) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String bytesToHex(byte bytes[])
    {
        byte rawData[] = bytes;
        StringBuilder hexText = new StringBuilder();
        String initialHex = null;
        int initHexLength = 0;

        for (int i = 0; i < rawData.length; i++)
        {
            int positiveValue = rawData[i] & 0x000000FF;
            initialHex = Integer.toHexString(positiveValue);
            initHexLength = initialHex.length();
            while (initHexLength++ < 2)
            {
                hexText.append("0");
            }
            hexText.append(initialHex);
        }
        return hexText.toString();
    }

    public static byte[] hexToBytes(String tekst)
    {
        if (tekst == null) {
            return null;
        } else if (tekst.length() < 2) {
            return null;
        } else {
            if (tekst.length() % 2 != 0) tekst += '0';
            int dl = tekst.length() / 2;
            byte[] wynik = new byte[dl];
            for (int i = 0; i < dl; i++) {
                try {
                    wynik[i] = (byte) Integer.parseInt(tekst.substring(i * 2, i * 2 + 2), 16);
                } catch (NumberFormatException e) {
                    DialogBox.dialogAboutError("Cant convert Hex to Byte");
                }
                return wynik;
            }
        }
        return null;
    }

    public BigInteger[] getSign() {
        return sign;
    }

    public void setSign(BigInteger[] sign) {
        this.sign = sign;
    }

    public byte[] getPlainText() {
        return plainText;
    }

    public void setPlainText(byte[] plainText) {
        this.plainText = plainText;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getG() {
        return g;
    }

    public void setG(BigInteger g) {
        this.g = g;
    }

    public BigInteger getX() {
        return x;
    }

    public void setX(BigInteger x) {
        this.x = x;
    }

    public BigInteger getY() {
        return y;
    }

    public void setY(BigInteger y) {
        this.y = y;
    }

    public MessageDigest getDigest() {
        return digest;
    }

    public void setDigest(MessageDigest digest) {
        this.digest = digest;
    }
}