import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by xiaoxiao on 4/26/17.
 */
public class TinyURL_535 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(codec.decode("http://tinyurl.com/1625635731"));
    }

    static class Codec {
        HashMap<String, String> encodeMap = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String originalUrl = longUrl.split("//")[1];
            Random rd = new Random();
            String code = String.valueOf(rd.hashCode());
            encodeMap.put(code, originalUrl);
            return longUrl.split("//")[0]+"//tinyurl.com/" + code;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalUrl = encodeMap.get(shortUrl.split("tinyurl.com/")[1]);
            return shortUrl.split("tinyurl.com/")[0] + originalUrl;
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
