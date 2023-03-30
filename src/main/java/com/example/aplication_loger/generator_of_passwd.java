package com.example.aplication_loger;
import java.security.*;

public class generator_of_passwd{

    private byte [] passwd;

    public void generate(String passwords) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwords.getBytes());
        byte[] digest = md.digest();

        System.out.println(digest);
        }

    public byte[] getPasswd() {
        return passwd;
    }

    public void setPasswd(byte[] passwd) {
        this.passwd = passwd;
    }
}
