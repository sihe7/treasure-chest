package king.drug.common.utils;

/**
 * <ul>
 *     <li>Copyright (C) 2015 The MobileSecurePay Project</li>
 *     <li>Base64加解密工具类</li>
 *     <li>Encodes hex octects into Base64</li>
 *     <li>Decodes Base64 data into octects</li>
 * </ul>
 * <p>
 *   Objective-C
 *   使用第三方库，主要有GTMBase64；NSString+Base64,NSData+Base64 二种主流库，选择google的GTMBase64来加解密
 * </p>
 */
public final class Base64 {
    private Base64() {
        throw new IllegalAccessError("Base64 class");
    }

    static private final int     BASELENGTH           = 128;
    static private final int     LOOKUPLENGTH         = 64;
    static private final int     TWENTYFOURBITGROUP   = 24;
    static private final int     EIGHTBIT             = 8;
    static private final int     SIXTEENBIT           = 16;
    static private final int     FOURBYTE             = 4;
    static private final int     SIGN                 = -128;
    static private final char    PAD                  = '=';
    static final private byte[]  BASE64ALPHABET       = new byte[BASELENGTH];
    static final private char[]  LOOKUPBASE64ALPHABET = new char[LOOKUPLENGTH];

    static {
        for (int i = 0; i < BASELENGTH; ++i) {
            BASE64ALPHABET[i] = -1;
        }
        for (int i = 'Z'; i >= 'A'; i--) {
            BASE64ALPHABET[i] = (byte) (i - 'A');
        }
        for (int i = 'z'; i >= 'a'; i--) {
            BASE64ALPHABET[i] = (byte) (i - 'a' + 26);
        }

        for (int i = '9'; i >= '0'; i--) {
            BASE64ALPHABET[i] = (byte) (i - '0' + 52);
        }

        BASE64ALPHABET['+'] = 62;
        BASE64ALPHABET['/'] = 63;

        for (int i = 0; i <= 25; i++) {
            LOOKUPBASE64ALPHABET[i] = (char) ('A' + i);
        }

        for (int i = 26, j = 0; i <= 51; i++, j++) {
            LOOKUPBASE64ALPHABET[i] = (char) ('a' + j);
        }

        for (int i = 52, j = 0; i <= 61; i++, j++) {
            LOOKUPBASE64ALPHABET[i] = (char) ('0' + j);
        }
        LOOKUPBASE64ALPHABET[62] = (char) '+';
        LOOKUPBASE64ALPHABET[63] = (char) '/';

    }

    private static boolean isWhiteSpace(char octect) {
        return octect == 0x20 || octect == 0xd || octect == 0xa || octect == 0x9;
    }

    private static boolean isPad(char octect) {
        return octect == PAD;
    }

    private static boolean isData(char octect) {
        return octect < BASELENGTH && BASE64ALPHABET[octect] != -1;
    }

