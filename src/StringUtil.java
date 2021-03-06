import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class StringUtil {

    public static String applySHA256(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hashString = new StringBuffer();
            for(int i=0; i<hash.length;i++) {
                String hexString = Integer.toHexString(0xff & hash[i]);
                if(hexString.length() == 1) hashString.append('0');
                hashString.append(hexString);
            }
            return hashString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }


    }

    //Returns the difficulty
    public static String getDificultyString(int difficulty) {
        return new String(new char[difficulty]).replace('\0', '0');
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

}
