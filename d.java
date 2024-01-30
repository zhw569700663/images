//
// Decompiled by Jadx - 867ms
//
package com.jd.phc;

import java.io.ByteArrayOutputStream;

public class d {
    private static char[] a = {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = new byte[128];

    public d() {
        try {
            c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] a(String str) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i <= bytes.length - 1; i++) {
            bArr[i] = b[bytes[i]];
        }
        int i2 = 0;
        while (true) {
            int i3 = length - 1;
            if (i2 > i3) {
                return byteArrayOutputStream.toByteArray();
            }
            byte[] bArr2 = new byte[3];
            int i4 = 0;
            for (int i5 = 0; i5 <= 2; i5++) {
                int i6 = i2 + i5;
                int i7 = i6 + 1;
                if (i7 <= i3 && bArr[i7] >= 0) {
                    bArr2[i5] = (byte) ((((bArr[i6] & 255) << ((i5 * 2) + 2)) & 255) | ((byte) ((bArr[i7] & 255) >>> (((2 - (i5 + 1)) * 2) + 2))));
                    i4++;
                }
            }
            for (int i8 = 0; i8 <= i4 - 1; i8++) {
                byteArrayOutputStream.write(bArr2[i8]);
            }
            i2 += 4;
        }
    }

    public static String b(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= bArr.length - 1; i += 3) {
            byte[] bArr2 = new byte[4];
            byte b2 = 0;
            for (int i2 = 0; i2 <= 2; i2++) {
                int i3 = i + i2;
                if (i3 <= bArr.length - 1) {
                    bArr2[i2] = (byte) (b2 | ((bArr[i3] & 255) >>> ((i2 * 2) + 2)));
                    b2 = (byte) ((((bArr[i3] & 255) << (((2 - i2) * 2) + 2)) & 255) >>> 2);
                } else {
                    bArr2[i2] = b2;
                    b2 = 64;
                }
            }
            bArr2[3] = b2;
            for (int i4 = 0; i4 <= 3; i4++) {
                if (bArr2[i4] <= 63) {
                    sb.append(a[bArr2[i4]]);
                } else {
                    sb.append('=');
                }
            }
        }
        return sb.toString();
    }

    public static void c() throws Exception {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = b;
            if (i2 > bArr.length - 1) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            char[] cArr = a;
            if (i > cArr.length - 1) {
                return;
            }
            b[cArr[i]] = (byte) i;
            i++;
        }
    }
}
