public class Grill {
    private Burner burner = new Burner();
    public void cooking() {
	try {
	    burner.on();
	    addSteack();
	    addSalt();
	    addPepper();
	    while (! done) {
		checkSteack();
	    }
	} catch ( OutOfGazException e1 ) {
	    callRetailer();
	} catch ( FireException e2 ) {
	    extinguishFire();
	} finally {
	    burner.off();
	}
    }
}