    /**
     * Encodes hex octects into Base64
     *
     * @param binaryData Array containing binaryData
     * @return Encoded Base64 array
     */
    public static String encode(byte[] binaryData) {

        if (binaryData == null) {
            return null;
        }

        int lengthDataBits = binaryData.length * EIGHTBIT;
        if (lengthDataBits == 0) {
            return "";
        }

        int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
        int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
        int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1 : numberTriplets;
        char encodedData[];

        encodedData = new char[numberQuartet * 4];

        byte k , l , b1 , b2 , b3 ;

        int encodedIndex = 0;
        int dataIndex = 0;


        for (int i = 0; i < numberTriplets; i++) {
            b1 = binaryData[dataIndex++];
            b2 = binaryData[dataIndex++];
            b3 = binaryData[dataIndex++];



            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);
            byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6) : (byte) ((b3) >> 6 ^ 0xfc);



            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[val1];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[val2&0xff | (k << 4)];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[(l << 2) | val3&0xff];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[b3 & 0x3f];
        }

        // form integral number of 6-bit groups
        getData(binaryData, fewerThan24bits, encodedData, encodedIndex, dataIndex);

        return new String(encodedData);
    }

    private static void getData(byte[] binaryData, int fewerThan24bits, char[] encodedData, int encodedIndex, int dataIndex) {
        byte b1;
        byte k;
        byte b2;
        byte l;
        if (fewerThan24bits == EIGHTBIT) {
            b1 = binaryData[dataIndex];
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[val1];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[k << 4];
            encodedData[encodedIndex++] = PAD;
            encodedData[encodedIndex] = PAD;
        } else if (fewerThan24bits == SIXTEENBIT) {
            b1 = binaryData[dataIndex];
            b2 = binaryData[dataIndex + 1];
            l = (byte) (b2 & 0x0f);
            k = (byte) (b1 & 0x03);

            byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2) : (byte) ((b1) >> 2 ^ 0xc0);
            byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4) : (byte) ((b2) >> 4 ^ 0xf0);

            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[val1];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[val2&0xff | (k << 4)];
            encodedData[encodedIndex++] = LOOKUPBASE64ALPHABET[l << 2];
            encodedData[encodedIndex] = PAD;
        }
    }

    /**
     * Decodes Base64 data into octects
     *
     * @param encoded string containing Base64 data
     * @return Array containind decoded data.
     */
    public static byte[] decode(String encoded) {

        if (encoded == null) {
            return null;
        }

        char[] base64Data = encoded.toCharArray();
        // remove white spaces
        int len = removeWhiteSpace(base64Data);

        if (len % FOURBYTE != 0) {
            return null;//should be divisible by four
        }

        int numberQuadruple = len / FOURBYTE;

        if (numberQuadruple == 0) {
            return new byte[0];
        }

        byte decodedData[] ;
        byte b1 , b2 ;
        char d1 , d2 , d3 , d4 ;

        int i = 0;
        int encodedIndex = 0;
        int dataIndex = 0;
        decodedData = new byte[(numberQuadruple) * 3];

        Data data = new Data(base64Data, numberQuadruple, decodedData, i, encodedIndex, dataIndex).invoke();
        if (data.is()) {
            return null;
        }
        dataIndex = data.getDataIndex();
        i = data.getI();
        encodedIndex = data.getEncodedIndex();
        d1 = base64Data[dataIndex++];
            d2 = base64Data[dataIndex++];
            if (!isData(d1) || !isData(d2)) {
                return null;//if found "no data" just return null
            }

            b1 = BASE64ALPHABET[d1];
            b2 = BASE64ALPHABET[d2];

            d3 = base64Data[dataIndex++];
            d4 = base64Data[dataIndex];
        byte[] encodedIndex1 = getEncodedIndex(decodedData, b1, b2, d3, d4, i, encodedIndex);
        if (encodedIndex1 != null) {
            return encodedIndex1;
        }

        return decodedData;
        }

    private static byte[] getEncodedIndex(byte[] decodedData, byte b1, byte b2, char d3, char d4, int i, int encodedIndex) {
        byte b3;
        byte b4;
        if (!isData(d3) || !isData(d4)) {
            return getBytes(decodedData, b1, b2, d3, d4, i, encodedIndex);

        } else { //No PAD e.g 3cQl
            b3 = BASE64ALPHABET[d3];
            b4 = BASE64ALPHABET[d4];
            decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
            decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
            decodedData[encodedIndex] = (byte) (b3 << 6 | b4 & 0xff);

        }
        return null;
    }

    private static byte[] getBytes(byte[] decodedData, byte b1, byte b2, char d3, char d4, int i, int encodedIndex) {
        byte b3;//Check if they are PAD characters
        if (isPad(d3) && isPad(d4)) {
            if ((b2 & 0xf) != 0)//last 4 bits should be zero
            {
                return null;
            }
            byte[] tmp = new byte[i * 3 + 1];
            System.arraycopy(decodedData, 0, tmp, 0, i * 3);
            tmp[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
            return tmp;
        } else if (!isPad(d3) && isPad(d4)) {
            b3 = BASE64ALPHABET[d3];
            if ((b3 & 0x3) != 0)//last 2 bits should be zero
            {
                return null;
            }
            byte[] tmp = new byte[i * 3 + 2];
            System.arraycopy(decodedData, 0, tmp, 0, i * 3);
            tmp[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
            tmp[encodedIndex] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
            return tmp;
        } else {
            return null;
        }
    }

    /**
     * remove WhiteSpace from MIME containing encoded Base64 data.
     *
     * @param data  the byte array of base64 data (with WS)
     * @return      the new length
     */
    private static int removeWhiteSpace(char[] data) {
        if (data == null) {
            return 0;
        }

        // count characters that's not whitespace
        int newSize = 0;
        int len = data.length;
        for (int i = 0; i < len; i++) {
            if (!isWhiteSpace(data[i])) {
                data[newSize++] = data[i];
            }
        }
        return newSize;
    }


    private static class Data {
        private boolean myResult;
        private char[] base64Data;
        private int numberQuadruple;
        private byte[] decodedData;
        private int i;
        private int encodedIndex;
        private int dataIndex;

        public Data(char[] base64Data, int numberQuadruple, byte[] decodedData, int i, int encodedIndex, int dataIndex) {
            this.base64Data = base64Data;
            this.numberQuadruple = numberQuadruple;
            this.decodedData = decodedData;
            this.i = i;
            this.encodedIndex = encodedIndex;
            this.dataIndex = dataIndex;
        }

        boolean is() {
            return myResult;
        }

        public int getI() {
            return i;
        }

        public int getEncodedIndex() {
            return encodedIndex;
        }

        public int getDataIndex() {
            return dataIndex;
        }

        public Data invoke() {
            char d1;
            char d2;
            char d3;
            char d4;
            byte b1;
            byte b2;
            byte b3;
            byte b4;
            for (; i < numberQuadruple - 1; i++) {
                d1 = base64Data[dataIndex++];
                d2 = base64Data[dataIndex++];
                d3 = base64Data[dataIndex++];
                d4 = base64Data[dataIndex++];
                if (!isData(d1) || !isData(d2) || !isData(d3) || !isData(d4)) {
                    myResult = true;
                    return this;
                }//if found "no data" just return null

                b1 = BASE64ALPHABET[d1];
                b2 = BASE64ALPHABET[d2];
                b3 = BASE64ALPHABET[d3];
                b4 = BASE64ALPHABET[d4];

                decodedData[encodedIndex++] = (byte) (b1 << 2 | b2 >> 4);
                decodedData[encodedIndex++] = (byte) (((b2 & 0xf) << 4) | ((b3 >> 2) & 0xf));
                decodedData[encodedIndex++] = (byte) (b3 << 6 | b4 & 0xff);
            }
            myResult = false;
            return this;
        }
    }
}
