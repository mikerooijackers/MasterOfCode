package Domein;

/**
 *
 * @author mikerooijackers
 */
public enum Privilege {
    admin(0), teamMember(1), initiator(2);
    
    private int id;
    
    Privilege(int nr) {
        this.id = nr;
    }

    /**
     * get privelilege id
     * @return int
     */
    public int getId() {
        return id;
    }
}