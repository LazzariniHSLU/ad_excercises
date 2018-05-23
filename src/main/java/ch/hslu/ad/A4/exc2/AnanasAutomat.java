package ch.hslu.ad.A4.exc2;

public class AnanasAutomat {
    public static int stateSearch(final String a) {
        State state = State.Z0;
        int index =0;
        final char[] word = a.toCharArray();
        for(char bit: word) {
            switch (state) {
                case Z0:
                    if (bit == 'A'){
                        state = State.Z1;
                    }
                    break;
                case Z1:
                    if(bit == 'N'){
                        state = State.Z2;
                    }
                    else if(bit == 'A'){
                        state = State.Z1;
                    }
                    else{
                        state = State.Z0;
                    }
                    break;
                case Z2:
                    if(bit == 'A'){
                        state = State.Z3;
                    }
                    else{
                        state = State.Z0;
                    }
                    break;
                case Z3:
                    if(bit == 'N'){
                        state = State.Z4;
                    }
                    else if(bit == 'A'){
                        state = State.Z1;
                    }
                    else{
                        state = State.Z0;
                    }
                    break;
                case Z4:
                    if(bit == 'A'){
                        state = State.Z5;
                    }
                    else{
                        state = State.Z0;
                    }
                    break;
                case Z5:
                    if(bit == 'S'){
                        state = State.Z6;
                    }
                    else if(bit == 'N'){
                        state = State.Z4;
                    }
                    else{ //A
                        state = State.Z1;
                    }
                    break;
                case Z6:
                    return index - "ANANAS".length(); // position of pattern start
            }
            index++;
        }
        return -1;
    }
}
