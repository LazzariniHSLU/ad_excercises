package ch.hslu.ad.A3;

public class DEA {

    public static boolean isWordLanguage(final String string) {
        final char[] word = string.toCharArray();
        State state = State.Z0;
        for (char bit : word) {
            switch (state) {
                case Z0:
                    if (bit == '0') {
                        state = State.Z1;
                    } else {
                        return false;
                    }
                    break;
                case Z1:
                    if (bit == '1') {
                        state = State.Z2;
                    } else {
                        return false;
                    }
                    break;
                case Z2:
                    if (bit == '0') {
                        state = State.Z4;
                    } else if (bit == '1') {
                        state = State.Z3;
                    } else {
                        return false;
                    }
                    break;
                case Z3:
                    if (bit == '1') {
                        state = State.Z2;
                    } else {
                        return false;
                    }
                    break;
                case Z4:
                    if (bit == '1')
                    {
                        state = State.Z2;
                    }
                    else {
                        return false;
                    }
                        break;
                default:
                    return false;
            }
        }
        if(state == State.Z1 || state == State.Z4){
            return true;
        }
        else {
            return false;
        }
    }
}
