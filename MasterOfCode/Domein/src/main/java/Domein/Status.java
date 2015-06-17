package Domein;

/**
 *
 * @author mikerooijackers
 */
public enum Status {
	waiting(0), playing(1), pause(2), freeze(3), stopped(4);
        
        private long id;
        
        Status(long id) {
            this.id = id;
        }

    /**
     * get status id
     * @return long
     */
    public long getId() {
        return id;
    }
        
}