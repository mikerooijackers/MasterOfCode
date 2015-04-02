package Domein;

/**
 *
 * @author mikerooijackers
 */
public enum Status {
	waiting(0), playing(1), pause(2);
        
        private int id;
        
        Status(int id) {
            this.id = id;
        }

    /**
     * get status id
     * @return in
     */
    public int getId() {
        return id;
    }
        
}