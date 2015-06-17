package domein;

/**
 *
 * @author mikerooijackers
 */
public enum Status {
	WAITING(0), PLAYING(1), PAUSE(2), FREEZE(3), STOP(4);
        
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