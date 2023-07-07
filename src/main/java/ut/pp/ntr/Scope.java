package ut.pp.ntr;

import java.util.LinkedHashMap;
import java.util.Map;

/* Class combining the information of a single scope level. */
public class Scope {

    private int size;
    private final Map<String, Type> types;

    private final Map<String, Integer> offsets;

    public Scope(int size) {
        this.types = new LinkedHashMap<>();
        this.offsets = new LinkedHashMap<>();
        this.size += size;
    }

    /* Tests if a given identifier is declared in this scope. */
    public boolean contains(String id) {
        return this.types.containsKey(id);
    }

    /* Declares an identifier with a given type, if the identifier
     is not yet in this scope. */
    public boolean put(String id, Type type) {
        boolean result = !this.types.containsKey(id);
        if (result) {
            this.types.put(id, type);
            this.offsets.put(id, this.size);
            this.size += type.size();
        }
        return result;
    }

    // Returns the type of a given (presumably declared) identifier.
    public Type type(String id) {
        return this.types.get(id);
    }

    /** Returns the offset of a given (presumably declared) identifier.
     * with respect to the beginning of this scope's activation record.
     * Offsets are assigned in order of declaration.
     */
    public Integer offset(String id) {
        return this.offsets.get(id);
    }


    public Integer getSize() {
        return this.offsets.size();
    }

    public void setSize(int size) {
        this.size = this.size - size;
    }
}