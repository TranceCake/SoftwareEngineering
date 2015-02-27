import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GetalRij {
	private int[] getallen;
	
	public GetalRij( int aantal, int max ){
		// Belangrijke aanname: aantal < max, anders kunnen de getallen niet uniek zijn.
		getallen = new int[aantal];
		vulArrayMetUniekeWaarden( aantal, max );

	}

	private void vulArrayMetUniekeWaarden(int aantal, int max) {
		// Vul een hulplijst met getallen 0, ..., max
		ArrayList hulpLijst = new ArrayList( max );
		for ( int i=0; i<max; i++){
			hulpLijst.add( i );
		}
		
		// Stop 'aantal' random waarden in getallen
		Random r = new Random();
		for ( int i=0; i<aantal; i++){
			// Het omzetten van Integer naar int gaat sinds Java 1.5 automatisch (unboxing).
			int getal = (Integer) (hulpLijst.remove( r.nextInt( hulpLijst.size())));
			getallen[i] = getal;
		}
	}
	
	public boolean zitErinA( int zoekWaarde ){
        boolean exists = false;

        int i = 0;
        while (i < getallen.length){
            if (getallen[i] == zoekWaarde) {
                exists = true;
                i++;
            }
            else{
                i++;
            }
        }
        return exists;

    }


	public boolean zitErinB( int zoekWaarde ) {
        int i = 0;
        while (i < getallen.length) {
            if (getallen[i] == zoekWaarde) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

	public boolean zitErinC( int zoekWaarde ){
        sorteer();
        for(int i = 0 ;  i < getallen.length ; i++){
            System.out.println(getallen[i]);
        }
//        System.out.println("hoi" + getallen[(getallen.length/2)]);
        if(zoekWaarde >= getallen[(getallen.length/2)]) {
            for(int i = (getallen.length - 1) ; i > 0 ; i--){
//                System.out.println(getallen[i]);
                if(zoekWaarde == getallen[i]){
                    return true;
                }else if(getallen[i] < zoekWaarde){
                    break;
                }
            }
        }else{
            for(int i = 0 ; i < (getallen.length - 1) ; i++){
//                System.out.println(getallen[i]);
                if(zoekWaarde == getallen[i]){
                    return true;
                }else if(getallen[i] > zoekWaarde){
                    break;
                }
            }
        }
        return false;
	}

	public boolean zitErinD( int zoekWaarde ){

        int x = getallen.length/2;
        while(getallen[x] != zoekWaarde) {
            if(getallen[x] < zoekWaarde) {
                if(x == (int) Math.floor(x * 1.5)) {
                    return false;
                } else {
                    x = (int) Math.floor(x * 1.5);
                }
            } else if(getallen[x] > zoekWaarde){
                if(x == (int) Math.ceil(x / 2)) {
                    return false;
                } else {
                    x = (int) Math.ceil(x / 2);
                }
            }
        }
        return true;
	}
	
	public void sorteer(){
		Arrays.sort( getallen);
	}
	
	public void print(){
		for( int i=0; i<getallen.length; i++)
			System.out.println(getallen[i]);
	}

}
