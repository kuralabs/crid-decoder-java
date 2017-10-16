package io.kuralabs.crid.decoder.utils;

/**
 * Created by KuraLabs S.R.L on 2/19/17.
 */

public class StringUtils {

    public static String join(String[] parts, String separator) {

        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            if (sb.length() > 0) {
                sb.append(separator);
            }
            sb.append(part);
        }

        return sb.toString();
    }

    public static String capitalize(String text) {

        String[] words = text.split(" ");
        String[] capitalizedWords = new String[words.length];

        for(int wordIdx = 0; wordIdx < words.length; wordIdx++) {
            String word = words[wordIdx];

            if(word.length() == 0) {
                capitalizedWords[wordIdx] = "";
                continue;
            }

            capitalizedWords[wordIdx] =
                word.toUpperCase().charAt(0) +
                word.substring(1).toLowerCase();
        }

        return StringUtils.join(capitalizedWords, " ");

    }
}
