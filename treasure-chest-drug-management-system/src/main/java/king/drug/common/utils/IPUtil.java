package king.drug.common.utils;


import king.drug.common.utils.http.EscapeUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * 有关IP操作的工具类
 * Updated by SunYuelei on 2019/08/30 增加IP地址格式校验方法
 * Updated by wangxiaojun on 2020/12/23 增加获取http请求ip等方法
 */
public class IPUtil {
    private IPUtil() {
    }

    private static final String IPV4_BASIC_PATTERN_STRING =
            "(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}" + // initial first field, 1-255
                    "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}" + // following 2 fields, 0-255 followed by .
                    "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])"; // final field, 0-255

    /**
     * IP地址格式
     */
    private static final Pattern IPV4_PATTERN = Pattern.compile("^" + IPV4_BASIC_PATTERN_STRING + "$");

    /**
     * IPv4映射IPv6地址
     */
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:" + IPV4_BASIC_PATTERN_STRING + "$");

    /**
     * IPv4兼容IPv6地址
     */
    private static final Pattern IPV4_COMPATIPLE_IPV6_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){1,7}" + IPV4_BASIC_PATTERN_STRING + "$");

    /**
     * IPV6地址首选格式
     * IPv6的128位地址被分成8段，每16位为一段，每段被转换成为一个4位十六进制数，并用冒号隔开，
     * 这种表示方法叫“冒号十六进制表示法”，格式如下：
     * x:x:x:x:x:x:x:x
     */
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");

    /**
     * IPV6地址压缩格式
     * 当一个或多个连续的段内各位全为0时，为了缩短地址长度，用::（双冒号）表示。
     * 但一个IPv6地址中只允许用一次。例如：
     * 2001:DB8:0:0:8:800:200C:417A 以压缩为： 2001:DB8::8:800:200C:417A
     */
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN =
            Pattern.compile(
                    "^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)" + // 0-6 hex fields
                            "::" +
                            "(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$"); // 0-6 hex fields

    /**
     * The above pattern is not totally rigorous as it allows for more than 7 hex fields in total
     */
    private static final char COLON_CHAR = ':';

    /**
     * Must not have more than 7 colons (i.e. 8 fields)
     */
    private static final int MAX_COLON_COUNT = 7;

    /**
     * 获取本地IP地址
     *
     * @return
     */
    public static String getServerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    /**
     * 检查一个IP地址是否为IPv4地址
     *
     * @param input
     * @return
     */
    public static boolean isIpv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    /**
     * 检查一个IP地址是否为IPv4映射IPv6地址
     *
     * @param input
     * @return
     */
    public static boolean isIpv4MappedIpv64Address(final String input) {
        return IPV4_MAPPED_IPV6_PATTERN.matcher(input).matches();
    }

    /**
     * 检查一个IP地址是否为IPv4兼容IPv6地址
     *
     * @param input
     * @return
     */
    public static boolean isIpv4CompatibleIpv64Address(final String input) {
        return IPV4_COMPATIPLE_IPV6_PATTERN.matcher(input).matches();
    }

    /**
     * 检查一个IP地址是否为IPv6首选地址
     *
     * @param input
     * @return
     */
    public static boolean isIpv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    /**
     * 检查一个IP地址是否为IPv6压缩地址
     *
     * @param input
     * @return
     */
    public static boolean isIpv6HexCompressedAddress(final String input) {
        int colonCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == COLON_CHAR) {
                colonCount++;
            }
        }
        return colonCount <= MAX_COLON_COUNT && IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    /**
     * 检查一个IP地址是否为IPv6地址(包括压缩地址、内嵌IPV4的IPV6地址)
     *
     * @param input
     * @return
     */
    public static boolean isIpv6Address(final String input) {
        return isIpv6StdAddress(input)
                || isIpv6HexCompressedAddress(input)
                || isIpv4MappedIpv64Address(input)
                || isIpv4CompatibleIpv64Address(input);
    }

    /**
     * 检查一个IP地址是否为有效的IPv4或IPv6地址(包括压缩地址、内嵌IPV4的IPV6地址)
     *
     * @return
     */
    public static boolean isIpAddress(String ipAddress) {
        return isIpv4Address(ipAddress) || isIpv6Address(ipAddress);
    }

    /**
     * 获取http请求地址
     *
     * @return String http请求地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : EscapeUtil.clean(ip);
    }

    /**
     * 判断是否是内网地址
     *
     * @return boolean
     */
    public static boolean internalIp(String ip) {
        byte[] addr = textToNumericFormatV4(ip);
        if (null == addr) {
        	return true;
		}
        return internalIp(addr) || "127.0.0.1".equals(ip);
    }

    private static boolean internalIp(byte[] addr) {
        if (StringUtil.isNull(addr) || addr.length < 2) {
            return true;
        }
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                    default:
                    	return false;
                }
            default:
                return false;
        }
    }

    /**
     * 将IPv4地址转换成字节
     *
     * @param text IPv4地址
     * @return byte 字节
     */
    public static byte[] textToNumericFormatV4(String text) {
        if (text.length() == 0) {
            return null;
        }

        byte[] bytes = new byte[4];
        String[] elements = text.split("\\.", -1);
        try {
            long l;
            int i;
            switch (elements.length) {
                case 1:
                    l = Long.parseLong(elements[0]);
                    if ((l < 0L) || (l > 4294967295L)) {
                        return null;
                    }
                    bytes[0] = (byte) (int) (l >> 24 & 0xFF);
                    bytes[1] = (byte) (int) ((l & 0xFFFFFF) >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);
                    if ((l < 0L) || (l > 255L)) {
                        return null;
                    }
                    bytes[0] = (byte) (int) (l & 0xFF);
                    l = Integer.parseInt(elements[1]);
                    if ((l < 0L) || (l > 16777215L)) {
                        return null;
                    }
                    bytes[1] = (byte) (int) (l >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 3:
                    for (i = 0; i < 2; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L)) {
                            return null;
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    l = Integer.parseInt(elements[2]);
                    if ((l < 0L) || (l > 65535L)) {
                        return null;
                    }
                    bytes[2] = (byte) (int) (l >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 4:
                    for (i = 0; i < 4; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L)) {
                            return null;
                        }
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    break;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return bytes;
    }
}
