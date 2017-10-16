package io.kuralabs.crid.decoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.kuralabs.crid.decoder.utils.StringUtils;

/**
 * Created by KuraLabs S.R.L on 2/19/17.
 */

public class IdParser {

    private static class Field {
        public int begin;
        public int end;

        public Field(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    private static final Field id = new Field(0, 9);
    private static final Field familyName1 = new Field(9, 35);
    private static final Field familyName2 = new Field(35, 61);
    private static final Field name = new Field(61, 91);
    private static final Field gender = new Field(91, 92);
    private static final Field birthDate = new Field(92, 100);
    private static final Field expirationDate = new Field(100, 108);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static Person parse(String decoded) throws ParseException {

        if (decoded == null || decoded.length() < expirationDate.end) {
            throw new ParseException(
                "Input of incorrect size",
                expirationDate.end
            );
        }

        String id = decoded.substring(
            IdParser.id.begin,
            IdParser.id.end
        ).trim();

        String familyName1 = StringUtils.capitalize(
            decoded.substring(
                IdParser.familyName1.begin,
                IdParser.familyName1.end
            ).trim()
        );

        String familyName2 = StringUtils.capitalize(
            decoded.substring(
                IdParser.familyName2.begin,
                IdParser.familyName2.end
            ).trim()
        );

        String name = StringUtils.capitalize(
            decoded.substring(
                IdParser.name.begin,
                IdParser.name.end
            ).trim()
        );

        String gender = decoded.substring(
            IdParser.gender.begin,
            IdParser.gender.end
        ).trim().toUpperCase();

        Date birthDate = dateFormat.parse(decoded.substring(
            IdParser.birthDate.begin,
            IdParser.birthDate.end
        ));

        Date expirationDate = dateFormat.parse(decoded.substring(
            IdParser.expirationDate.begin,
            IdParser.expirationDate.end
        ));

        return new Person(
            id, familyName1, familyName2, name, gender,
            birthDate, expirationDate
        );
    }
}
