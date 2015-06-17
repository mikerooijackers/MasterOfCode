package Domein;

/**
 *
 * @author mikerooijackers
 */
public enum Role {
    ADMIN(0), TEAMMEMBER(1), INITIATOR(2), SPECTATOR(3);
    
    private long id;
    
    Role(long nr) {
        this.id = nr;
    }

    /**
     * get privelilege id
     * @return long
     */
    public long getId() {
        return id;
    }
}