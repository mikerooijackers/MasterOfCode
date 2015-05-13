package mocjms.messaging.requestreply;

import java.io.Serializable;

/**
 *
 * @author Maja Pesic
 */
public interface IRequestListener {
   public void receivedRequest(Serializable request);
}
