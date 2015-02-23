
public class SnelheidOefening {

	/**
	 * @param args
	 */
	public static void main( String[] args){

      //  long beginTijd;
       // boolean result[] = new boolean[10];
        GetalRij gr = new GetalRij( 10, 20);
     //   beginTijd = tijd();
     //   System.out.println("Start:" + beginTijd);
       // for(int i = 0 ; i < 10 ; i++){
            boolean zitErIn = gr.zitErinC(5);
            System.out.println(zitErIn);
     //   }
      //  System.out.println("Totaal: " + (tijd() - beginTijd));

      //  for(int j = 0 ; j < 10 ; j++){
      //      System.out.println(result[j]);
      //  }
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.currentTimeMillis();
	}

}
