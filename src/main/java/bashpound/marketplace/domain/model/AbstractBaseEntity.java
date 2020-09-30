package bashpound.marketplace.domain.model;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 6104338203598967500L;

public abstract boolean equals(Object obj);

  public abstract int hashCode();

  public abstract String toString();

}
