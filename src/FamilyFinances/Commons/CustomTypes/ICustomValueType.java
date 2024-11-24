package FamilyFinances.Commons.CustomTypes;

import java.io.Serializable;

/**
 *
 * @author johnarrieta
 */
public interface ICustomValueType<V> extends Serializable, Comparable<V>{
    public V getValue();
}
